package com.sc.pro.common.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author SunChaoqun
 * 
 */

public class COMMON {
	/**
	 * 日期格式：yyyy-MM-dd
	 */
	public static final String DATA_FORMAT = "yyyy-MM-dd";

	private static final String[] DATA_FORMAT_SPLIT = DATA_FORMAT.split("-");

	/**
	 * 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DF = "#,##0.00";

	public static final String PER = "#,##0.00%";

	private static String uid = "0";

	public static String TABLE_STYLE = "cellpadding=\"0\" cellspacing=\"0\"";

	public static String message = "";

	/**
	 * 是否最新信息：newflag：最新；oldflag:旧信息；
	 */
	public static String NEWFLAG = "1";

	public static String OLDFLAG = "2";

	/**
	 * 数据库操作动作：创建
	 */
	public static int OPERATE_CREATE = 1;

	/**
	 * 数据库操作动作：删除
	 */
	public static int OPERATE_REMOVE = 2;

	/**
	 * 数据库操作动作：更新
	 */
	public static int OPERATE_UPDATE = 3;

	private static Map attachMap;

	public static HashMap hmap;

	static {

		attachMap = new HashMap();

		hmap = new HashMap();
		hmap.put("一月", new Integer(1));
		hmap.put("二月", new Integer(2));
		hmap.put("三月", new Integer(3));
		hmap.put("四月", new Integer(4));
		hmap.put("五月", new Integer(5));
		hmap.put("六月", new Integer(6));
		hmap.put("七月", new Integer(7));
		hmap.put("八月", new Integer(8));
		hmap.put("九月", new Integer(9));
		hmap.put("十月", new Integer(10));
		hmap.put("十一月", new Integer(11));
		hmap.put("十二月", new Integer(12));
	}

	public static String getMessage() {
		return message;
	}

	/**
	 * 判断某个对象是否为空 集合类、数组做特殊处理
	 * 
	 * @param obj
	 * @return 如为空，返回true,否则false
	 * @author yehailong
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;

		// 如果不为null，需要处理几种特殊对象类型
		if (obj instanceof String) {
			if ("null".equals(((String) obj).toLowerCase())) {
				return false;
			} else {
				return ((String) obj).trim().equals("");
			}
		} else if (obj instanceof Collection) {
			// 对象为集合
			Collection coll = (Collection) obj;
			return coll.size() == 0;
		} else if (obj instanceof Map) {
			// 对象为Map
			Map map = (Map) obj;
			return map.size() == 0;
		} else if (obj.getClass().isArray()) {
			// 对象为数组
			return Array.getLength(obj) == 0;
		} else {
			// 其他类型，只要不为null，即不为empty
			return false;
		}
	}

	/**
	 * 字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDigitalString(String str) {
		if (isEmpty(str)) {
			return false;
		} else {
			try {
				Double.parseDouble(str);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 只显示特定长度字符串，如果超过len，使用title来显示全部内容
	 * 
	 * @param value
	 *            字符串值
	 * @param len
	 *            显示长度
	 * @return
	 */
	public static String showValue(String value, int len) {
		if (COMMON.isEmpty(value)) {
			return "&nbsp;";
		}
		if (value.length() <= len) {
			return value;
		}
		StringBuffer buf = new StringBuffer("<span title='" + value + "'>");
		buf.append(value.substring(0, len));
		buf.append("...</span>");

		return buf.toString();
	}

