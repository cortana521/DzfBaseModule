package dzf.live.module_login.contract;


import com.dzf.mvp.BasePresenter;
import com.dzf.mvp.BaseViewImp;

public interface SplashContract {

    interface View extends BaseViewImp {


    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getList();
    }

}
