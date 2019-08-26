package com.jyq.note.ui.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.jyq.note.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by pc on 2019/8/26.
 */

@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity{

    @AfterViews
    void AfterViews() {
        Intent intent = new Intent(SplashActivity.this, ContainerActivity_.class);
        Bundle bundle = new Bundle();
        bundle.putInt(ContainerActivity.FragmentTag, ContainerActivity.GuideFragmentTag);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

}
