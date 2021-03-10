package dzf.live.module_login;

import android.app.Application;

import com.dzf.live.base.IModuleInit;
import com.dzf.live.utils.LogUtils;


public class LoginModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        LogUtils.e("主业务模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        LogUtils.e("主业务模块初始化 -- onInitLow");
        return false;
    }
}
