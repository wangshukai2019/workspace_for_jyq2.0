package com.jyq.note.consts;


public class ConstValue {


    public static final boolean flag = true;//是否打开打印

    //数据库结构有变动时，发布版本需要升级版本号
    public static final int SCHEMA_VERSION = 45;

    //    public static final String SERVR_URL = "http://47.97.206.166:8083/";//调试地址
//    public static final String SERVR_URL = "http://192.168.1.171:9020/";//调试地址
    //    public static final String SERVR_URL = "http://192.168.1.171:9010/";//测试地址
    public static final String SERVR_URL = "https://mobile.jingyeqian.com/";//正式地址
    public static String MetaTypeJson = "application/json; charset=utf-8";
    public static final String APPID = "jyqandroid";
    public static final String APPSecret = "XdEUpQjvih5KC4ZiMkXwFvNfRvvMED38";
    public static String UserSecret;

    public static String APK_DOWNLOAD = "https://download.jingyeqian.com/android/jingyeqian.apk";

    //SharedPreferences Action
    public static final String SyncVersion = "SyncVersion";//便签版本号(String)
    public static final String TimeAxisIndex = "TimeAxisIndex";//时间轴tid下拉标记(long)
    public static final String CompletedIndex = "CompletedIndex";//已完成tid下拉标记(long)
    public static final String islock = "islock";//锁屏标记(boolean)
    public static final String isTimeAxisLock = "isTimeAxisLock";//锁屏标记(boolean)
    public static final String VipType = "VipType";//vip标记(int)
    public static final String isAppVersionOnServerRedTip = "isAppVersionOnServerRedTip";//服务端有新版本更新，显示更新红点(boolean)

    //BroadcastReceiver Action
    public static final String ActionModifyTextSize = "ActionModifyTextSize";//修改字体大小广播


    public static final String REGTYPE_DEF = "0";
    public static final String REGTYPE_PHONE = "1";
    public static final String REGTYPE_EMAIL = "2";
    public static final String REGTYPE_INTERNET = "3";


    // VIP的等级
    public static final int VIPTYPE_NORMAL = 0;
    public static final int VIPTYPE_GOLD = 1;
    public static final int VIPTYPE_DIAMOND = 2;


    // VIP提醒推送方式
    public static final int VIPPUSHTYPE_SMS = 1;
    public static final int VIPPUSHTYPE_EMAIL = 2;
    public static final int VIPPUSHTYPE_TEL = 3;


    // 业务类型(0：团签充值点数 1：团签充值短信 2个人短信充值 3个人语音电话充值 4黄金会员充值 5个人空间充值 6钻石会员充值)
    public static final int BIZTYPE_TEAMPOINT = 0;//团签充值点数
    public static final int BIZTYPE_TEAMSMS = 1;//团签充值短信
    public static final int BIZTYPE_SMS = 2;//个人短信充值
    public static final int BIZTYPE_TEL = 3;//个人语音电话充值
    public static final int BIZTYPE_MEMBER_GOLD = 4;//黄金会员充值
    public static final int BIZTYPE_SPACE = 5;//个人空间充值
    public static final int BIZTYPE_MEMBER_DIAMOND= 6;//钻石会员充值


    public static final String ISFIRSTRUNNING = "isFirstRunning";

    //自动登录的标记
    public static final String AUTOLOGINFLAG = "autologinflag";

    public static final String PWDLOGIN = "pwdlogin";
    public static final String QQLOGIN = "qqlogin";
    public static final String QQUNIONID = "qqunionid";
    public static final String WECHATLOGIN = "wechatlogin";
    public static final String WECHATUNIONID = "wechatunionid";
    public static final String CELLPHONELOGIN = "cellphonelogin";


    public static final String OppoAppKey = "Ajib8B1dbS0k800gG08o8K80w";
    public static final String OppoMasterSecret = "cD7ae95Dab03deE88B66afE21406f2a1";

    /**
     * ==========================第三方登录=================================
     **/
    public static final String QQ_APP_ID = "101429362";
    public static final String QQ_APP_KEY = "2ebcc2e03594dc314a3c8a3a7e17953a";
    public static final String QQ_GROUP_KEY = "REatzMJBFoH6WBbcJmlEQatNhllphbiF";
    public static final String QQ_TEAMGROUP_KEY = "wKRogOYW0mwyWZnegMnLkrQMuZwHN5OW";

    public static final String WECHAT_APP_ID = "wx3e154e50aa6775d4";
    public static final String WECHAT_APP_SECRET = "1eb375493d26e86bd2bba0e7270db114";


    /**
     * ==========================微信支付=================================
     **/
    public static final String APP_ID = "wx3e154e50aa6775d4";
    public static final String partnerId = "1514392241";

    public static final int ACTIVITY_RESULT_CODE_ADDNOTE = 901;
    public static final int ACTIVITY_RESULT_CODE_MODNOTE = 902;
    public static final int ACTIVITY_RESULT_CODE_DELNOTE = 903;


    //支付结果状态 (0待充值，1成功，2失败)
    public static final int PAYRESULT_WAIT = 0;
    public static final int PAYRESULT_SUCC = 1;
    public static final int PAYRESULT_FAIL = 2;

    //充值渠道（0系统 1支付宝 2微信 3苹果）
    public static final int PAYTYPE_SYS = 0;
    public static final int PAYTYPE_ALIPAY = 1;
    public static final int PAYTYPE_WECHAT = 2;
    public static final int PAYTYPE_IPHONE = 3;

    //充值渠道状态(0正常 1维护)
    public static final int PAYTYPESTATUS_NORMAL = 0;
    public static final int PAYTYPESTATUS_TENDING = 1;


    //条目状态  保持,添加,修改,删除,完成
    public static final int ACTION_KEEP = 0;
    public static final int ACTION_ADD = 1;
    public static final int ACTION_MOD = 2;
    public static final int ACTION_DEL = 3;
    public static final int ACTION_COM = 4;

    //团签Fragment跳转
    public static final int TEAMJUMPACTION_JOIN = 1;
    public static final int TEAMJUMPACTION_CREATE = 2;


    //客户端类型
    public static final int TERMINALID_WEB = 1;
    public static final int TERMINALID_WIN = 2;
    public static final int TERMINALID_IOS = 3;
    public static final int TERMINALID_ANDROID = 4;

    //条目位置  保持,置顶 ,置低
    public static final int LOCATION_KEEP = 0;
    public static final int LOCATION_TOP = 1;
    public static final int LOCATION_BOTTOM = 2;

    //提醒公历阴历 //0公历  1阴历
    public static final int REMINDDATETYPE_CALENDAR = 0;
    public static final int REMINDDATETYPE_LUNAR = 1;

    //内容状态(0已读 1未读 2超时)
    public static final int STATUS_READ = 0;
    public static final int STATUS_UNREAD = 1;
    public static final int STATUS_TIMEOUT = 2;

    //团签加入方式(0审批 1密码)
    public static final int TEAMJOINTYPE_APALY = 0;
    public static final int TEAMJOINTYPE_PWD = 1;

    public static final String FONTCOLOR_DEF = "#010101";

//    手机正则
    public static final String REGEX_PHONE = "^((1[0-9]{1})+\\d{9})$";
    //    邮箱正则
    public static final String REGEX_EMAIL = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    //    汉字正则
    public static final String REGEX_REALNAME = "[\\u4e00-\\u9fa5]+";
    //    身份证正则
    public static final String REGEX_IDNUMBER = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";


    //阿里OSS配置
    public static String accessKeyId = "";
    public static String secretAccessKey = "";
    public static String bucketName = "";
}
