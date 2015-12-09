package com.sc.pro.business.common.util;


public class Constants {
	public static final String YES = "Y";

	public static final String NO = "N";

	public static final String TRUE = "true";

	public static final String FALSE = "false";
	
	public static final String REBATE = "_REBATE";

	/**
	 * 默认币种
	 * 
	 */
	public static final String DEFAULT_CURRENY_CODE = "CNY";
	public static final String DEFAULT_CURRENY_POINT = "POINT";
	/**
	 * 逗号
	 */
	public static final String COMMA = ",";
	/**
	 * 百分号
	 */
	public static final String PERCENT = "%";

	/**
	 * 产品状态
	 */
	public static final String PRODUCT_STATUS_ALREADY_TENANCY = "ALREADY_TENANCY";// 已出租
	public static final String PRODUCT_STATUS_BOOKING_FREEZING = "BOOKING_FREEZING";// 已预定冻结
	public static final String PRODUCT_STATUS_INVALID = "INVALID";// 已作废
	public static final String PRODUCT_STATUS_OFFLINE = "OFFLINE";// 已下线
	public static final String PRODUCT_STATUS_PTLY_PD = "PTLY_PD";// 部分已支付
	public static final String PRODUCT_STATUS_PUBLISHED = "PUBLISHED";// 对外发布
	public static final String PRODUCT_STATUS_INTERNAL_PUBLISHED = "INTERNAL_PUBLISHED";// 对内发布
	public static final String PRODUCT_STATUS_UNPUBLISHED = "UNPUBLISHED";// 未发布

	/**
	 * 产品分类
	 */
	public static final String PRODUCT_CATEGORY_HOUSES = "HOUSES";// 房屋型
	public static final String PRODUCT_CATEGORY_SERVICE = "SERVICE";// 服务型
	/**
	 * 产品大类
	 */
	public static final String LARGE_CLASS_MEETING_ROOM = "MEETING_ROOM";// 会议室
	public static final String LARGE_CLASS_PRINT = "PRINT";// 打印
	public static final String LARGE_CLASS_ROOM = "ROOM";// 独立房间
	public static final String LARGE_CLASS_OPEN_STATION = "OPEN_STATION";// 开放式工位
	public static final String LARGE_CLASS_SHARED_STATION = "SHARED_STATION";// 合租型工位
	public static final String LARGE_CLASS_SCORE = "SCORE";// 积分
	public static final String LARGE_CLASS_GOLD = "GOLD";// 金币
	public static final String LARGE_CLASS_DEPOSIT = "DEPOSIT";//保证金
	/**
	 * 产品小类
	 */
	public static final String SUB_CLASS_DOUBLE_ROOM = "DOUBLE_ROOM";// 两人间
	public static final String SUB_CLASS_QUAD_ROOM = "QUAD_ROOM";// 四人间
	public static final String SUB_CLASS_SINGLE_ROOM = "SINGLE_ROOM";// 单人间
	public static final String SUB_CLASS_TRIPLE_ROOM = "TRIPLE_ROOM";// 三人间
	public static final String SUB_CLASS_TRIPLE_PRINT_SCORE = "PRINT_SCORE";// 打印积分
	public static final String SUB_CLASS_TRIPLE_MEETING_ROOM_SCORE = "MEETING_ROOM_SCORE";// 会议室积分
	public static final String SUB_CLASS_TRIPLE_MEETING_SHARE_SCORE = "SHARE_SCORE";// 共用积分
	public static final String SUB_CLASS_SHARE_CASH = "SHARE_CASH";// 共用现金
	public static final String SUB_CLASS_MEETING_ROOM_HOUR = "MEETING_ROOM_HOUR";// 会议室小时
	public static final String SUB_CLASS_PRINT_PAPER = "PRINT_PAPER";// 打印纸张
	public static final String SUB_CLASS_DEDUCTION = "DEDUCTION";// 扣款
	public static final String SUB_CLASS_COMPANY_REG = "COMPANY_REG";// 工商注册保证金
	/**
	 * 付款周期
	 */
	public static final String PAYMENT_PERIOD_HALF_YEAR = "HALF_YEAR";// 半年
	public static final String PAYMENT_PERIOD_MONTH = "MONTH";// 月
	public static final String PAYMENT_PERIOD_QUARTER = "QUARTER";// 季度
	public static final String PAYMENT_PERIOD_YEAR = "YEAR";// 年
	public static final String PAYMENT_PERIOD_ALL = "ALL";// 一次性 
	/**
	 * 订单头类型
	 */
	public static final String ORDER_CATEGORY_HOUSE_OR_STATION = "HOUSE_OR_STATION";// 房间或工位预订
	public static final String ORDER_CATEGORY_MEETING_ROOM = "MEETING_ROOM";// 会议室预订
	public static final String ORDER_CATEGORY_POINTS = "POINTS";// 积分充值
	public static final String ORDER_CATEGORY_PRINTER = "PRINTER";// 打印复印
	public static final String ORDER_CATEGORY_CASH = "CASH";// 现金充值
	public static final String ORDER_CATEGORY_DEPOSIT = "COMPANY_REG_DEPOSIT";// 工商注册保证金
	
	public static final String ORDER_CATEGORY_REFUND_CASH = "REFUND_CASH";
	public static final String ORDER_CATEGORY_REFUND_REND = "REFUND_REND";
	public static final String ORDER_CATEGORY_EXPECT = "EXPECT";
	public static final String ORDER_CATEGORY_REFUND_DEPOSIT = "REFUND_DEPOSIT";//退保证金
	/**
	 * 订单头类别
	 */
	public static final String ORDER_TYPE_NEW = "NEW";// 新建
	public static final String ORDER_TYPE_RERENT = "RERENT";// 续租
	public static final String ORDER_TYPE_SUBLET = "SUBLET";// 转租
	/**
	 * 订单行类型
	 */
	public static final String ORDER_LINE_TYPE_DEPOSIT = "DEPOSIT";// 押金
	public static final String ORDER_LINE_TYPE_RENT = "RENT";// 租金
	public static final String ORDER_LINE_TYPE_POINTS = "POINTS";//积分
	public static final String ORDER_LINE_TYPE_CASH = "CASH";//现金
	public static final String ORDER_LINE_TYPE_COMPANY_REG_DEPOSIT = "COMPANY_REG_DEPOSIT";//工商注册保证金
	/**
	 * 订单状态
	 * 记得去看视图中的soho_order_payment_hs_v,soho_order_payment_contract_v
	 */
	
