package com.dzf.live.debug;


import com.dzf.live.base.BaseApplication;
import com.dzf.live.config.ModuleLifecycleConfig;

/**
 * Created by jhonjson on 2019/2/20
 */

public class DebugApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }
}
