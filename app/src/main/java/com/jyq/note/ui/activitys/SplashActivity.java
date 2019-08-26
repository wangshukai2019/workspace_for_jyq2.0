package com.jyq.note.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.jyq.note.R;
import com.jyq.note.consts.ConstValue;
import com.jyq.note.utils.SPUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by pc on 2019/8/26.
 */

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity{

    @AfterViews
    void AfterViews() {
        //是否第一次安装0:false 1:true
        int isFirstRunning = SPUtils.getInt(ConstValue.isFirstRunning,0);//默认第一次安装
        if(isFirstRunning == 0){
            //第一次安装
            Intent intent = new Intent(SplashActivity.this, ContainerActivity_.class);
            Bundle bundle = new Bundle();
            bundle.putInt(ContainerActivity.FragmentTag, ContainerActivity.GuideFragmentTag);
            intent.putExtras(bundle);
            startActivity(intent);
            SplashActivity.this.finish();
        } else {
            //登陆标记
            String accessToken = SPUtils.getString(ConstValue.accessToken,"");
            String userSecret = SPUtils.getString(ConstValue.userKey,"");
            if(TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(userSecret)){
                Intent intent = new Intent(SplashActivity.this, ContainerActivity_.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ContainerActivity.FragmentTag, ContainerActivity.LoginFramgentTag);
                intent.putExtras(bundle);
                startActivity(intent);
                SplashActivity.this.finish();
            } else {
                Intent intent = new Intent(SplashActivity.this,MainActivity_.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }
    }

}