	public static final String ORDER_STATUS_DRAFT = "DRAFT";// 草稿 
	public static final String ORDER_STATUS_OBLIGATION = "OBLIGATION";// 待付款
	public static final String ORDER_STATUS_PAING = "PAING";// 支付处理中
	public static final String ORDER_STATUS_PTLY_PD = "PTLY_PD";// 部分已支付
	public static final String ORDER_STATUS_IMPLEMENTING = "IMPLEMENTING";// 已付款
	public static final String ORDER_STATUS_CONTRACET_CONFIRM = "CONTRACET_CONFIRM";// 合同待确认
	public static final String ORDER_STATUS_INVALID = "INVALID";// 已失效
	public static final String ORDER_STATUS_CLOSED = "CLOSED";// 已关闭
	
	public static final String ORDER_STATUS_REFUND = "REFUND";//已退款
	public static final String ORDER_STATUS_REFUNDING = "REFUNDING";//退款中
	
	public static final String ORDER_STATUS_EXPECT = "EXPECT_STATUS"; //预计状态
	public static final String ORDER_STATUS_ALREADY_INSTALLMENT = "ALREADY_INSTALLMENT";  //已分期
	public static final String ORDER_STATUS_EXPECT_CLOSE = "EXPECT_CLOSE";
	public static final String ORDER_STATUS_EXPECT_CANCEL = "EXPECT_CANCEL";
	
	public static final String INSTALLMENT_ORDER_HEADERS_B = "B";   //属于B2B订单
	public static final String INSTALLMENT_ORDER_HEADERS_C = "C";  //分期订单头
	public static final String INSTALLMENT_ORDER_HEADERS_Y = "Y";  //分期子订单
	
	
	
	/**
	 * 会员类型
	 */
	public static final String MEMBER_TYPE_COMMON = "COMMON";// 普通用户
	public static final String MEMBER_TYPE_RENT = "RENT";// 租赁用户
	/**
	 * 合同类型
	 */
	public static final String CONTRACT_TYPE_HOUSE = "HOUSE";// 房屋类
	public static final String CONTRACT_TYPE_SERVICE = "SERVICE";// 服务类
	/**
	 * 合同状态
	 */
	public static final String CONTRACT_STATUS_CLOSED = "CLOSED";// 已关闭
	public static final String CONTRACT_STATUS_DRAFT = "DRAFT";// 草稿
	public static final String CONTRACT_STATUS_IMPLEMENTING = "IMPLEMENTING";// 生成
	public static final String CONTRACT_STATUS_INVALID = "INVALID";// 已作废
	public static final String CONTRACT_STATUS_OBLIGATION = "OBLIGATION";// 待付款
	public static final String CONTRACT_STATUS_UNCONFIRMED = "UNCONFIRMED";// 待确认
	public static final String CONTRACT_STATUS_SIGNED = "SIGNED";// 已签合同
	public static final String CONTRACT_STATUS_CHECK_IN = "CHECK_IN";// 已入驻签收
	public static final String CONTRACT_STATUS_OFFICE_SEAL = "OFFICE_SEAL";// 我方已盖章
	public static final String CONTRACT_STATUS_GENERATED = "GENERATED";//已生成
	/**
	 * 账单状态
	 */
	public static final String PAYMENT_SCHEDULE_STATUS_TO_PUSH = "TO_PUSH";// 待推送
	public static final String PAYMENT_SCHEDULE_STATUS_PAING = "PAING";// 支付处理中
	public static final String PAYMENT_SCHEDULE_STATUS_ALL_PAID = "ALL_PAID";// 已支付
	public static final String PAYMENT_SCHEDULE_STATUS_PTLY_PD = "PTLY_PD";// 部分已支付
	public static final String PAYMENT_SCHEDULE_STATUS_OBLIGATION = "OBLIGATION";// 待支付
	public static final String PAYMENT_SCHEDULE_STATUS_CANCEL = "CANCEL";// 已取消
	public static final String PAYMENT_SCHEDULE_STATUS_DELETE = "DELETE";// 软删除，数据只能在后台管理看到
	
	public static final String PAYMENT_SCHEDULE_STATUS_WAIT_REFUND = "WAIT_REFUND";// 软删除，数据只能在后台管理看到
	
	/**
	 * 退款状态
	 */
	public static final String REFUND_CASH_STATUS_SCRATCH = "SCRATCH";//草稿状态
	public static final String REFUND_CASH_STATUS_APPROVALING = "APPROVALING";//审批中
	
	public static final String REFUND_CASH_STATUS_APPROVAING_FLOORMANAGER = "APPRO_FLOORMANAGER";//楼层经理审批
	public static final String REFUND_CASH_STATUS_APPROVAING_FINANCEMANAGER = "APPRO_FINANCEMANAGER";//项目经理审批
	public static final String REFUND_CASH_STATUS_APPROVAING_GENERALMANAGER = "APPRO_GENERALMANAGER";//总经理审批
	
	public static final String REFUND_CASH_STATUS_APPROVALED = "APPROVALED";//审批完成
	
	public static final String REFUND_CASH_STATUS_REFUNDING = "REFUNDING";//退款中
	public static final String REFUND_CASH_STATUS_REFUNDED = "REFUNDED";//退款完成
	public static final String REFUND_CASH_STATUS_REFUND_FAIL = "REFUND_FAIL";//退款失败
	public static final String REFUND_CASH_STATUS_APPROVAL_FAIL = "APPROVAL_FAIL";//审批失败
	
	public static final String REFUND_CASH_AGREE = "AGREE";
	public static final String REFUND_CASH_DISAGREE = "DISAGREE";
	/**
	 * 退租状态
	 */
	public static final String EVICTION_STATUS_SCRATCH = "SCRATCH";//草稿状态
	public static final String EVICTION_STATUS_APPROVALING = "APPROVALING";//审批中
	
	//public static final String EVICTION_STATUS_APPROVAING_FLOORMANAGER = "APPRO_FLOORMANAGER";//楼层经理审批
	public static final String EVICTION_STATUS_APPROVAING_FINANCEMANAGER = "APPRO_FINANCEMANAGER";//财务经理审批
	
	public static final String EVICTION_STATUS_APPROVALED = "APPROVALED";//审批完成
	
