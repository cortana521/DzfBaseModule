package com.dzf.live.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.dzf.live.R;
import com.dzf.live.utils.Utils;
import com.dzf.live.view.LoadingLayout;



public class BaseApplication extends Application {
    private static Application sInstance;
    private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
        context = this;
        LoadingLayout.getConfig()
                .setErrorText("出错啦~请稍后重试！")
                .setEmptyText("抱歉，暂无数据")
                .setNoNetworkText("无网络连接，请检查您的网络···")
                .setErrorImage(R.drawable.define_error)
                .setEmptyImage(R.drawable.define_empty)
                .setNoNetworkImage(R.drawable.define_nonetwork)
                .setAllTipTextColor(R.color.gray)
                .setAllTipTextSize(14)
                .setReloadButtonText("点我重试哦")
                .setReloadButtonTextSize(14)
                .setReloadButtonTextColor(R.color.gray)
                .setReloadButtonWidthAndHeight(150, 40)
                .setAllPageBackgroundColor(R.color.background);
    }

    /**
     * 当主工程没有继承BaseApplication时，可以使用setApplication方法初始化BaseApplication
     *
     * @param application
     */
    public static synchronized void setApplication(Application application) {
        sInstance = application;
        //初始化工具类
        Utils.init(application);

        //注册监听每个activity的生命周期,便于堆栈式管理
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
               BaseAppManager.getAppManager().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
              BaseAppManager.getAppManager().removeActivity(activity);
            }
        });
    }

    /**
     * 获得当前app运行的Application
     */
    public static Application getInstance() {
        if (sInstance == null) {
            throw new NullPointerException("please inherit BaseApplication or call setApplication.");
        }
        return sInstance;
    }

    public Context getContext() {
        return context;
    }


//    ModuleNativeModule moduleNativeModule;
//
//    @Override
//    public ModuleNativeModule getModuleNativeModule() {
//
//        if (null == moduleNativeModule) {
//            moduleNativeModule = new ModuleNativeModule();
//        }
//        return moduleNativeModule;
//    }
}