	/**
	 * 类似如String.indexOf函数，获取对象在数组中的位置，如无，返回-1
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public static int arrayIndexOf(Object array, Object value) {
		if (array == null || value == null) {
			return -1;
		}
		int len = Array.getLength(array);
		for (int i = 0; i < len; i++) {
			if (value.equals(Array.get(array, i))) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 集合转换成MAP
	 * 
	 * @param cl
	 *            集合
	 * @param keyProp
	 *            KEY属性名
	 * @return
	 */
	public static Map collection2map(Collection cl, String keyProp) {
		if (isEmpty(cl)) {
			return new HashMap();
		}
		Iterator it = cl.iterator();
		Map map = new HashMap();
		while (it.hasNext()) {
			Object value = it.next();
			if (value instanceof Map) {
				Map temp = (Map) value;
				try {
					map.put(temp.get(keyProp), value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					map.put(PropertyUtils.getProperty(value, keyProp), value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	/**
	 * 取时间差
	 * 
	 * @param timestamp1
	 * @param timestamp2
	 * @param showSecond
	 *            是否显示秒
	 * @return
	 */
	public static String getTimeInterval(Timestamp timestamp1, Timestamp timestamp2, boolean showSecond) {
		if (timestamp1 == null || timestamp2 == null)
			return "";
		StringBuffer buf = new StringBuffer();
		long time1 = timestamp1.getTime();
		long time2 = timestamp2.getTime();
		long time = Math.abs(time1 - time2);
		// day
		long day = time / (24 * 60 * 60 * 1000L);
		// hour
		time = time - day * 24 * 60 * 60 * 1000L;
		long hour = time / (60 * 60 * 1000L);
		// minute
		time = time - hour * 60 * 60 * 1000L;
		long minute = time / (60 * 1000L);
		// second
		time = time - minute * 60 * 1000L;
		long second = time / 1000L;

		if (day != 0) {
			buf.append(day + "天");
		}
		if (hour != 0) {
			buf.append(hour + "时");
		}
		if (minute != 0) {
			buf.append(minute + "分");
		}

		if (showSecond || buf.length() == 0) {
			if (second != 0) {
				buf.append(second + "秒");
			}
		}

		return buf.toString();
	}

	/**
	 * 转换字符串至HTML格式
	 * 
	 * @param src
	 * @return
	 */
	public static String toHtmlStr(String src) {
		if (src == null || src.length() == 0)
			return "";
		int i;
		StringBuffer aimStrBuf = new StringBuffer();
		StringBuffer resStrBuf = new StringBuffer(src);
		int strLength = resStrBuf.length();
		char tmpChar = 0;
		for (i = 0; i < strLength; i++) {
			tmpChar = resStrBuf.charAt(i);
			if (tmpChar == '<') {
				aimStrBuf.append(new char[] { '&', 'l', 't', ';' });
			} else if (tmpChar == '<') {
				aimStrBuf.append(new char[] { '&', 'g', 't', ';' });
			} else if (tmpChar == '\n') {
				aimStrBuf.append(new char[] { '<', 'b', 'r', '>' });
			} else if (tmpChar == '\r') {
			} else if (tmpChar == '\t') {
				aimStrBuf.append(new char[] { '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';', '&', 'n', 'b', 's', 'p', ';' });
			} else if (tmpChar == ' ') {
				aimStrBuf.append(new char[] { '&', 'n', 'b', 's', 'p', ';' });
			} else if (tmpChar == '"') {
				aimStrBuf.append(new char[] { '\\', '“' });
			} else if (tmpChar == '\'') {
				aimStrBuf.append(new char[] { '\\', '\'' });
			} else if (tmpChar == '\\') {
				aimStrBuf.append(new char[] { '\\', '\\' });
			} else {
				aimStrBuf.append(tmpChar);
			}
		}
		return aimStrBuf.toString();
	}

	/*
	 * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp） @param dateString 需要转换为timestamp的字符串 @return dataTime timestamp
	 */
	public static Timestamp string2Time(String dateString) throws java.text.ParseException {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}

	/**
	 * 转换日期为Timestamp
	 */
	public static Timestamp toTimestamp() {

		return new Timestamp(new Date().getTime());
	}

	/**
	 * 字符串伪变量替换
	 *
	 * @param input
	 * @param reservedWords
	 * @return
	 */
	public static String replace(String input, Map reservedWords) {
		if (reservedWords == null || reservedWords.isEmpty() || COMMON.isEmpty(input))
			return input;
		StringBuffer result = new StringBuffer(200);
		StringBuffer buff = new StringBuffer(20);
		for (int index = 0; index < input.length(); index++) {
			char c = input.charAt(index);
			if (c == '{') {
				result.append(buff.substring(0, buff.length()));
				buff.delete(0, buff.length());
				buff.append(c);
			} else if (c == '}') {
				buff.append(c);
				String key = buff.substring(0, buff.length());
				String value = (String) reservedWords.get(key);
				if (value != null) {
					result.append(value);
				} else {
					result.append(key);
				}
				buff.delete(0, buff.length());
			} else {
				buff.append(c);
			}
		}
		result.append(buff);
		return result.toString();
	}

	/**
	 * 获取字符串的伪变量
	 *
	 * @param input
	 * @return
	 *
	 */
	public static Map getParam(String input) {
		StringBuffer buff = new StringBuffer(20);
		Map paramMap = new HashMap();
		for (int index = 0; index < input.length(); index++) {
			char c = input.charAt(index);
			if (c == '{') {
				buff.delete(0, buff.length());
				buff.append(c);
			} else if (c == '}') {
				buff.append(c);
				String key = buff.substring(0, buff.length());
				paramMap.put(key, key);
			} else {
				buff.append(c);
			}
		}
		return paramMap;
	}

	public static String getRandomString(int size) {
		char[] c = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; ++i)
			sb.append(c[(Math.abs(random.nextInt()) % c.length)]);

		return sb.toString();
	}

	public static String getRandomString1(int size) {
		char[] c = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < size; ++i)
			sb.append(c[(Math.abs(random.nextInt()) % c.length)]);

		return sb.toString();
	}

	/**
	 * 把String转成unicode用于比如WebSphere 传JSON的乱码问题， 一般配合前台pccw.js的unicodeToString 或者后台COMMON的unicodeToString方法
	 *
	 * @param str 要转的String.
	 * @return String 转过的unicode.
	 *
	 */
	public static String stringToUnicode(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer();
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8);
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF);
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);

		}
		return (new String(sb));
	}

	/**
	 * 把unicode转成String用于比如WebSphere传JSON的乱码问题， 一般配合前台pccw.js的stringToUnicode 或者后台COMMON的stringToUnicode方法
	 *
	 * @param str
	 *            要转的unicode.
	 * @return String 转过的String.
	 *
	 */
	public static String unicodeToString(String str) {
		str = (str == null ? "" : str);
		if (str.indexOf("\\u") == -1)
			return str;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= str.length() - 6;) {
			String strTemp = str.substring(i, i + 6);
			String value = strTemp.substring(2);
			int c = 0;
			for (int j = 0; j < value.length(); j++) {
				char tempChar = value.charAt(j);
				int t = 0;
				switch (tempChar) {
				case 'a':
					t = 10;
					break;
				case 'b':
					t = 11;
					break;
				case 'c':
					t = 12;
					break;
				case 'd':
					t = 13;
					break;
				case 'e':
					t = 14;
					break;
				case 'f':
					t = 15;
					break;
				default:
					t = tempChar - 48;
					break;
				}

				c += t * ((int) Math.pow(16, (value.length() - j - 1)));
			}
			sb.append((char) c);
			i = i + 6;
		}
		return sb.toString();
	}

	final static SimpleDateFormat sf = new SimpleDateFormat(TIME_FORMAT);

	public static String fmtNum(String number)

	{
		String result = number;
		String pointResult = "";
		try {
			if (number.indexOf(".") > 0) {
				String[] results = number.split("\\.");
				result = results[0];
				pointResult = "." + results[1];
			}
			if ((number != null) && (!"".equals(number)) && (!"null".equals(number))) {
				DecimalFormat df = new DecimalFormat();
				df.applyPattern("0,000");
				if (result.length() > 3)

					result = df.format(Double.parseDouble(result));
			} else {
				result = "";
			}
		} catch (Exception e) {

		}
		return result + pointResult;
	}

	/**
	 * 小数转成百分比
	 * */
	public static String decimalPercentage(Object number) {

		String num = "";
		if (number != null && !"".equals(number) && !"null".equals(number)) {
			NumberFormat nt = NumberFormat.getPercentInstance();
			nt.setMaximumFractionDigits(2);
			num = nt.format(number);

		} else {
			number = "";
		}
		return num;
	}

	/**
	 * 金额转换为大写
	 *
	 * @param number
	 *            需要转换的金额
	 * @return
	 */
	public static String changeToBig(String number) {
		double value = 0;
		if (number != null && !"".equals(number) && !"null".equals(number)) {
			value = Double.parseDouble(number);
		} else {
			return "";
		}
		if (("" + value).length() > 12) {
			return "数额过大";
		}
		char[] hunit = { '拾', '佰', '仟' };
		char[] vunit = { '万', '亿' };
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		long midVal = (long) (value * 100);// 转化成整形
		String valStr = String.valueOf(midVal);// 转化成字符串
		String head = valStr.substring(0, valStr.length() - 2);// 取整数部分
		String rail = valStr.substring(valStr.length() - 2);// 取小数部分
		String prefix = "";// 整数部分
		String suffix = "";// 小数部分
		// 处理小数点后面的数
		if (rail.equals("00")) {
			// 如果小数部分为0
			suffix = "整";
		} else {
			// 否则把角分转化出来
			suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分";
		}
		// 处理整数部分
		char[] chDig = head.toCharArray();// 把整数部分转化成字符数组
		char zero = '0';// 标志'0'表示出现过0
		byte zeroSerNum = 0;// 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) {
			// 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4;
			// 取段内位置
			int vidx = (chDig.length - i - 1) / 4;
			// 取段位置
			if (chDig[i] == '0') {
				// 如果当前字符是0
				zeroSerNum++;
				// 连续0次数递增
				if (zero == '0') {
					// 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0;
			// 连续0次数清零
			if (zero != '0') {
				// 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0'];
			// 转化该数字表示
			if (idx > 0)
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1];
				// 段结束位置应该加上段名如万,亿
			}
		}
		if (prefix.length() > 0)
			prefix += '圆';
		// 如果整数部分存在,则有圆的字样
		return prefix + suffix;
		// 返回正确表示
	}

	/**
	 * 转换金额（金额乘以转换率）
	 *
	 * 取得数字的最大精度, 既小数点后的位数
	 *
	 * @param amount
	 * @param conversionRate
	 * @return
	 */
	public static String countAmount4MulRate(String amount, String conversionRate) {
		int DOUBLE_FRACTION_DIGITS = 340;
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(DOUBLE_FRACTION_DIGITS);
		if (amount == null) {
			return null;
		}
		BigDecimal result = new BigDecimal(amount).multiply(new BigDecimal(conversionRate));
		int scale = Math.max(getMaxScale(amount), getMaxScale(conversionRate));
		result = result.setScale(scale, BigDecimal.ROUND_HALF_UP);
		numberFormat.format(result);
		return numberFormat.format(result);
		// return result.setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 取得数字的最大精度, 既小数点后的位数
	 *
	 * @param number
	 * @return
	 */
	public static int getMaxScale(Object number) {
		return getMaxScale(String.valueOf(number));
	}

	/**
	 * 取得数字的最大精度, 既小数点后的位数
	 *
	 * @param number
	 *            200000.0200 10000.0
	 * @return 2,000,000,200
	 */
	public static int getMaxScale(String number) {
		if (number != null) {
			try {
				number = number.trim();
				Double.parseDouble(number);
				if (number.indexOf(".") < 0) {
					return 0;
				}
				return number.length() - number.indexOf(".") - 1;
			} catch (Throwable t) {
				// do nothing
			}
		}
		return 0;
	}

	/**
	 * 转换金额（金额除以转换率）
	 *
	 * @param amount
	 *            200000.0200
	 * @param conversionRate
	 *            10000.0
	 * @return 20.000002
	 */
	public static String countAmount4DivRate(String amount, String conversionRate) {
		if (amount == null) {
			return null;
		}
		String result = amount;
		// by zhangjunwu 修改金额除以转换率不能整除时报错的问题
		try {
			result = (new BigDecimal(amount)).divide(new BigDecimal(conversionRate), BigDecimal.ROUND_UNNECESSARY).toString();
		} catch (ArithmeticException e) {
			result = (new BigDecimal(amount)).divide(new BigDecimal(conversionRate)).toString();
		}
		return result;
	}

	/**
	 * 格式化金额
	 *
	 * @param num
	 * @return
	 */

	public static String formatAmount(String num) {
		BigDecimal number = new BigDecimal(num);
		int DOUBLE_FRACTION_DIGITS = 340;
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(DOUBLE_FRACTION_DIGITS);
		return numberFormat.format(number);
	}

	public static String formatAmount(String num, String decimalPlace) {
		BigDecimal number = new BigDecimal(num);
		int DOUBLE_FRACTION_DIGITS = 340;
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(DOUBLE_FRACTION_DIGITS);
		numberFormat.setMinimumFractionDigits(new Integer(decimalPlace).intValue());
		return numberFormat.format(number);
	}

	/**
	 * 对前台加密过的uri进行解密
	 *
	 * @param URI
	 * @return
	 * @throws Exception
	 *
	 */
	public static String DecryptionURI(String URI) throws Exception {
		String uri = "";
		uri = java.net.URLDecoder.decode(java.net.URLDecoder.decode(URI, "utf-8"), "utf-8");
		return uri;
	}

	// 删除文件夹
	// param folderPath 文件夹完整绝对路径

	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除指定文件夹下所有文件
	// param path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	public static void main(String[] args) {

	}

}