	public static final String EVICTION_STATUS_REFUNDING = "REFUNDING";//退租中
	public static final String EVICTION_STATUS_REFUNDED = "REFUNDED";//退租完成
	public static final String EVICTION_STATUS_REFUND_FAIL = "REFUND_FAIL";//退租失败
	public static final String EVICTION_STATUS_APPROVAL_FAIL = "APPROVAL_FAIL";//审批失败
	/**
	 * 退租类别
	 */
	public static final String CHECKOUT_CATEGORY_FIRST_ALL_CR = "FIRST_ALL_CR";//全部换房(第一次)退租
	/**
	 * 制卡状态
	 */
	public static final String MAKECARD_STATU_LOST = "LOST";// 挂失中
	public static final String MAKECARD_STATU_MAKING = "MAKING";// 制卡中
	public static final String MAKECARD_STATU_BACK = "BACK";// 已退卡
	public static final String MAKECARD_STATU_SEND = "SEND";// 已发卡
	/**
	 * 卡片状态
	 */
	public static final String CARD_STATU_USING = "USING";// 使用中
	public static final String CARD_STATU_LOST = "LOST";// 挂失中
	public static final String CARD_STATU_ADDLOST = "ADDLOST";// 已补卡
	public static final String CARD_STATU_BACK = "BACK";// 已退卡
	public static final String CARD_STATU_INVALID = "INVALID";// 已失效
	/**
	 * 卡片权限状态
	 */
	public static final String CARD_ACCESS_STATU_WORKING = "WORKING";// 生效中
	public static final String CARD_ACCESS_STATU_INVALID = "INVALID";// 已失效

	/**
	 * 应收行类型
	 */
	
	public static final String PAYMENT_SCHEDULE_TYPE_RENT = "RENT";// 租金账单
	public static final String PAYMENT_SCHEDULE_TYPE_RENT_AND_DEPOSIT = "RENT_AND_DEPOSIT";// 租金和押金账单
	public static final String PAYMENT_SCHEDULE_TYPE_DEPOSIT_REBATE = "DEPOSIT_REBATE";// 押金退还账单
	public static final String PAYMENT_SCHEDULE_TYPE_RENT_REBATE = "RENT_REBATE";// 租金退还账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_CASH = "RECHARGE_CASH";// 现金充值账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_CASH_USE_MR = "RECHARGE_CASH_USE_MR";// 会议室预订消费账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_CASH_USE_PRINT = "RECHARGE_CASH_USE_PRINT";// 打印消费账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_CASH_REBATE = "RECHARGE_CASH_REBATE";// 现金充值退回账单
	public static final String PAYMENT_SCHEDULE_TYPE_ENTRANCE_CARD_DEPOSIT = "ENTRANCE_CARD_DEPOSIT";// 门禁卡押金账单
	public static final String PAYMENT_SCHEDULE_TYPE_ENTRANCE_CARD_DEPOSIT_REBATE = "ENTRANCE_CARD_DEPOSIT_REBATE";// 退门禁卡押金账单
	public static final String PAYMENT_SCHEDULE_TYPE_COMPANY_DEPOSIT_DEPOSIT = "COMPANY_DEPOSIT_DEPOSIT";// 工商注册保证金
	public static final String PAYMENT_SCHEDULE_TYPE_DEPOSIT_RETURN = "DEPOSIT_RETURN";// 退回工商注册保证金

	public static final String PAYMENT_SCHEDULE_TYPE_DEPOSIT = "DEPOSIT";// 押金账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_POINT = "RECHARGE_POINT";// 积分充值账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_POINT_USE = "RECHARGE_POINT_USE";// 充值积分消费账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_POINT_USE_REBATE = "RECHARGE_POINT_USE_REBATE";// 充值积分消费退还账单
	public static final String PAYMENT_SCHEDULE_TYPE_RECHARGE_POINT_REBATE = "RECHARGE_POINT_REBATE";// 积分充值退款账单
	public static final String PAYMENT_SCHEDULE_TYPE_FREE_RENT = "FREE_RENT";// 免租期账单
	public static final String PAYMENT_SCHEDULE_TYPE_ENTRANCE_CARD_LOSE_DEPOSIT = "ENTRANCE_CARD_LOSE_DEPOSIT";// 门禁卡挂失押金账单
	
	public static final String PAYMENT_SCHEDULE_TYPE_REFUND_CASH = "REFUND_CASH";// 退款中
	public static final String PAYMENT_SCHEDULE_TYPE_REFUND_CASH_OK = "REFUND_CASH_OK";// 退款完成
	public static final String PAYMENT_SCHEDULE_TYPE_REFUND_REND_OK = "REFUND_REND_OK";
	
	/**
	 * 实收行类型
	 */
	public static final String COLLECTION_BILL_TYPE_DEPOSIT = "DEPOSIT";// 支付押金
	public static final String COLLECTION_BILL_TYPE_RENT = "RENT";// 支付租金
	public static final String COLLECTION_BILL_TYPE_DEPOSIT_REBATE = "DEPOSIT_REBATE";// 支付押金退还
	public static final String COLLECTION_BILL_TYPE_RENT_REBATE = "RENT_REBATE";// 支付租金退还
	public static final String COLLECTION_BILL_TYPE_RECHARGE_POINT = "RECHARGE_POINT";// 支付积分充值
	public static final String COLLECTION_BILL_TYPE_RECHARGE_POINT_REBATE = "RECHARGE_POINT_REBATE";// 支付积分充值退款
	public static final String COLLECTION_BILL_TYPE_ENTRANCE_CARD_DEPOSIT = "ENTRANCE_CARD_DEPOSIT";// 支付门禁卡押金
	public static final String COLLECTION_BILL_TYPE_ENTRANCE_CARD_DEPOSIT_REBATE = "ENTRANCE_CARD_DEPOSIT_REBATE";// 支付禁卡押金退门
	public static final String COLLECTION_BILL_TYPE_FREE_RENT = "FREE_RENT";// 支付免租期账单
	public static final String COLLECTION_BILL_TYPE_ENTRANCE_CARD_LOSE_DEPOSIT = "ENTRANCE_CARD_LOSE_DEPOSIT";// 支付门禁卡挂失押金
	

	/**
	 * 数据来源
	 */
	public static final String SOURCE_SYSTEM_CODE_APP = "APP";
	public static final String SOURCE_SYSTEM_CODE_WEB = "WEB";
	public static final String SOURCE_SYSTEM_CODE_CONSOLE = "CONSOLE";
	
	/**
	 * 租户信息提醒状态
	 */
	public static final String MESSAGE_STATUS_WAITE_FOR_READ = "WAITE_FOR_READ";//未读
	public static final String MESSAGE_STATUS_READED = "READED";//已读
	public static final String MESSAGE_STATUS_DELETE = "DELETE";//删除
	
