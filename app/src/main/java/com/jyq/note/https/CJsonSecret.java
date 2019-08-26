package com.jyq.note.https;

import com.google.gson.Gson;
import com.jyq.note.consts.ConstValue;
import com.jyq.note.utils.LogUtils;
import com.jyq.note.utils.SPUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jingkai on 2017/12/5.
 */

public class CJsonSecret {
    public enum EN_TYPE {APP, USER}

    static Gson gson = new Gson();

    public static String tojson(HashMap params) {
        return tojson(params, EN_TYPE.APP);
    }

    public static String tojsonOfUser(HashMap params) {
        return tojson(params, EN_TYPE.USER);
    }

    public static String tojson(HashMap params, EN_TYPE type) {
        String strRet = "";
        if (params.size() > 0) {
            strRet = gson.toJson(params);
            String key = getKey(type);
            strRet = AESUtils.Encrypt(strRet, key);
        }
        return strRet;
    }

    public static String getKey(String url) {
        EN_TYPE type = EN_TYPE.APP;
        String strPath = url;
        if (url.length() > ConstValue.SERVR_URL.length())
            strPath = url.substring(ConstValue.SERVR_URL.length(), url.length());
        if (!appKeyList.contains(strPath)) {
            type = EN_TYPE.USER;
        }

        return getKey(type);
    }

    public static String getKey(EN_TYPE type) {

        if (ConstValue.UserSecret == null) {
            ConstValue.UserSecret = SPUtils.getString(ConstValue.userKey, null);
        }
        if (ConstValue.UserSecret == null) {
            LogUtils.print("UserSecret 为null");
        }

        String key = type == EN_TYPE.APP ? ConstValue.APPSecret : ConstValue.UserSecret;
        int lenKey = key.length();
        if (lenKey > 4) {
            key = key.substring(lenKey - 2, lenKey) + key.substring(2, lenKey - 2) + key.substring(0, 2);
        }
        key = CSecret.md5(key);
        return key;
    }

    static List<String> appKeyList = new ArrayList<String>() {{
        add("user/isExist");//检测用户是否存在
        add("user/isExist/oauth");//检测 openId是否已绑定
        add("user/userInfo/nologin");//不登录获取用户信息
        add("user/register");//用户注册
        add("user/login");//用户登录
        add("user/phonelogin");//
        add("user/refreshAccessToken");//刷新token
        add("user/login/oauth");//用户互联登录
        add("user/safe/pwd/find");//找回密码
        add("tool/sendVCode");//发送验证码
        add("tool/valideVCode");//校验验证码
        add("tool/oauthUnionIDByAccToken");//获取互联登录的UnionID
        add("sys/notice");//获取系统公告
        add("sys/terminal/list");//获取终端列表
        add("tool/oauthTempId");//获取互联登录临时查询id
        add("tool/checkOAuthState");//检查互联登录状态
        add("team/isExistId");//检测团队Id是否存在
        add("ad/adInfo");//广告信息
        add("user/check/oauth/findPwd");//检测oppenId是否可以找回密码
        add("ad/adSync");//广告接口

    }};

}
