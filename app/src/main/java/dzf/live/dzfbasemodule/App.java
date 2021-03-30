package dzf.live.dzfbasemodule;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dzf.live.base.BaseApplication;
import com.dzf.live.config.ModuleLifecycleConfig;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/9
 * Time: 11:42
 */
public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }
}