	/**
	 * 租户消息提醒类型
	 */
	public static final String MESSAGE_TYPE_SEND_RECEIVE = "SEND_RECEIVE";//快递
	public static final String MESSAGE_TYPE_VISITOR = "VISITOR";//访客
	public static final String MESSAGE_TYPE_PAYMENT = "PAYMENT";//缴费
	public static final String MESSAGE_TYPE_ACTIVITY = "ACTIVITY";//活动
	public static final String MESSAGE_TYPE_NOTICE = "NOTICE";//集体公告（停电、停水等）
	public static final String MESSAGE_TYPE_NOTICE_PRIVATE = "NOTICE_PRIVATE";//个人通知
	
	/**
	 * 租户消息提醒内容
	 */
	public static final String MESSAGE_CONTENT_PACKAGE = "您好，您有一个快递在前台，请速来领取。谢谢！"; //包裹内容
	
	/**
	 * 租户消息title
	 */
	public static final String MESSAGE_TITLE_PACKAGE = "快递领取通知"; //包裹title
	
	/**
	 * 消息是否推送MESSAGE_PUSH
	 */
	public static final String MESSAGE_PUSH_YES = "Y";
	public static final String MESSAGE_PUSH_NO = "N";
	/**
	 * 移动端的订单操作类型
	 */
	public static final String MOBILE_OPERATION_TYPE_DELETE = "D";
	public static final String MOBILE_OPERATION_TYPE_CANCEL = "C";
	/**
	 * 租户性别   
	 */
	public static final String MEMBER_GENDER_WMAN ="2";//女
	public static final String MEMBER_GENDER_MAN ="1";//男
	
	/**
	 * 租户语言 
	 */
	public static final String MEMBER_LANGUAGE_EN ="en_US";//英语
	public static final String MEMBER_LANGUAGE_CN="zh_CN";//中文
	
	/**
	 * 租户国籍
	 */
	public static final String MEMBER_NATIONALITY_US = "US";//美国
	public static final String MEMBER_NATIONALITY_CN="CN";//中国

	/**
	 * 租户状态
	 */
	public static final String MEMBER_STATUS_YES = "Y";//激活
	public static final String MEMBER_STATUS_NO = "N";//未激活
	
	/**
	 * 租户是否为公司管理员
	 */
	public static final String MEMBER_IS_ADMINISTRATOR_YES = "Y";
	public static final String MEMBER_IS_ADMINISTRATOR_NO = "N";
	
	/**
	 * 预约看房状态
	 */
	public static final String BESPEAK_STATE_SEEN = "YK"; //已看
	public static final String BESPEAK_STATE_APPOINTED = "YK"; //已看
	public static final String BESPEAK_STATE_CANCEL = "CANCEL"; //取消
	
	/**
	 * 预约成功短信提醒
	 */
	public static final String BOOKING_SUCCESS_MESSAGE_EN = "You have successfully booked a tour,If you have any questions please contact 400-815-9888";//英文
	public static final String BOOKING_SUCCESS_MESSAGE_CN = "您已预约成功。如有问题，请咨询400-815-9888";//中文
	/**
	 *邮件包裹类型 
	 */
	public static final String EXPRESS_TYPE_PACKAGE = "PACKAGE"; //包裹
	public static final String EXPRESS_TYPE_LETTER = "LETTER"; // 信件
	public static final String EXPRESS_TYPE_EXPRESS = "EXPRESS"; //快递 
	
	/**
	 * 邮件包裹状态
	 */
	public static final String EXPRESS_PACKAGE_STATU_INFORMED = "INFORMED"; //已通知
	public static final String EXPRESS_PACKAGE_STATU_NORECEIVE = "NORECEIVE"; //未领取
	
	
	/**
	 * 积分来源
	 */
	public static final String SCORE_FROM_RECHARGE = "RECHARGE"; //充值
	public static final String SCORE_FROM_GIFT = "GIFT"; //赠送
	
	/**
	 * 积分交易类型
	 */
	public static final String SCORE_TRANCTION_TYPE_RECHARGE = "RECHARGE"; //充值
	public static final String SCORE_TRANCTION_TYPE_MR_RECHARGE = "MR_RECHARGE"; //会议室充值
	public static final String SCORE_TRANCTION_TYPE_P_RECHARGE = "P_RECHARGE"; //打印充值
	public static final String SCORE_TRANCTION_TYPE_MR_RECHARGE_REBATE = "MR_RECHARGE_REBATE"; //会议室充值撤销
	public static final String SCORE_TRANCTION_TYPE_P_RECHARGE_REBATE = "P_RECHARGE_REBATE"; //打印充值撤销
	public static final String SCORE_TRANCTION_TYPE_GIFT = "GIFT"; //赠送
	public static final String SCORE_TRANCTION_TYPE_GIFT_MR_HOUR = "GIFT_MR_HOUR";//赠送标准会议室小时
	public static final String SCORE_TRANCTION_TYPE_GIFT_P_PAPER = "GIFT_P_PAPER";//赠送黑白A4打印纸张
	public static final String SCORE_TRANCTION_TYPE_GIFT_MR_HOUR_REBATE = "GIFT_MR_HOUR_REBATE";//赠送标准会议室小时撤销
	public static final String SCORE_TRANCTION_TYPE_GIFT_P_PAPER_REBATE = "GIFT_P_PAPER_REBATE";//赠送黑白A4打印纸张撤销
	public static final String SCORE_TRANCTION_TYPE_GIFT_MRH_USE = "GIFT_MRH_USE";//赠送标准会议室小时使用
	public static final String SCORE_TRANCTION_TYPE_GIFT_PP_USE = "GIFT_PP_USE";//赠送黑白A4打印纸张使用
	public static final String SCORE_TRANCTION_TYPE_GIFT_MRH_USE_REBATE = "GIFT_MRH_USE_REBATE";//赠送标准会议室小时使用撤销
	public static final String SCORE_TRANCTION_TYPE_GIFT_PP_USE_REBATE = "GIFT_PP_USE_REBATE";//赠送黑白A4打印纸张使用撤销
	public static final String SCORE_TRANCTION_TYPE_MEETING_ROOM = "MEETING_ROOM"; //预订会议室
	public static final String SCORE_TRANCTION_TYPE_PRINTER = "PRINTER"; //打印
	public static final String SCORE_TRANCTION_TYPE_RECHARGE_REBATE = "RECHARGE_REBATE"; //充值撤销
	public static final String SCORE_TRANCTION_TYPE_GIFT_REBATE = "GIFT_REBATE"; //赠送撤销
	public static final String SCORE_TRANCTION_TYPE_MEETING_ROOM_REBATE = "MEETING_ROOM_REBATE"; //取消会议室预订
	public static final String SCORE_TRANCTION_TYPE_PRINTER_REBATE = "PRINTER_REBATE"; //打印撤销
	public static final String SCORE_TRANCTION_TYPE_PRINT_PUSH = "PRINT_PUSH"; //打印现金推送
	public static final String SCORE_TRANCTION_TYPE_PRINT_PAPER_PUSH = "PRINT_PAPER_PUSH"; //打印现金推送
	public static final String SCORE_TRANCTION_TYPE_DEDUCTION_RECHARGE = "DEDUCTION_RECHARGE"; //扣款充值
	
