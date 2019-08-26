package com.jyq.note.https;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;


public class ApiRequest {

    /****************
     * 发起添加群流程。群号：敬业签(606057327) 的 key 为： REatzMJBFoH6WBbcJmlEQatNhllphbiF
     * 调用 joinQQGroup(REatzMJBFoH6WBbcJmlEQatNhllphbiF) 即可发起手Q客户端申请加群 敬业签(606057327)
     *
     * @param key 由官网生成的key
     * @return 返回true表示呼起手Q成功，返回fals表示呼起失败
     ******************/
    public static boolean joinQQGroup(String joinCode, String key, Activity activity) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(joinCode)) {
            intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + key));
        } else {
            intent.setData(Uri.parse(joinCode));
        }

        // 此Flag可根据具体产品需要自定义，如设置，则在加群界面按返回，返回手Q主界面，不设置，按返回会返回到呼起产品界面    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            // 未安装手Q或安装的版本不支持
            return false;
        }
    }

//    //判断账号是否被注册了
//    public static void isExist(String account, String bindtype) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("account", account);
//
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//
//        apiService.isAccountExist(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<IsAccountExistRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(IsAccountExistRet ret) {
//
//                        if (ret != null) {
//                            if (ret.getCode() == 200) {
//                                if (ret.getData() != null) {
//                                    CallbackUtils.doIsAccountExistCallback(ret.getData().isExist(), account, bindtype);
//                                }
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    //绑定账号
//    public static void bindAccount(String account, String type, String userPassword, String vcode) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("account", account);
//        requestParams.put("bindType", type);
//        if (!TextUtils.isEmpty(userPassword)) {
//            requestParams.put("passWord", userPassword);
//        }
//        if (!TextUtils.isEmpty(vcode)) {
//            requestParams.put("vCode", vcode);
//        }
//
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//
//        apiService.bindAccount(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess()) {
//                                if (ret.getData() != null) {
//                                    CallbackUtils.doIsBindAccountCallback(ret.getData().isResult(), account);
//                                }
//                                if (TextUtils.equals(type, "1")) {
//                                    bindPhoneNumber(account);
//                                }
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    //发送验证码
//    public static void sendVcode(String account, String type, int whichinterface) {
//        sendVcode(account, type, -1, whichinterface);
//    }
//
//    //发送验证码
//    public static void sendVcode(String account, String type, int sysType, int whichinterface) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("account", account);//手机号/邮箱
//        requestParams.put("type", type);//1：手机；2：邮箱；
//        if (sysType != -1) {
//            //sysType等于-1是指某些不需要传sysType的接口（例如解散团签），该参数可以为空
//            requestParams.put("sysType", sysType);//1:登录；2：账号注销
//        }
//
//        if (type.matches("1")) {
//            requestParams.put("whichinterface", whichinterface);//验证码发送次数
//        }
//        RequestBody body = requestParams.getBody();
//        apiService.sendVCode(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess()) {
//                                ToastUtils.showShort("验证码已发送,请注意查收");
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
////                        whichinterface++;
//                    }
//                });
//    }
//
//    public static void exit(Context mContext) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        apiService.exitApp(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//                        unbindPhoneNumber();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess() && ret.getData().isResult()) {
//                                ToastUtils.showShort("已退出");
//                                //退出清除accseToken 2018/01/26 qmc
//                                SPUtils.putString("accessToken", "");
//
//                                //小部件刷新按钮的标记置为false,然后采用回调的方式清除桌面小组件数据
//                                SPUtils.putBoolean( "widget", false);
//                                CallbackUtils.doMyWidgetCallBackMethod(0);
//
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    //获取用户信息
//    public static void getUserInfo() {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.getUserInfo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<UserInfoRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(UserInfoRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200) {
//                                if (ret.getData() != null) {
//                                    CallbackUtils.doUserInfoCallBackMethod(ret);
//                                }
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    public static void getUserWifiOnLine() {
//        RequestParams requestParams = new RequestParams();
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.getUserWifiList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<UserWifiListRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(UserWifiListRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200) {
//                                if (ret.getData() != null) {
//                                    List<Wifi> wifisOnline = new ArrayList<>();
//                                    List<String> wifiNames = new ArrayList<>();
//                                    for (UserWifiListRet.DataBean dataBean : ret.getData()) {
//                                        Wifi wifi = new Wifi();
//                                        wifi.setUserID(App.getApp().getUserID());
//                                        wifi.setIsUpload(true);
//                                        wifi.setWifiId(dataBean.getWifiId());
//                                        wifi.setName(dataBean.getName());
//                                        wifi.setAlias(dataBean.getAlias());
//                                        wifi.setProperty(dataBean.getProperty());
//                                        wifisOnline.add(wifi);
//                                        wifiNames.add(dataBean.getName());
//                                    }
//                                    QueryUtil.queryWifiList(wifisOnline);
//
//                                    List<Wifi> wifisDB = getDBWifi();
//                                    List<Wifi> wifisTotal = new ArrayList<>();
//
//                                }
//
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    public static List<Wifi> getDBWifi() {
//        App.getApp().getDaoSession().clear();
//        QueryBuilder<Wifi> builder = App.getApp().getDaoSession().getWifiDao().queryBuilder();
//        builder.where(
//                WifiDao.Properties.UserID.eq(App.getApp().getUserID())
//        );
//        builder.orderAsc(WifiDao.Properties.Id);
//        List<Wifi> wifilist = builder.build().list();
//        return wifilist;
//    }
//
//    public static void delWifi(Wifi wifi) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("name", wifi.getName());
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.deleteWifi(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess()) {
//                                if (ret.getData() != null) {
//                                    if (ret.getData().isResult()) {
//                                        wifi.setActionType(3);
//                                        wifi.setIsUpload(true);
//                                    }
//                                    App.getApp().getDaoSession().getWifiDao().delete(wifi);
//                                    sendWifiBroadcast();
//                                }
//
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    public static void modifyWifi(Wifi wifi) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("alias", wifi.getAlias());
//        requestParams.put("name", wifi.getName());
//        requestParams.put("property", wifi.getProperty());
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.modifyWifi(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess()) {
//                                if (ret.getData() != null) {
//                                    if (ret.getData().isResult()) {
//                                        wifi.setActionType(2);
//                                        wifi.setIsUpload(true);
//                                    }
//                                    App.getApp().getDaoSession().getWifiDao().update(wifi);
//                                    sendWifiBroadcast();
//                                }
//
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    public static void addWifi(Wifi wifi) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("alias", wifi.getAlias());
//        requestParams.put("name", wifi.getName());
//        requestParams.put("property", wifi.getProperty());
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.addWifi(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<AddWifiRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(AddWifiRet ret) {
//                        if (ret != null) {
//                            if (ret.getCode() == 200 && ret.isSuccess()) {
//                                if (ret.getData() != null) {
//                                    String wifiId = ret.getData().getClassId();
//                                    wifi.setWifiId(wifiId);
//                                    wifi.setActionType(1);
//                                    wifi.setIsUpload(true);
//                                    App.getApp().getDaoSession().getWifiDao().update(wifi);
//                                    sendWifiBroadcast();
//
//                                }
//
//                            } else {
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    public static void sendWifiBroadcast() {
//        Intent intent = new Intent();
//        intent.setAction("WifiBroadcast");
//        App.getApp().sendBroadcast(intent);
//    }
//
//
//    //已完成/时间轴内容删除  (1已完成 2时间轴)
//    public static void logDel(int delType, String indexId) {
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("delType", delType);
//        requestParams.put("indexId", indexId);
//
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//
//        apiService.logDel(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(BaseRet ret) {
//                        if (ret != null) {
//                            if (ret.isSuccess()) {
//                            } else {
//
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                        }
//                    }
//                });
//    }
//
//    //阿里云解绑短信推送的手机号
//    public static void unbindPhoneNumber() {
//        UserInfo userInfo = QueryUtil.getUserInfo();
//        if (userInfo != null && !TextUtils.isEmpty(userInfo.getMobile())) {
//            CloudPushService pushService = PushServiceFactory.getCloudPushService();
//            pushService.unbindPhoneNumber(new CommonCallback() {
//                @Override
//                public void onSuccess(String s) {
//                }
//
//                @Override
//                public void onFailed(String s, String s1) {
//                }
//            });
//        }
//    }
//
//
//    //阿里云绑定短信推送的手机号
//    public static void bindPhoneNumber(String mobile) {
//        if (!TextUtils.isEmpty(mobile)) {
//            CloudPushService pushService = PushServiceFactory.getCloudPushService();
//            pushService.bindPhoneNumber(mobile, new CommonCallback() {
//                @Override
//                public void onSuccess(String s) {
////                    LogUtils.d("aliyunPush", "Mobile=" + mobile);
//                }
//
//                @Override
//                public void onFailed(String s, String s1) {
////                                                LogUtils.d("aliyunPush", "getMobile====" + userInfo.getMobile());
////                                                LogUtils.d("aliyunPush", "s====" + s);
////                                                LogUtils.d("aliyunPush", "s1====" + s1);
//                }
//            });
//        }
//    }
//
//    //修改用户设置
//    public static void userSetModify(RequestParams requestParams) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        String localVersion = SPUtils.getString(ConstValue.SyncVersion,"0");
//        requestParams.put("version", localVersion);
//        apiService.userSetModify(requestParams.getBody())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<VersionResRet>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络链接异常，请检查网络或稍后重试！");
//                    }
//
//                    @Override
//                    public void onNext(VersionResRet ret) {
//                        if(ret == null){
//                            return;
//                        }
//                        if(!ret.isSuccess() || ret.getCode() != 200 || !ret.getData().isResult()){
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        ToastUtils.showShort("设置成功");
//                        TurnPublishService.startActionWithParameter(App.getApp(), null, TurnPublishService.ACTION_SYNC_PERSON);
//                        try {
//                            Iterator iterator = requestParams.getmJSONObject().keys();
//                            while (iterator.hasNext()) {
//                                String key = (String) iterator.next();
//                                if (TextUtils.equals(key, "newSkinColor")) {
//                                    UserSetting userSetting = QueryUtil.getUserSetting();
//                                    String newSkinColor = (String) requestParams.getmJSONObject().get("newSkinColor");
//                                    if (!TextUtils.isEmpty(newSkinColor)) {
//                                        UserSettingDao userSettingDao = App.getApp().getDaoSession().getUserSettingDao();
//                                        userSetting.setNewSkinColor(newSkinColor);
//                                        userSettingDao.update(userSetting);
//                                    }
//                                }
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
//
//    public static void sysQqGroupConfig(Activity activity,String bizType, final String callBackKey,boolean flag) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.sysQqGroupConfig(bizType)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<QqGroupConfigRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if(activity != null && flag){
//                            joinQQGroup("",ConstValue.QQ_GROUP_KEY, activity);
//                        }
//
//                    }
//
//                    @Override
//                    public void onNext(QqGroupConfigRet ret) {
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void getNoteContentId(final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.getNoteContentId()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<NoteIdRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, null);
//                    }
//
//                    @Override
//                    public void onNext(NoteIdRet ret) {
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void getAliOssConfig(final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.getAliOssConfig()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<AliOssRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(AliOssRet ret) {
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void setQRScan(String cId, String classId,String status, String versionNum,final String callBackKey, final ProgressBar pb_loading) {
//        pb_loading.setVisibility(View.VISIBLE);
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("cId", cId);
//        requestParams.put("classId", classId);
//        requestParams.put("versionNum", versionNum);
//        requestParams.put("status", status);
//
//        RequestBody body = requestParams.getBody();
//        apiService.setQRScan(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<TwoCodeRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    @Override
//                    public void onNext(TwoCodeRet ret) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        } catch (Exception e1) {
//                        }
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200 || ret.getData() == null) {
//                            if(ret.getCode() == 420){
//                                ToastUtils.showShort(ret.getMsg());
//                            }
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void recordQRCode(String contentId, final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("contentId", contentId);
//
//        RequestBody body = requestParams.getBody();
//        apiService.recordQRCode(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(BaseRet ret) {
//
//                    }
//                });
//    }
//
//    public static void qrScan(String contentId, final String callBackKey, final ProgressBar pb_loading) {
//        try {
//            pb_loading.setVisibility(View.VISIBLE);
//        }catch (Exception e){
//
//        }
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("contentId", contentId);
//
//        RequestBody body = requestParams.getBody();
//        apiService.qrScan(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<SaomaNoteDetailRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("内容请求失败 " + e.toString());
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e1){
//
//                        }
//                    }
//
//                    @Override
//                    public void onNext(SaomaNoteDetailRet ret) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e1){
//
//                        }
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200 || ret.getData() == null) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void reportSync(final String callBackKey, final ProgressBar pb_loading) {
//        pb_loading.setVisibility(View.VISIBLE);
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        apiService.reportSync()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ReportInfoRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("网络请求失败 " + e.toString());
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        } catch (Exception e1) {
//                        }
//                    }
//
//                    @Override
//                    public void onNext(ReportInfoRet ret) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        } catch (Exception e1) {
//                        }
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200 || ret.getData() == null) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void reportSync(String cId,String reportIds,String describe, final String callBackKey, final ProgressBar pb_loading) {
//        try {
//            pb_loading.setVisibility(View.VISIBLE);
//        }catch (Exception e){
//
//        }
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("cId", cId);
//        requestParams.put("reportIds", reportIds);
//        requestParams.put("describe", describe);
//
//        RequestBody body = requestParams.getBody();
//        apiService.reportSync(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e1){
//
//                        }
//                    }
//
//                    @Override
//                    public void onNext(BaseRet ret) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e){
//
//                        }
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void delNoteFile(String cId, final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("cId", cId);
//
//        RequestBody body = requestParams.getBody();
//        apiService.delNoteFile(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<DelNoteFileRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("删除时间轴图片失败");
//                    }
//
//                    @Override
//                    public void onNext(DelNoteFileRet ret) {
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void delFile(String cId,List<FileUrls> fileUrls, final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("cId", cId);
//        requestParams.put("fileUrls", fileUrls);
//
//        RequestBody body = requestParams.getBody();
//        apiService.delFile(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BaseRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("删除时间轴图片失败");
//                    }
//
//                    @Override
//                    public void onNext(BaseRet ret) {
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void replaceFile(String cId,String oldCId,String classId,List<FileUrls> list, final String callBackKey, final ProgressBar pb_loading) {
//        try {
//            pb_loading.setVisibility(View.VISIBLE);
//        }catch (Exception e){
//
//        }
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//        requestParams.put("cId", cId);
//        requestParams.put("oldCId", oldCId);
//        requestParams.put("classId", classId);
//        requestParams.put("fileds", list);
//
//        RequestBody body = requestParams.getBody();
//        apiService.replaceFile(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<NoteFileListRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ToastUtils.showShort("上传附件失败");
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e1){
//
//                        }
//                    }
//
//                    @Override
//                    public void onNext(NoteFileListRet ret) {
//                        try {
//                            pb_loading.setVisibility(View.GONE);
//                        }catch (Exception e1){
//
//                        }
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void getTipInfo(final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//
//        apiService.getTipInfo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<TipInfoRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(TipInfoRet ret) {
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }
//
//    public static void setTipInfo(final String callBackKey) {
//        ApiService apiService = ApiRetrofit.getRetrofit().getApiService();
//        RequestParams requestParams = new RequestParams();
//
//        RequestBody body = requestParams.getBody();
//        apiService.setTipInfo(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<BooleanRet>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(BooleanRet ret) {
//                        if (ret == null) {
//                            return;
//                        }
//                        if (ret.getCode() != 200) {
//                            ToastUtils.showShort(ret.getMsg());
//                            return;
//                        }
//                        CallbackUtils.doResponseCallBackMethod(callBackKey, ret);
//
//                    }
//                });
//    }


}
