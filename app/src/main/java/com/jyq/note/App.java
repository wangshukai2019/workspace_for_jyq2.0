package com.jyq.note;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.jyq.note.utils.LogUtils;

/**
 * Created by pc on 2019/8/26.
 */

public class App extends Application{
    private static App mApp;
    private int mActivityCount = 0;//activity计数

    public static App getApp() {
        if(null == mApp){
            mApp = new App();
        }
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                LogUtils.print("onActivityCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mActivityCount++;
                LogUtils.print("onActivityStarted mActivityCount == "+ mActivityCount);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtils.print("onActivityResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                LogUtils.print("onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                mActivityCount--;
                LogUtils.print("onActivityStopped  mActivityCount == "+ mActivityCount);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                LogUtils.print("onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                LogUtils.print("onActivityDestroyed");
            }
        });

    }
}