	public static final String SCORE_TRANCTION_TYPE_CHECK_OUT = "CHECK_OUT"; //退租
	/**
	 * 热销级别
	 */
	public static final String HOT_LEVEL_BEGINNER = "BEGINNER"; //初级
	public static final String HOT_LEVEL_INTERMEDIATE = "INTERMEDIATE"; //中级
	public static final String HOT_LEVEL_TOP="TOP "; //顶级
	
	/**
	 * 访客状态
	 */
	public static final String VISIT_STATU_VISITING = "VISITING"; //已到访
	public static final String VISIT_STATU_READY = "READY"; //未到访
	public static final String VISIT_STATU_CANCEL = "CANCEL";//来访取消
	public static final String VISIT_STATU_LEAVE = "LEAVE";//访问结束
	
	/**
	 * 定价策略方式
	 */
	public static final String STRATEGY_TYPE_BATCH = "BATCH";//批量
	public static final String STRATEGY_TYPE_RAPID = "RAPID";//快捷
	/**
	 * 公司性质
	 */
	public static final String COMPANY_NATURE_INDIVIDUAL = "INDIVIDUAL";//个人
	public static final String COMPANY_NATURE_COMPANY = "COMPANY";//公司
	
	public static final String BUSINESS_LICENSE = "BUSINESS_LICENSE";//公司
	
	public static final String DEFAULT_INVOICE_CONTENT="租赁费";
	public static final String INVOICE_CONTENT_OTHER="租赁费及其他";
	public static final String INVOICE_CONTENT_RENT="RENT";
	public static final String INVOICE_CONTENT_RENTOROTHER="RENTOROTHER";
	
	public static final int WEB_ROW_COUNT=5;
	
	public static final int WEB_NOTICE_ROW_COUNT=10;//个人中心通知公告显示条数
	
	public static final String SECKEY_SUFFIX = "@f34paweeewe131212dfdgfjy2014erer";
	//通知商户支付成功校验签名秘钥
	public final static String OPEN_SERVICE_KEY = "jsdfasdf23g355hGVsRruj7rKomSkDPj3FG";
	
	/**
	 * 支付来源
	 */
	public static final String PAY_TYPE_SOURCE_SYSTEM_WEB = "WEB";//批量
	public static final String PAY_TYPE_SOURCE_SYSTEM_APP = "APP";//快捷
	public static final String PAY_TYPE_SOURCE_SYSTEM_WAP = "WAP";//快捷
	
	
	
	/**
	 * 第一级组织cn
	 */
	public final static String SOHO_CHINA_COMPANY_CN_NAME = "SOHO中国有限公司";
	/**
	 * 第一级组织dn
	 */
	public final static String SOHO_CHINA_COMPANY_DN_NAME = "CN=SOHO中国有限公司,OU=SOHOCHINA,DC=soho,DC=com";
	/**
	 * org_type
	 */
	public final static Integer ORG_TYPE_ONE = 1;
	
	public static final String PAY_TYPE_Alipay = "Alipay";//支付宝
	public static final String PAY_TYPE_Tenpay = "Tenpay";//财付通
	public static final String PAY_TYPE_Wechat = "Wechat";//微信支付
	public static final String PAY_TYPE_Unionpay = "Unionpay";//银联
	public static final String PAY_TYPE_onlineBank = "onlineBank";//网上银行直连
	public static final String PAY_TYPE_B2B = "B2B";// 企业网银
	public static final String PAY_TYPE_POS = "POS";// POS机
	public static final String PAY_TYPE_INTERNATIONAL = "International";// POS机
	
	/**
	 * 银行类型
	 */
	public static final String BANK_TYPE_BOC = "BOC";//中国银行
	public static final String BANK_TYPE_CCB = "CCB";//中国建设银行
	
	/**
	 * POS机类型
	 */
	public static final String POS_TYPE_BOC = "bocpaypos";// 中国银行POS机
	public static final String POS_TYPE_CCB = "ccbpaypos";// 中国建设银行POS机

	/**
	 * 赠送类型
	 */
	public static final String PRESENTATION_TYPE_MR_USAGE = "MR_USAGE";//会议室使用（小时） 
	public static final String PRESENTATION_TYPE_PC_PAPER = "PC_PAPER";//打印复印黑白A4纸（张） 
	
	public static final String PRICE_TYPE_CASH = "CASH";//现金充值
	public static final String PRICE_TYPE_HOUR = "HOUR";//小时价格
	public static final String PRICE_TYPE_DAY = "DAY";//日价格
	public static final String PRICE_TYPE_WEEK = "WEEK";//周价格
	public static final String PRICE_TYPE_MONTH = "MONTH";//月价格
	public static final String PRICE_TYPE_QUARTER = "QUARTER";//季价格
	public static final String PRICE_TYPE_HALF_YEAR = "HALF_YEAR";//半年价格
	public static final String PRICE_TYPE_YEAR = "YEAR";//年价格
	
	public static final String ADMINISTRATOR_USER_ID="1";
	
	/**
	 * 价格优惠条款 类型  PRIVILEGE_GATEGORY
	 */
	public static final String PRICING_STRATEGY_GIVE_DAYS = "GIVE_DAYS";//租免
	public static final String PRICING_STRATEGY_CASHBACK = "CASHBACK";//满减
	public static final String PRICING_STRATEGY_PERCENTAGE = "PERCENTAGE";//单价打折
	public static final String PRICING_STRATEGY_HAND_SETTING = "HAND_SETTING";//手工调整
	public static final String PRICING_STRATEGY_RENT_DISCOUNT = "RENT_DISCOUNT";//租满打折
	public static final String PRICING_STRATEGY_RENT_FULL_DISCOUNT = "RENT_FULL_DISCOUNT";//租满固定天数打折
	
