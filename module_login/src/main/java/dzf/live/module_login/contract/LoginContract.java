package dzf.live.module_login.contract;

import com.dzf.mvp.BasePresenter;
import com.dzf.mvp.BaseViewImp;

import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;

public interface LoginContract {

    interface View extends BaseViewImp {

        void backRegisterSuc(RegisterBean mRegisterBean);
        void backLoginSuc(LoginBean mLoginBean);

        void backRegisterFail(String msg);
        void backLoginFail(String msg);
    }

   abstract class Presenter extends BasePresenter<View> {

       public abstract void register(String username, String password, String repassword);

       public abstract void login(String username, String password);
    }

}
