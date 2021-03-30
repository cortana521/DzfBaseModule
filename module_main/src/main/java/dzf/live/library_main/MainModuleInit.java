package dzf.live.library_main;

import android.app.Application;

import com.dzf.live.base.IModuleInit;
import com.dzf.live.utils.LogUtils;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/29
 * Time: 14:51
 */
public class MainModuleInit implements IModuleInit {
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