	/**
	 * 适用权限STRATEGY_USER_PERMISSION(对外发布，对内发布)
	 */
	public static final String STRATEGY_USER_PERMISSION_PUBLIC = "PUBLIC";//对外发布
	public static final String STRATEGY_USER_PERMISSION_PRIVATE = "PRIVATE";//对内发布
	
	/**
	 * 适用范围：STRATEGY_RIGHT_SCOPE
	 */
	public static final String STRATEGY_RIGHT_SCOPE_ALL = "ALL";//所有产品
	public static final String STRATEGY_RIGHT_SCOPE_ANY = "ANY";//指定产品
	
	/**
	 * 优惠条款适用用户 STRATEGY_RENT_TYPE:首次下单，续租
	 */
	public static final String STRATEGY_RENT_FIRST_TIME = "RENT_FIRST";//首次下单
	public static final String STRATEGY_RENT_CONTINUE_TIME = "RENT_CONTINUE";//续租
	/**
	 * 代金券类别 CASH_COUPON_CATEGORY 
	 */
	public static final String CASH_COUPON_CATEGORY_REGISTER = "REGISTER";//注册
	public static final String CASH_COUPON_CATEGORY_RED_ENVELOPE = "RED_ENVELOPE";//红包
	
	/**
	 * 代金券状态
	 */
	public static final String CASH_COUPON_STATUS_USED = "USED";//已使用
	public static final String CASH_COUPON_STATUS_UNUSED = "UNUSED";//未使用
	public static final String CASH_COUPON_STATUS_INVALID ="INVALID";//失效\过期
	
	/**
	 * 产品下线原因
	 */
	public static final String OFFLINE_REASON_BOOKING_FREEZING = "BOOKING_FREEZING";//预定冻结
	public static final String OFFLINE_REASON_LAY_UP = "LAY_UP";//暂停使用
	public static final String OFFLINE_REASON_OTHER = "OTHER";//其他
	
	/**
	 * 客户类型
	 */
	public static final String CUSTOM_TYPE_INDIVIDUAL = "INDIVIDUAL";//个人
	public static final String CUSTOM_TYPE_COMPANY = "COMPANY";//公司
	/**
	 * 结账状态，
	 */
	public static final String ACCOUNT_STATUS_SETTLEMENT="SETTLEMENT";
	public static final String ACCOUNT_STATUS_NOT_SETTLED="NOT_SETTLED";
	
	/**
	 * 退款,退租 类型
	 */
	public static final String REFUND_TYPE_REFUND_CASH = "REFUND_CASH";//退款
	public static final String REFUND_TYPE_REFUND_RENT = "REFUND_RENT";//退租
	
	
	
	/**
	 * 手工调整策略代码
	 */
	public static final String PRICING_STRATEGY_USER_DEFINED="USER_DEFINED";
	
	/**
	 * 会议室预订或取消
	 */
	public static final String MEETING_ROOM_BOOK="BOOK";
	public static final String MEETING_ROOM_CANCEL="CANCEL";
	/**
	 * 证件类型
	 */
	public static final String IDENTITY_TYPE_ID="ID_CARD";//身份证
	public static final String IDENTITY_TYPE_PASS="PASSPORT";//护照
	public static final String IDENTITY_TYPE_HKM="HK_M";//港澳通行证
	public static final String IDENTITY_TYPE_COMPANY="BUSINESS_LICENSE";//营业执照
	/**
	 * 借贷标识
	 */
	public static final String DEBIT_CREDIT_FALG_DEBIT="DEBIT";//借方
	public static final String DEBIT_CREDIT_FALG_CREDIT="CREDIT";//贷方
	/**
	 * 打印明细信息类型
	 */
	public static final String PRINT_DETAIL_TYPE_RECHAGE="RECHAGE";//充值
	public static final String PRINT_DETAIL_TYPE_GIFT_CONVERT="GIFT_CONVERT";//赠送打印纸张结算金额
	public static final String PRINT_DETAIL_TYPE_GIFT="GIFT";//赠送打印纸数
	public static final String PRINT_DETAIL_TYPE_PC="PC";//打印/复印
	public static final String PRINT_DETAIL_TYPE_PC_CANCEL="PC_CANCEL";//打印/复印取消
	public static final String PRINT_DETAIL_TYPE_STOP_PRINT_AUTHORITY_PUSH="STOP_PRINT_AUTHORITY_PUSH";//停用打印权限推送
	public static final String PRINT_DETAIL_TYPE_START_PRINT_AUTHORITY_PUSH="START_PRINT_AUTHORITY_PUSH";//启用打印权限推送
	/**
	 * 扣款类型
	 */
	public static final String EVICTION_DEDUCTION_TYPE_DEPOSIT="DEPOSIT";//押金
	public static final String EVICTION_DEDUCTION_TYPE_DEDUCTION="DEDUCTION";//保证金扣款
	public static final String EVICTION_DEDUCTION_TYPE_CARD="CARD";//门禁卡挂失扣款
	public static final String EVICTION_DEDUCTION_TYPE_KEY="KEY";//钥匙挂失扣款
	public static final String EVICTION_DEDUCTION_TYPE_VISIT_OVERTIME="VISIT_OVERTIME";//访客超时扣款
	public static final String EVICTION_DEDUCTION_TYPE_TELEPHONE_CASH="TELEPHONE_CASH";//电话费
	public static final String EVICTION_DEDUCTION_TYPE_MEETING_OVERTIME="MEETING_OVERTIME";//会议超时扣款
	public static final String EVICTION_DEDUCTION_TYPE_MEETING_PHONE_OVERTIME="MEETING_PHONE_OVERTIME";//会议电话超时扣款
	public static final String EVICTION_DEDUCTION_TYPE_OTHER="OTHER";//其他扣款
	public static final String EVICTION_DEDUCTION_TYPE_RECHARGE_ORDER="RECHARGE_ORDER";//充值订单
	public static final String EVICTION_DEDUCTION_TYPE_RECHARGE_AVAILABLE="RECHARGE_AVAILABLE";//充值余额
	public static final String EVICTION_DEDUCTION_TYPE_CARD_AND_KEY="CARD_AND_KEY";//门禁卡钥匙挂失扣款
	/**
	 * 业务类型
	 */
	public static final String BUSINESS_TYPE_ORDER_PAYMENT_ROOM="ORDER_PAYMENT_ROOM";//收到订单支付款-房间
	public static final String BUSINESS_TYPE_ORDER_PAYMENT_DEPOSIT="ORDER_PAYMENT_DEPOSIT";//收到订单支付款 – 押金
	public static final String BUSINESS_TYPE_CONTRACT_EFFECTIVE_DEPOSIT="CONTRACT_EFFECTIVE_DEPOSIT";//合同生效-押金
	public static final String BUSINESS_TYPE_CONTRACT_EFFECTIVE_LEASE="CONTRACT_EFFECTIVE_LEASE";//合同生效 – 租金
	
