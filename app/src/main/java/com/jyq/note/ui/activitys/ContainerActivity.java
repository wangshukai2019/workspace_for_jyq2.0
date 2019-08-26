package com.jyq.note.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jyq.note.R;
import com.jyq.note.ui.fragments.BaseFragment;
import com.jyq.note.ui.fragments.GuideFragment;
import com.jyq.note.ui.fragments.LoginFragment;
import com.jyq.note.utils.CallbackUtils;
import com.jyq.note.utils.LogUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/*
 * 大部分activity的容器，为了节约代码
 * **/
@EActivity(R.layout.activity_container)
public class ContainerActivity extends BaseActivity {
    private Bundle bundle = null;
    public static final String FragmentTag = "FragmentTag";

    @AfterViews
    void afterViews() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            Message msg = new Message();
            msg.what = 1;
            msg.arg1 = bundle.getInt(FragmentTag, 0);
            handler.sendMessage(msg);
        }
    }

    public static final int GuideFragmentTag = 1;//向导
    public static final int LoginFramgentTag = 2;//登陆


    private BaseFragment getFragment(int tag) {
        switch (tag) {
            case GuideFragmentTag:
                return GuideFragment.newInstance(bundle);
            case LoginFramgentTag:
                return LoginFragment.newInstance(bundle);
            default:
                return null;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    try {
                        loadRootFragment(R.id.fr_base_container, getFragment(msg.arg1));
                    } catch (Exception e) {
                        LogUtils.print( "页面加载异常 ： " + e.toString());
                    }

                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //该activity下的fragment都可以通过实现CallbackUtils.OnActivityCallBack接口获取回调传值
        CallbackUtils.doResponseCallback(requestCode, resultCode, data);
    }
}
