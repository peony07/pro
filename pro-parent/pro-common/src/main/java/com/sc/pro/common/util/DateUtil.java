package com.sc.pro.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
	private static Log log=LogFactory.getLog(DateUtil.class.getName());
	public static final int DAYS_OF_WEEK = 7;
	public static final int DAYS_OF_MONTH = 30;
	public static final int DAYS_OF_QUARTER = 90;
	public static final int DAYS_OF_HALF_YEAR = 182;
	public static final int DAYS_OF_YEAR = 365; 
	
	/**
	 * 获取SimpleDateFormat
	 * 
	 * @param parttern
	 *            日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException
	 *             异常：非法日期格�?
	 */
	private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 获取日期中的某数值�?�如获取月份
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            日期格式
	 * @return 数�??
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}

	/**
	 * 增加日期中某类型的某数�?��?�如增加日期
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数�??
	 * @return 计算后日期字符串
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}

	/**
	 * 增加日期中某类型的某数�?��?�如增加日期
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数�??
	 * @return 计算后日�?
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * 获取精确的日�?
	 * 
	 * @param timestamps
	 *            时间long集合
	 * @return 日期
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况�?�如2012-11�?2012-11-01。时间戳是相等的
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					// 如果timestamps的size�?2，这是差值只有一个，因此要给默认�?
					minAbsoluteValue = absoluteValues.get(0);
				}
				for (int i = 0; i < absoluteValues.size(); i++) {
					for (int j = i + 1; j < absoluteValues.size(); j++) {
						if (absoluteValues.get(i) > absoluteValues.get(j)) {
							minAbsoluteValue = absoluteValues.get(j);
						} else {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);
					if (absoluteValues.size() > 1) {
						timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
					} else if (absoluteValues.size() == 1) {
						// 当timestamps的size�?2，需要与当前时间作为参照
						long dateOne = timestampsLastTmp[0];
						long dateTwo = timestampsLastTmp[1];
						if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
							timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
						} else {
							long now = new Date().getTime();
							if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
								timestamp = dateOne;
							} else {
								timestamp = dateTwo;
							}
						}
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * 判断字符串是否为日期字符�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return true or false
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (StringToDate(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/**
	 * 获取日期字符串的日期风格。失敗返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 日期风格
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			Date dateTmp = StringToDate(date, style.getValue());
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		dateStyle = map.get(getAccurateDate(timestamps).getTime());
		return dateStyle;
	}

	/**
	 * 将日期字符串转化为日期�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 日期
	 */
	public static Date StringToDate(String date) {
		DateStyle dateStyle = null;
		return StringToDate(date, dateStyle);
	}

	/**
	 * 将日期字符串转化为日期�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param parttern
	 *            日期格式
	 * @return 日期
	 */
	public static Date StringToDate(String date, String parttern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(parttern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/**
	 * 将日期字符串转化为日期�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dateStyle
	 *            日期风格
	 * @return 日期
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle == null) {
			List<Long> timestamps = new ArrayList<Long>();
			for (DateStyle style : DateStyle.values()) {
				Date dateTmp = StringToDate(date, style.getValue());
				if (dateTmp != null) {
					timestamps.add(dateTmp.getTime());
				}
			}
			myDate = getAccurateDate(timestamps);
		} else {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/**
	 * 将日期转化为日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param parttern
	 *            日期格式
	 * @return 日期字符�?
	 */
	public static String DateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/**
	 * 将日期转化为日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param dateStyle
	 *            日期风格
	 * @return 日期字符�?
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}
	public static Timestamp dateToTimestamp(Date date){
		Timestamp ts = new Timestamp(date.getTime()); 
		return ts;
	}
	public static String timestampToString(Timestamp time){
		return time.toString();
	}
	/**
	 * 将日期字符串转化为另�?日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param parttern
	 *            新日期格�?
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String parttern) {
		return StringToString(date, null, parttern);
	}

	/**
	 * 将日期字符串转化为另�?日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param dateStyle
	 *            新日期风�?
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle dateStyle) {
		return StringToString(date, null, dateStyle);
	}
	
	/**
	 * 按格式和语言转换日期
	 */
	public static String StringToString(String date, String parttern,Locale local ) {
		SimpleDateFormat sdf = new SimpleDateFormat(parttern,local);
		return sdf.format(StringToDate(date));
	}


	/**
	 * 将日期字符串转化为另�?日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddParttern
	 *            旧日期格�?
	 * @param newParttern
	 *            新日期格�?
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, String olddParttern, String newParttern) {
		String dateString = null;
		if (olddParttern == null) {
			DateStyle style = getDateStyle(date);
			if (style != null) {
				Date myDate = StringToDate(date, style.getValue());
				dateString = DateToString(myDate, newParttern);
			}
		} else {
			Date myDate = StringToDate(date, olddParttern);
			dateString = DateToString(myDate, newParttern);
		}
		return dateString;
	}

	/**
	 * 将日期字符串转化为另�?日期字符串�?�失败返回null�?
	 * 
	 * @param date
	 *            旧日期字符串
	 * @param olddDteStyle
	 *            旧日期风�?
	 * @param newDateStyle
	 *            新日期风�?
	 * @return 新日期字符串
	 */
	public static String StringToString(String date, DateStyle olddDteStyle, DateStyle newDateStyle) {
		String dateString = null;
		if (olddDteStyle == null) {
			DateStyle style = getDateStyle(date);
			dateString = StringToString(date, style.getValue(), newDateStyle.getValue());
		} else {
			dateString = StringToString(date, olddDteStyle.getValue(), newDateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 增加日期的年份�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负�?
	 * @return 增加年份后的日期字符�?
	 */
	public static String addYear(String date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 增加日期的年份�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负�?
	 * @return 增加年份后的日期
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 增加日期的月份�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负�?
	 * @return 增加月份后的日期字符�?
	 */
	public static String addMonth(String date, int yearAmount) {
		return addInteger(date, Calendar.MONTH, yearAmount);
	}

	/**
	 * 增加日期的月份�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负�?
	 * @return 增加月份后的日期
	 */
	public static Date addMonth(Date date, int yearAmount) {
		return addInteger(date, Calendar.MONTH, yearAmount);
	}

	/**
	 * 增加日期的天数�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加天数后的日期字符�?
	 */
	public static String addDay(String date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}
	
	/**
	* 此方法描述的是：获取明天
	* @author: peony zhangtao@misquest.com
	* @param date
	* @return
	*/
		
	public static Date getNetDay(Date date) {
		return addInteger(date, Calendar.DATE, 1);
	}

	/**
	 * 增加日期的天数�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加天数后的日期
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}
	
	/**
	* 此方法描述的是：租赁日期增加
	* @author: peony zhangtao@misquest.com
	* @param date
	* @param dayAmount
	* @return
	*/
		
	public static Date addLeaseDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount-1);
	}

	/**
	 * 增加日期的小时�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加小时后的日期字符�?
	 */
	public static String addHour(String date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的小时�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加小时后的日期
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的分钟�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加分钟后的日期字符�?
	 */
	public static String addMinute(String date, int hourAmount) {
		return addInteger(date, Calendar.MINUTE, hourAmount);
	}

	/**
	 * 增加日期的分钟�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加分钟后的日期
	 */
	public static Date addMinute(Date date, int hourAmount) {
		return addInteger(date, Calendar.MINUTE, hourAmount);
	}

	/**
	 * 增加日期的秒钟�?�失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加秒钟后的日期字符�?
	 */
	public static String addSecond(String date, int hourAmount) {
		return addInteger(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * 增加日期的秒钟�?�失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负�?
	 * @return 增加秒钟后的日期
	 */
	public static Date addSecond(Date date, int hourAmount) {
		return addInteger(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * 获取日期的年份�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 年份
	 */
	public static int getYear(String date) {
		return getYear(StringToDate(date));
	}

	/**
	 * 获取日期的年份�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/**
	 * 获取日期的月份�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 月份
	 */
	public static int getMonth(String date) {
		return getMonth(StringToDate(date));
	}

	/**
	 * 获取日期的月份�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH)+1;
	}

	/**
	 * 获取日期的天数�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return �?
	 */
	public static int getDay(String date) {
		return getDay(StringToDate(date));
	}

	/**
	 * 获取日期的天数�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return �?
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}

	/**
	 * 获取日期的小时�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 小时
	 */
	public static int getHour(String date) {
		return getHour(StringToDate(date));
	}

	/**
	 * 获取日期的小时�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return 小时
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的分钟�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 分钟
	 */
	public static int getMinute(String date) {
		return getMinute(StringToDate(date));
	}

	/**
	 * 获取日期的分钟�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期的秒钟�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 秒钟
	 */
	public static int getSecond(String date) {
		return getSecond(StringToDate(date));
	}

	/**
	 * 获取日期的秒钟�?�失败返�?0�?
	 * 
	 * @param date
	 *            日期
	 * @return 秒钟
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/**
	 * 获取日期 。默认yyyy-MM-dd格式。失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 日期
	 */
	public static String getDate(String date) {
		return StringToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * 获取日期。默认yyyy-MM-dd格式。失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @return 日期
	 */
	public static String getDate(Date date) {
		return DateToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * 获取日期的时间�?�默认HH:mm:ss格式。失败返回null�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @return 时间
	 */
	public static String getTime(String date) {
		return StringToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * 获取日期的时间�?�默认HH:mm:ss格式。失败返回null�?
	 * 
	 * @param date
	 *            日期
	 * @return 时间
	 */
	public static String getTime(Date date) {
		return DateToString(date, DateStyle.HH_MM_SS);
	}

	/**
	 * 获取两个日期相差的天�?
	 * 
	 * @param date
	 *            日期字符�?
	 * @param otherDate
	 *            另一个日期字符串
	 * @return 相差天数=otherDate-date
	 */
	public static int getIntervalDays(String date, String otherDate) {
		return getIntervalDays(StringToDate(date), StringToDate(otherDate));
	}

	/**
	 * @param date
	 *            日期
	 * @param otherDate
	 *            另一个日�?
	 * @return 相差天数
	 */
	public static int getIntervalDays(Date date, Date otherDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long time1 = cal.getTimeInMillis();
		cal.setTime(otherDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days))+1;

	}

	public static int getleanIntervalDays(Date date, Date otherDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long time1 = cal.getTimeInMillis();
		cal.setTime(otherDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));

	}
	
	public static Timestamp DateToTimestamp(Date date) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			String dateStr = DateToString(date, DateStyle.YYYY_MM_DD_HH_MM_SS);
			ts = Timestamp.valueOf(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	public static Timestamp StringToTimestamp(String dateStr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			ts = Timestamp.valueOf(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	public static int calDayByYearAndMonth(Date date) {
		return calDayByYearAndMonth(getYear(date), getMonth(date));
	}

	public static int calDayByYearAndMonth(int dyear, int dmouth) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM");
		Calendar rightNow = Calendar.getInstance();
		try {
			String dmonString = "";
			if (dmouth < 10) {
				dmonString = "0" + dmouth;
			} else {
				dmonString = new Integer(dmouth).toString();
			}
			rightNow.setTime(simpleDate.parse(dyear + "-" + dmonString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);// 根据年月 获取月份天数
	}

	public static int getIntervalHours(Timestamp startTime, Timestamp endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endTime);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 );
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	public static int getIntervalMinites(Timestamp startTime, Timestamp endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endTime);
		long time2 = cal.getTimeInMillis();
		long between_Minites = (time2 - time1) / (1000 * 60 );
		return Integer.parseInt(String.valueOf(between_Minites));
	}

	public static int getIntervalSeconds(Timestamp startTime, Timestamp endTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endTime);
		long time2 = cal.getTimeInMillis();
		long between_Minites = (time2 - time1) / (1000);
		return Integer.parseInt(String.valueOf(between_Minites));
	}

	
	/**
	* 此方法描述的是：�?始日期加几周
	* @author: peony zhangtao@misquest.com
	* @param startDate
	* @param weeks
	* @return
	*/
		
	public static Date addLeaseWeek(String startDate,Integer weeks){
		Date start=StringToDate(startDate, DateStyle.YYYY_MM_DD);
		int days=weeks*DAYS_OF_WEEK;
		Date end=addLeaseDay(start, days);
		return end;
	}
	
	/**
	* 此方法描述的是：�?始日期加几周
	* @author: peony zhangtao@misquest.com
	* @param startDate
	* @param weeks
	* @return
	*/
		
	public static Date addLeaseWeek(Timestamp lastLeaseEndTime,Integer weeks){
		int days=weeks*DAYS_OF_WEEK;
		Date end=addLeaseDay(lastLeaseEndTime, days);
		return end;
	}
	/**
	 * 获取�?后的截止日期
	 * @param startDate
	 * @param weeks
	 * @return String
	 */
	public static String getLeaseEndDate(String startDate,Integer weeks){
		Date date = addLeaseWeek(startDate, weeks);
		return getDate(date);
	}

	/**
	* 此方法描述的是：获取上期截止日加�?个月减一天的日期
	* @author: peony zhangtao@misquest.com
	* @param lastLeaseEndTime
	* @param reRentNum
	* @return
	*/
		
	public static Date addLeaseMonth(Timestamp lastLeaseEndTime, int reRentNum) {
		return addDay(addMonth(lastLeaseEndTime, reRentNum),-1);
	}
	
	public static String getCustomDateString(Date date){
	    SimpleDateFormat tmp = new SimpleDateFormat("MMMM d");

	    String str = tmp.format(date);
	    str = str.substring(0, 1).toUpperCase() + str.substring(1);

	    if(date.getDate()>10 && date.getDate()<14)
	        str = str + "th, ";
	    else{
	        if(str.endsWith("1")) str = str + "st, ";
	        else if(str.endsWith("2")) str = str + "nd, ";
	        else if(str.endsWith("3")) str = str + "rd, ";
	        else str = str + "th, ";
	    }

	    tmp = new SimpleDateFormat("yyyy");
	    str = str + tmp.format(date);

	    return str;
	}
	/**
	 * 获取英文根式的日�? ‘Jan 26, 2015�?
	 * @param date
	 * @return
	 */
	public static String getEnglishDateFormat(Date date){
		DateFormat fm=DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.ENGLISH); 
		String datestr=fm.format(date);
		System.out.println(datestr);
		String dateArray[]=datestr.split(",");
		log.info("dateArray[]==="+dateArray);
//		for(int i=0;i<dateArray.length;i++){
//			System.out.println("==="+dateArray[i]+"====");
//		}
		String str=dateArray[0];
		
		if(str.endsWith("1")) str = str + "st,";
        else if(str.endsWith("2")) str = str + "nd,";
        else if(str.endsWith("3")) str = str + "rd,";
        else str = str + "th,";
		return str+dateArray[1];
	}
	/**
	 * 获取传�?�的日期�?在月份的第一�?
	 * 格式【yyyy-MM-dd�?
	 */
	public static String getFirstDay(Date date){
		 //获取当前月第�?天：
        Calendar c = Calendar.getInstance();
        // 设置时间,当前时间不用设置
		c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置�?1�?,当前日期既为本月第一�? 
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		log.info("***********"+ format.format(c.getTime())+"***********");
		return  format.format(c.getTime());
	}
	/**
	 * 获取传�?�的日期�?在月份的�?后一�?
	 * 格式【yyyy-MM-dd�?
	 */
	public static String getLastDay(Date date){
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		// 设置时间,当前时间不用设置
		calendar.setTime(date);
		// 设置日期为本月最大日�?
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		// 打印 
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		log.info("***********"+format.format(calendar.getTime())+"***********");
		return format.format(calendar.getTime());
	}
	/**
	 * 传�?�开始时间与截止时间，获取到中间的所有月份[2015-01]格式
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws Exception
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) throws Exception{
	    ArrayList<String> result = new ArrayList<String>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
	    
	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();
	    
	    min.setTime(sdf.parse(minDate));
	    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
	    
	    max.setTime(sdf.parse(maxDate));
	    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
	    
	    Calendar curr = min;
	    while(curr.before(max)){
	    	result.add(sdf.format(curr.getTime()));
	    	curr.add(Calendar.MONTH, 1);
	    }
	    log.info("***********"+result+"***********");
	    return result;
	  }
	/**
	 * 判断�?段日期是否有包括在春节期间内
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean isBetweenSpell(Date start,Date end){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date newYeadStart = sdf.parse("2015-02-17 23:59:59");
			Date newYeadEnd = sdf.parse("2015-02-24 23:59:59");
			if(start.before(newYeadStart)&&end.after(newYeadStart)){
				return true;
			}else if(start.before(newYeadEnd)&&end.after(newYeadStart)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<String> getMonthList(String beginTime, String endTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
		List<String> monthList = new ArrayList<String>();
		try {
			Date begin = format.parse(beginTime);
			Date end = format.parse(endTime);
			int months = (end.getYear() - begin.getYear()) * 12 + (end.getMonth() - begin.getMonth());
			for (int i = 0; i <= months; i++) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(begin);
				calendar.add(Calendar.MONTH, i);
				monthList.add(monthFormat.format(calendar.getTime()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return monthList;
	}
	
	
	/**
	 * 
	 * @param date1 <String>
	 * @param date2 <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2)
			throws ParseException {

		int result = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		
		int year = 0;
		if(c2.get(Calendar.YEAR)- c1.get(Calendar.YEAR) > 0){
			year = c2.get(Calendar.YEAR)- c1.get(Calendar.YEAR);
		}
		result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);
		result = result + year * 12;
		return result == 0 ? 1 : result;

	}

	
	public static void main(String[] args) {
		/*String minDate="2015-01";
		String maxDate="2015-03";
		try{
			System.out.println(getMonthBetween(minDate, maxDate));
		}catch(Exception e){
	    	e.printStackTrace();
	    }
		getFirstDay(DateUtil.StringToDate(maxDate));
		getLastDay(DateUtil.StringToDate(maxDate));*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = sdf.parse("2015-01-14");
			Date end = sdf.parse("2015-02-18");
			boolean flat = DateUtil.isBetweenSpell(start, end);
			System.out.println(flat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