	public static final String BUSINESS_TYPE_CONTRACT_DEPOSIT="CONTRACT_DEPOSIT";//合同执行-押金
	public static final String BUSINESS_TYPE_CONTRACT_LEASE="CONTRACT_LEASE";//合同执行–租金
	
	public static final String BUSINESS_TYPE_LEASE_CONFIRM="LEASE_CONFIRM";//租金收入确认
	public static final String BUSINESS_TYPE_PROMOTION_OR_FREE="PROMOTION_OR_FREE";//优惠折扣、免租期
	public static final String BUSINESS_TYPE_GIFT_OR_CASH_COUPON="GIFT_OR_CASH_COUPON";//赠送/使用代金券
	public static final String BUSINESS_TYPE_RECHARGE_CASH_MR="RECHARGE_CASH_MR";//资金账户充值-会议室
	//资金账户充值-打印/复印
	public static final String BUSINESS_TYPE_RECHARGE_CASH_PRINT_OR_COPY="RECHARGE_CASH_PRINT_OR_COPY";
	public static final String BUSINESS_TYPE_CASH_CONSUMPTION_MR="CASH_CONSUMPTION_MR";//资金账户消费 – 订会议室
	//资金账户消费 – 打印/复印
	public static final String BUSINESS_TYPE_CASH_CONSUMPTION_PRINT_OR_COPY="CASH_CONSUMPTION_PRINT_OR_COPY";
	public static final String BUSINESS_TYPE_RECHARGE_CASH_BALANCE_MR="RECHARGE_CASH_BALANCE_MR";//资金账户充值余额退款 –会议室
	//资金账户充值余额退款 –打印/复印
	public static final String BUSINESS_TYPE_RECHARGE_CASH_BALANCE_PRINT_OR_COPY="RECHARGE_CASH_BALANCE_PRINT_OR_COPY";
	//门禁卡和钥匙丢失扣减押金
	public static final String BUSINESS_TYPE_ACCESS_CARD_DEDUCTION_DEPOSIT="ACCESS_CARD_DEDUCTION_DEPOSIT";
	//访客超时罚款从押金中扣除
	public static final String BUSINESS_TYPE_VISITOR_DEDUCTION_FROM_DEPOSIT="VISITOR_DEDUCTION_FROM_DEPOSIT";
	//押金余额退款
	public static final String BUSINESS_TYPE_DEPOSIT_BALANCE_REFUND="DEPOSIT_BALANCE_REFUND";
	public static final String BUSINESS_TYPE_LEASE_REFUND="LEASE_REFUND";//租金退还
	public static final String BUSINESS_TYPE_CLEARING_ACCOUNT="CLEARING_ACCOUNT";//清算科目
	public static final String BUSINESS_TYPE_INTERNAL_CURRENT_ACCOUNT_C="INTERNAL_CURRENT_ACCOUNT_C";//内部往来-贷
	public static final String BUSINESS_TYPE_INTERNAL_CURRENT_ACCOUNT_D="INTERNAL_CURRENT_ACCOUNT_D";//内部往来-借
	
	/**
	 * 退款成功标志
	 */
	public static final String REFUND_SUCCESS = "success";
	
	/**
	 * 退款失败标志
	 */
	public static final String REFUND_FAIL = "fail";
	
	/**
	 * 支付宝退款跳转标志
	 */
	public static final String ALIPAY_FORWARD = "alipay_forward";
	
	/**
	 * 排队通知方式
	 */
	public static final String QUEUE_NOTICE_EMAIL="email";
	public static final String QUEUE_NOTICE_MOBILE="mobile";
	public static final String QUEUE_PRODUCT_CATEGORY_DEFAULT="all";
	public static final String QUEUE_NOTICE_MANUAL="manual";
	public static final String QUEUE_NOTICE_AUTO="auto";
	
	/**
	 * 第三方登录合作商
	 */
	public static final String THIRD_PARTY_LOGIN_SINA="WB";
	public static final String THIRD_PARTY_LOGIN_QQ="QQ";
	public static final String THIRD_PARTY_LOGIN_WX="WX";

	/**
	 * 资金账户类型
	 */
	public static final String ACCOUNT_TYPE_DEPOSIT="DEPOSIT";//押金
	public static final String ACCOUNT_TYPE_CONFERENCE_HOUR="CONFERENCE_HOUR";//会议室小时
	public static final String ACCOUNT_TYPE_PRINT_PAPER="PRINT_PAPER";//打印纸张
	/**
	 * 资金账户交易类型
	 */
	public static final String ACCOUNT_TRANCTION_TYPE_DEPOSIT="DEPOSIT";//押金
	public static final String ACCOUNT_TRANCTION_TYPE_DEPOSIT_DEDUCTION="DEPOSIT_DEDUCTION";//退款退押金
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_CH="GIFT_MR_HOUR";//赠送标准会议室小时
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_PP="GIFT_P_PAPER";//赠送黑白A4打印纸张
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_CH_REBATE="GIFT_MR_HOUR_REBATE";//赠送标准会议室小时撤销
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_PP_REBATE="GIFT_P_PAPER_REBATE";//赠送黑白A4打印纸张撤销
	public static final String ACCOUNT_TRANCTION_TYPE_STOP_PRINT_AUTHORITY="STOP_PRINT_AUTHORITY";//停用打印权限
	public static final String ACCOUNT_TRANCTION_TYPE_DEPOSIT_RECHARGE="DEDUCTION_RECHARGE";//保证金充值
	public static final String ACCOUNT_TRANCTION_TYPE_CASH_PUSH="CASH_PUSH";//金额推送(保证金余额-保证金初始值+赠送纸张折算金额)
	public static final String ACCOUNT_TRANCTION_TYPE_DEPOSIT_RECHARGE_REBATE="DEDUCTION_RECHARGE_REBATE";//保证金充值撤销
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_MRH_USE = "GIFT_MRH_USE";//赠送标准会议室小时使用
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_PP_USE = "GIFT_PP_USE";//赠送黑白A4打印纸张使用
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_MRH_USE_REBATE = "GIFT_MRH_USE_REBATE";//赠送标准会议室小时使用撤销
	public static final String ACCOUNT_TRANCTION_TYPE_GIFT_PP_USE_REBATE = "GIFT_PP_USE_REBATE";//赠送黑白A4打印纸张使用撤销
	public static final String ACCOUNT_TRANCTION_TYPE_MEETING_ROOM = "MEETING_ROOM"; //预订会议室
	public static final String ACCOUNT_TRANCTION_TYPE_PRINTER = "PRINTER"; //打印
	public static final String ACCOUNT_TRANCTION_TYPE_MEETING_ROOM_REBATE = "MEETING_ROOM_REBATE"; //取消会议室预订
	public static final String ACCOUNT_TRANCTION_TYPE_CHECK_OUT = "CHECK_OUT"; //退租
	public static final String ACCOUNT_TRANCTION_TYPE_CHANGE_ROOM_OUT = "CHANGE_ROOM_OUT"; //换房结转出
	public static final String ACCOUNT_TRANCTION_TYPE_CHANGE_ROOM_IN = "CHANGE_ROOM_IN"; //换房结转入
	
