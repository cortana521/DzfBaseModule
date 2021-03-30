package dzf.live.library_main.contract;

import com.dzf.mvp.BasePresenter;
import com.dzf.mvp.BaseViewImp;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/29
 * Time: 14:52
 */
public interface MainContract {

    interface MainView extends BaseViewImp {

    }

    abstract class Presenter extends BasePresenter<MainView> {


    }
}
