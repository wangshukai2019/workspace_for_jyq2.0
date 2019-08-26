package com.jyq.note.https;

import com.jyq.note.https.responses.LoginRet;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author ChayChan
 * @description: 网络请求的service
 * @date 2017/6/18  19:28
 */

public interface ApiService {

    //登录
    @POST("user/login")
    Observable<LoginRet> login(@Body RequestBody body);

    //登录
    @POST("user/phonelogin")
    Observable<LoginRet> loginMsgCode(@Body RequestBody body);

    //互联登录
    @POST("user/login/oauth")
    Observable<LoginRet> directlogin(@Body RequestBody body);

//    @POST("note/class/clear")
//    Observable<BooleanRet> clearClass(@Body RequestBody body);
//
//    //发送验证码
//    @POST("tool/sendVCode")
//    Observable<BooleanRet> sendVCode(@Body RequestBody body);
//
//    //校验验证码
//    @POST("tool/valideVCode")
//    Observable<BooleanRet> valideVCode(@Body RequestBody body);
//
//    //找回密码
//    @POST("user/safe/pwd/find")
//    Observable<BooleanRet> findPwd(@Body RequestBody body);
//
//    //注册
//    @POST("user/register")
//    Observable<RegisterRet> regist(@Body RequestBody body);
//
//
//    @GET("user/sysSet")
//    Observable<UserSetRet> getUserSet();
//
//    //修改用户设置
//    @POST("user/sysSet/modify")
//    Observable<VersionResRet> userSetModify(@Body RequestBody body);
//
//
//    //修改用户信息
//    @POST("user/userInfo/modify")
//    Observable<VersionResRet> userInfoModify(@Body RequestBody body);
//
//    //--------------------------团队便签接口------------------------------
//    //    检测团队Id是否存在
//    @POST("team/isExistId")
//    Observable<BooleanRet> isTeamExistId(@Body RequestBody body);
//
//    //    团队详情信息
//    @POST("team/detailInfo")
//    Observable<TeamDetailInfoRet> getTeamDetailInfo(@Body RequestBody body);
//
//    // 搜索团队列表
//    @POST("team/search")
//    Observable<GetTeamListRet> getSearchTeamList(@Body RequestBody body);
//
//    // 申请加入团队
//    @POST("team/userJoin")
//    Observable<BooleanRet> getJoinTeam(@Body RequestBody body);
//
//    // 退出团队
//    @POST("team/userExit")
//    Observable<BooleanRet> exitTeam(@Body RequestBody body);
//
//    //   我的团队
//    @POST("team/myTeams")
//    Observable<MyTeamRet> getMyTeams();
//
//    //   团签日志
//    @POST("team/noteLog")
//    Observable<TeamNoteLogRet> getTeamNoteLog(@Body RequestBody body);
//
//    //   团签完成日志
//    @POST("team/noteCompleted")
//    Observable<TeamNoteCompletedRet> getTeamNoteCompleted(@Body RequestBody body);
//
//
//    //   获取团队版本变化记录
//    @POST("team/teamSync")
//    Observable<TSyncRet> getTeamSync(@Body RequestBody body);
//
//    //获取创建团签所需信息
//    @POST("team/createTeamDetailInfo")
//    Observable<TeamDetailInfotPermissionRet> getCreateTeamDetailInfo();
//
//    //   创建团队
//    @POST("team/create")
//    Observable<VersionResRet> createTeam(@Body RequestBody body);
//
//    //   修改团队
//    @POST("team/modify")
//    Observable<VersionResRet> reviseTeam(@Body RequestBody body);
//
//    //   启动/暂停用户付费
//    @POST("team/modifyUserStaus")
//    Observable<BooleanRet> modifyUserStaus(@Body RequestBody body);
//
//    //   修改团队个人信息
//    @POST("team/modifyUserInfo")
//    Observable<VersionResRet> reviseTeamUserInfo(@Body RequestBody body);
//
//    //   解散团队
//    @POST("team/disbandage")
//    Observable<VersionResRet> dissolveTeam(@Body RequestBody body);
//
//    //   删除成员
//    @POST("team/deleteUser")
//    Observable<VersionResRet> deleteUser(@Body RequestBody body);
//
//    //   获取团队成员列表
//    @POST("team/teamUsers")
//    Observable<TeamUsersRet> getTeamUsers(@Body RequestBody body);
//
//    //获取团队申请列表
//    @POST("team/userJoinRequest")
//    Observable<GetTeamApplyListRet> getTeamApplyList(@Body RequestBody body);
//
//    //拒绝用户加入团队
//    @POST("team/declineUser")
//    Observable<BooleanRet> refuseJoinApply(@Body RequestBody body);
//
//    //同意用户加入团队
//    @POST("team/allowUser")
//    Observable<VersionResRet> agreeJoinApply(@Body RequestBody body);
//
//
//    //   获取用户的所有版本号
//    @POST("user/versionNums")
//    Observable<TeamVersionRet> getTeamVersionNums(@Body RequestBody body);
//
//    //上传图片
//    @Multipart
//    @POST("tool/upload/img")
//    Observable<FilePathRet> uploadPic(@Part MultipartBody.Part imgs);
//
//    //获取用户信息
//    @GET("user/userInfo")
//    Observable<UserInfoRet> getUserInfo();
//
//    // 获取系统终端列表
//    @POST("sys/terminal/list")
//    Observable<AboutRet> getSystemEndList(@Body RequestBody body);
//
//    // 判断账号是否已经被注册
//    @POST("user/isExist")
//    Observable<IsAccountExistRet> isAccountExist(@Body RequestBody body);
//
//    // 判断唯一标示unionID判断是否此号已经绑定
//    @POST("user/isExist/oauth")
//    Observable<IsAccountExistRet> isOauthExist(@Body RequestBody body);
//
//    // 绑定账号
//    @POST("user/safe/bind")
//    Observable<BooleanRet> bindAccount(@Body RequestBody body);
//
//    // 设置账号归属人
//    @POST("user/safe/accountattributionsetting")
//    Observable<IsSuccRet> setOwner(@Body RequestBody body);
//
//    // 绑定账号
//    @POST("user/safe/oauth/bind")
//    Observable<BooleanRet> bindOauth(@Body RequestBody body);
//
//    // 更改绑定
//    @POST("user/safe/changeBind")
//    Observable<BooleanRet> changeBind(@Body RequestBody body);
//
//    // 解除绑定
//    @POST("user/safe/clearBind")
//    Observable<BooleanRet> clearBind(@Body RequestBody body);
//
//    // QQ解绑
//    @POST("user/safe/oauth/clearBind")
//    Observable<BooleanRet> unbindQQ(@Body RequestBody body);
//
//    // 互联登陆辅助接口
//    @POST("tool/oauthUnionIDByAccToken")
//    Observable<InterConnectRet> interConnectLand(@Body RequestBody body);
//
//    // 退出
//    @POST("user/logout")
//    Observable<BooleanRet> exitApp(@Body RequestBody body);
//
//    // 修改密码
//    @POST("user/safe/pwd/modify")
//    Observable<BooleanRet> modifyPwd(@Body RequestBody body);
//
//    //日志时间轴
//    @GET("note/log/timeAxis")
//    Observable<GetTimeAxisRet> getTimeAxis(@Query("classIds") String classIds,
//                                           @Query("actionType") int actionType,
//                                           @Query("indexId") String indexId,
//                                           @Query("page") int page,
//                                           @Query("pageSize") int pageSize,
//                                           @Query("sortType") int sortType);
//
//    //删除数据
//    @POST("user/data/delete")
//    Observable<VersionResRet> delData(@Body RequestBody body);
//
//    // 提意见
//    @POST("user/feedback")
//    Observable<BooleanRet> feedBack(@Body RequestBody body);
//
//    // 未登陆获取用户信息
//    @POST("user/userInfo/nologin")
//    Observable<UserInfoRet> getUserInfoNologin(@Body RequestBody body);
//
//    //    修改用户定期推送
//    @POST("user/sysSet/timePush/modify")
//    Observable<VersionResRet> setUserTimePush(@Body RequestBody body);
//
//    //    修改用户内容推送
//    @POST("user/data/push/content")
//    Observable<VersionResRet> setUserContentPush(@Body RequestBody body);
//
//    //快照列表
//    @GET("user/data/snapshot/list")
//    Observable<SnapshotListRet> getSpanShotData();
//
//    //    快照还原
//    @POST("user/data/snapshot/restore")
//    Observable<VersionResRet> setSnapShot(@Body RequestBody body);
//
//    //便签已完成列表
//    @GET("note/log/completed")
//    Observable<GetCompletedListRet> getCompleted(@Query("classIds") String classIds,
//                                                 @Query("indexId") String indexId,
//                                                 @Query("page") int page,
//                                                 @Query("pageSize") int pageSize);
//
//    //便签内容列表
//    @GET("note/content/list/component")
//    Observable<GetContentListRet> getContentList(@Query("classIds") String classIds,
//                                                 @Query("dataType") int dataType,
//                                                 @Query("page") int page,
//                                                 @Query("pageSize") int pageSize);
//
//    //团签便签内容提醒列表
//    @GET("team/content/list/time")
//    Observable<TeamNoteRemaindRet> getTeamRemindContentList(@Query("sortType") int sortType,
//                                                            @Query("page") int page,
//                                                            @Query("pageSize") int pageSize);
//
//    //下载APK文件
//    @GET
//    @Streaming
//    Observable<ResponseBody> downloadFile(@Url String url);
//
//    @GET
//    @Streaming
////GET下载文件必须结合@Streaming使用
//    Observable<ResponseBody> downLoadImg(@Url String url);
//
//    @POST("sys/terminal/list")
//    Observable<PlatformVersionRet> getPalformVersion(@Body RequestBody body);
//
//    // 团队冻结信息
//    @POST("team/freezeInfo")
//    Observable<FreezeInfoRet> getTeamFreezeInfo(@Body RequestBody body);
//
//
//    //微信信息
//    @GET("sns/userinfo")
//    Observable<WechatRet> getUserInfo_Wechat(@Query("access_token") String access_token,
//                                             @Query("openid") String openid);
//
//    //微信登陆token
//    @GET("sns/oauth2/access_token")
//    Observable<WechatTokenRet> getAccessToken_Wechat(@Query("appid") String appid,
//                                                     @Query("secret") String secret,
//                                                     @Query("code") String code,
//                                                     @Query("grant_type") String grant_type);
//
//    //    清除分类下面的内容
//    @POST("note/class/clear")
//    Observable<BooleanRet> clearNoteByCategory(@Body RequestBody body);
//
//
//    @POST("user/wifi/delete")
//    Observable<BooleanRet> deleteWifi(@Body RequestBody body);
//
//    // 打赏下单
//    @POST("user/gratuityjyq")
//    Observable<RewardRet> rewardOrder(@Body RequestBody body);
//
//    @POST("user/wifi/modify")
//    Observable<BooleanRet> modifyWifi(@Body RequestBody body);
//
//    @POST("user/wifi/add")
//    Observable<AddWifiRet> addWifi(@Body RequestBody body);
//
//    @GET("user/wifi/list")
//    Observable<UserWifiListRet> getUserWifiList();
//
//    //同步便签内容(下载)
//    @GET("note/sync")
//    Observable<SyncDownloadNoteRet> syncDownloadNote(@Query("version") String version,
//                                                     @Query("isDetail") int isDetail);
//
//    @GET("sys/qq/groupConfig")
//    Observable<QqGroupConfigRet> sysQqGroupConfig(@Query("bizType") String bizType);
//
//    //同步便签内容(上传{删除，增加，修改})
//    @POST("note/sync")
//    Observable<SyncUploadNoteRet> syncUploadCategoryContent(@Body RequestBody body);
//
//    //获取广告信息
//    @GET("ad/adSync")
//    Observable<AdRet> getAdInfo();
//
//    //检测oppenId是否可以找回密码
//    @POST("user/check/oauth/findPwd")
//    Observable<BooleanRet> isOppenIdValid(@Body RequestBody body);
//
//
//    //修改我的团队信息
//    @POST("team/modifyMyInfo")
//    Observable<VersionResRet> modifyMyInfo(@Body RequestBody body);
//
//    //修改团队成员权限
//    @POST("team/modifyUserPermissions")
//    Observable<VersionResRet> modifyUserPermissions(@Body RequestBody body);
//
//    //   提交团签内容  newAPI
//    @POST("team/noteSave")
//    Observable<TeamNoteSyncRet> saveTeamNote(@Body RequestBody body);
//
//    //团签完成接口
//    @POST("team/noteCompleteSave")
//    Observable<TeamNoteCompleteRet> noteCompleteSave(@Body RequestBody body);
//
//    //团签已读接口
//    @POST("team/noteRead")
//    Observable<VersionResRet> noteRead(@Body RequestBody body);
//
//
//    //团签已读/完成接口
//    @POST("team/noteAppointeesSave")
//    Observable<VersionResRet> noteAppointeesSave(@Body RequestBody body);
//
//    //团签用户充值请求
//    @POST("team/finance/recharge")
//    Observable<RewardRet> teamRecharge(@Body RequestBody body);
//
//    //团签充值记录
//    @POST("team/finance/rechargeRecord")
//    Observable<TeamRechargeRecordRet> teamRechargeRecord(@Body RequestBody body);
//
//    //团签点数消费记录
//    @POST("team/pointConsumeRecord")
//    Observable<TeamPointRecordRet> pointConsumeRecord(@Body RequestBody body);
//
//    //团签短信消费记录
//    @POST("team/smsConsumeRecord")
//    Observable<TeamSMSRecordRet> smsConsumeRecord(@Body RequestBody body);
//
//    //获取充值页面信息
//    @POST("team/rechargeSync")
//    Observable<ReChargeSyncRet> teamRechargeSync(@Body RequestBody body);
//
//    //团签内容迁入迁出
//    @POST("team/noteOccupySave")
//    Observable<BooleanRet> teamNoteOccupySave(@Body RequestBody body);
//
//    //团签搜索
//    @POST("team/searchNotes")
//    Observable<TeamSearchRet> teamNotesSearch(@Body RequestBody body);
//
//
//    //获取加入团签二维码数据
////    @POST("team/teamJoinQrCode")
////    Observable<ReChargeSyncRet> teamRechargeSync(@Body RequestBody body);
//
//    //已完成/时间轴内容删除
//    @POST("note/logDel")
//    Observable<BaseRet> logDel(@Body RequestBody body);
//
//
//    //测试Code回调
//    @POST("note/revokeCompleted")
//    Observable<BaseRet> revokeCompleted(@Body RequestBody body);
//
//    //测试Code回调
//    @POST("note/syncTest")
//    Observable<BaseRet> codeTest(@Body RequestBody body);
//
//    //获取阿里OSS配置信息(请求类型：get，json)
//    @GET("sys/aliOSSConfig")
//    Observable<AliOssRet> getAliOssConfig();
//
//
//    //获取提醒推送设置信息
//    @POST("user/setRemindPushInfo")
//    Observable<RemindPushInfoRet> getRemindPushInfo(@Body RequestBody body);
//
//    //内容提醒推送设置
//    @POST("user/setRemindPushModify")
//    Observable<VersionResRet> setRemindPushModify(@Body RequestBody body);
//
//    //充值下单接口
//    @POST("finance/onlineOrder")
//    Observable<OnlineOrderRet> getOnlineOrder(@Body RequestBody body);
//
//    //充值提交接口(请求类型：post，json)
//    @POST("finance/rechargeSubmit")
//    Observable<RewardRet> rechargeSubmit(@Body RequestBody body);
//
//    //Vip会员商品(请求类型：get，json)
//    @GET("finance/vipGoods")
//    Observable<GoodsRet> getVipGoods();
//
//    //空间商品(请求类型：get，json)
//    @GET("finance/spaceGoods")
//    Observable<GoodsRet> getSpaceGoods();
//
//    //获取短信/语音商品列表
//    @POST("finance/rechargeSync")
//    Observable<RechargeSmsCallRet> getSmsCallGoods(@Body RequestBody body);
//
//
//    //收银台活动(请求类型：get，json)
//    @POST("finance/cashierSync")
//    Observable<CashierRet> getCashier(@Body RequestBody body);
//
//    //订单结果详情(请求类型：post，json)
//    @POST("finance/orderDetail")
//    Observable<OrderDetailRet> getOrderDetail(@Body RequestBody body);
//
//    //vip充值记录(请求类型：post，json)
//    @POST("finance/vipOrderRecord")
//    Observable<OrderRecordRet> getVipOrderRecord(@Body RequestBody body);
//
//    //个签二维码开关
//    @POST("note/setQRScan")
//    Observable<TwoCodeRet> setQRScan(@Body RequestBody body);
//
//    //记录二维码被保存
//    @POST("note/recordQRCode")
//    Observable<BaseRet> recordQRCode(@Body RequestBody body);
//
//    //扫码获取订单详情
//    @POST("note/qrScan")
//    Observable<SaomaNoteDetailRet> qrScan(@Body RequestBody body);
//
//    //获取举报所需数据
//    @GET("note/reportSync")
//    Observable<ReportInfoRet> reportSync();
//
//    //举报
//    @POST("note/reportSync")
//    Observable<BaseRet> reportSync(@Body RequestBody body);
//
//    //便签列表页删除图片
//    @POST("note/delNoteFile")
//    Observable<DelNoteFileRet> delNoteFile(@Body RequestBody body);
//
//    //内容详情页删除时间轴图片
//    @POST("note/delFile")
//    Observable<BaseRet> delFile(@Body RequestBody body);
//
//    //获取附件ID
//    @GET("note/contentId")
//    Observable<NoteIdRet> getNoteContentId();
//
//    //上传附件
//    @POST("note/uploadFile")
//    Observable<NoteFileRet> uploadNoteFile(@Body RequestBody body);
//
//    //复制附件接口
//    @POST("note/replaceFile")
//    Observable<NoteFileListRet> replaceFile(@Body RequestBody body);
//
//
//    //短信充值记录(请求类型：post，json)
//    @POST("finance/smsRechargeRecord")
//    Observable<OrderRecordRet> getSMSRecord(@Body RequestBody body);
//
//    //语音充值记录(请求类型：post，json)
//    @POST("finance/telRechargeRecord")
//    Observable<OrderRecordRet> getTelRecord(@Body RequestBody body);
//
//
//    //短信语音消费记录(请求类型：post，json)
//    @POST("finance/consumeRecord")
//    Observable<SMSTelConsumeRecordRet> getSMSTelConsumeRecord(@Body RequestBody body);
//
//    //轮播图
//    @POST("sys/carouselMap")
//    Observable<BannerRet> getBanner();
//
//
//    //获取用户VIP信息
//    @POST("user/vipInfo")
//    Observable<VipInfoRet> getVipInfo();
//
//
//    //系统公告
//    @GET("sys/topNotice")
//    Observable<TopNoticeRet> getTopNotice();
//
//    //VIP会员相关可开票金额
//    @GET("finance/mobileInvoiceInfo")
//    Observable<InvoiceInfoRet> getInvoiceInfo();
//
//
//    //关闭显示 接口
//    @POST("user/setVIPShowWarningBox")
//    Observable<BaseRet> setVIPShowWarningBox();
//
//    //校验优惠券码
//    @POST("finance/checkPromoCode")
//    Observable<CheckPromoCodeRet> CheckPromoCodeRet(@Body RequestBody body);
//
//    //推荐弹窗
//    @GET("ad/tipInfo")
//    Observable<TipInfoRet> getTipInfo();
//
//    //设置不显示弹窗
//    @POST("ad/setTipInfo")
//    Observable<BooleanRet> setTipInfo(@Body RequestBody body);


}