	/**
	 * 资金账户交易单位
	 */
	public static final String ACCOUNT_TRANCTION_UNIT_RMB="RMB";//元
	public static final String ACCOUNT_TRANCTION_UNIT_HOURS="HOURS";//小时
	public static final String ACCOUNT_TRANCTION_UNIT_SHEET="SHEET";//张
	/**
	 * 入驻记录状态
	 */
	
	public static final String CHECK_IN_RECORD_LIVING ="living";
	public static final String CHECK_IN_RECORD_LEAVE ="leave";
	/**
	 * 入驻用户状态
	 */
	public static final String CHECK_IN_MEMBER_LIVING ="living";
	public static final String CHECK_IN_MEMBER_LEAVE ="leave";
	/**
	 * 扣款单状态
	 */
	public static final String CHECK_IN_DEDUCTION_STATUS_DRAFT ="DRAFT";//草稿
	public static final String CHECK_IN_DEDUCTION_STATUS_DEDUCTED ="DEDUCTED";//已扣款
	
	/**
	 * 映射类型
	 */
	
	public static final String DIMENSION_MAP_TYPE_payTypeAndAccount ="payTypeAndAccount";
	
	public static final String TEMPLATE_STATUS_TO_DO ="TO_DO";
	public static final String TEMPLATE_STATUS_DOING ="DOING";
	public static final String TEMPLATE_STATUS_FINISH ="FINISH";
	
	public static final String TEMPLATE_SEND_STATUS_TO_DO ="TO_DO";
	public static final String TEMPLATE_SEND_STATUS_FINISH ="FINISH";
	public static final String TEMPLATE_SEND_STATUS_FAIL ="FAIL";
	
	
	/**
	 * 预计合同状态
	 */
	public static final String EXPECT_CONTRACT_STATUS_DRAFT = "EXPECT_DRAFT";// 已生成
	public static final String EXPECT_CONTRACT_STATUS_IMPLEMENTING = "EXPECT_IMPLEMENTING";// 已转正
	public static final String EXPECT_CONTRACT_STATUS_CANCEL = "EXPECT_CANCEL";// 已转正
	
	/**
	 * 付款类型
	 */
	public static final String EXPECT_CONTRACT_PAYMENY_TYPE_ONE = "ONE_TIME"; 
	public static final String EXPECT_CONTRACT_PAYMENY_TYPE_N = "N_TIME";
	/**
	 * 话机使用状态
	 */
	public static final String SOHO_CHECK_IN_TELEPHONE_STATUS_TBC_USE = "TBC_USE";//待确认使用
	public static final String SOHO_CHECK_IN_TELEPHONE_STATUS_USE = "USE";//使用中
	public static final String SOHO_CHECK_IN_TELEPHONE_STATUS_BACK = "BACK";//已归还
	
	
	public static final String SOHO_COMMUNITY_ADMIN="communityAdmin"; //社区管理员角色编码
	public static final String SOHO_COMMUNITY_EVENT_ENROLL_VERIFY="communityEventEnrollVerify"; //社区管理员角色编码
	public static final String SOHO_FLOOR_MANAGER="FLOOR_MANAGER"; //楼层经理角色编码
	public static final String SOHO_ADMINISTRATORS="Administrators"; //系统超级管理员角色编码
	
	/**
	 * 用户登录认证类型
	 */
	public static final String SOHO_USER_AUTHENTICATION_TYPE_SOHO3Q = "SOHO3Q"; 
	public static final String SOHO_USER_AUTHENTICATION_TYPE_LDAP = "LDAP";
	public static final String SOHO_USER_AUTHENTICATION_TYPE_LDAP_KEY = "PCCW_"+SOHO_USER_AUTHENTICATION_TYPE_LDAP;
	
	public static final String SOHO_OPENOFFICE_URL = "/opt/openoffice4"; // 
	//public static final String SOHO_OPENOFFICE_URL = "C:\\Program Files\\OpenOffice 4"; // 
	public static final String SOHO_OPENOFFICE_COMMAND = "program\\soffice --headless --accept=\"socket,host=127.0.0.1,port=8100;urp;\" --nofirststartwizard &";
	
	/**
	 * 换房类型
	 */
	public static final String CHANGE_ROOM_TYPE_ALL = "ALL";//全部换房
	public static final String CHANGE_ROOM_TYPE_PART = "PART";//部分换房
	
	/**
	 * 换房状态
	 */
	public static final String CHANGE_ROOM_STATUS_DRAFT = "DRAFT";//已生成
	public static final String CHANGE_ROOM_STATUS_SUCCESS = "SUCCESS";//已换房
	
	/**
	 * 换房单产品类型
	 */
	public static final String CHANGE_ROOM_PRODUCT_STATUS_CHANGE = "CHANGE";//取消
	public static final String CHANGE_ROOM_PRODUCT_STATUS_KEEP = "KEEP";//保留
	public static final String CHANGE_ROOM_PRODUCT_STATUS_ADD = "ADD";//新增
	
	/**
	 * 换房源
	 */
	public static final String 	CHANGE_ROOM_PRODUCT_SOURCE_OLD = "OLD";
	public static final String 	CHANGE_ROOM_PRODUCT_SOURCE_NEW = "NEW";
	
}
