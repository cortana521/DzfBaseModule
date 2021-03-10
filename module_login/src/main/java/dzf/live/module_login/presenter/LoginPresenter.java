
package dzf.live.module_login.presenter;


import android.content.Context;


import com.dzf.live.utils.HanziToPinyin;
import com.dzf.mvp.BaseObserver;

import dzf.live.module_login.apiservice.LoginApiService;
import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;
import dzf.live.module_login.contract.LoginContract;

public class LoginPresenter extends LoginContract.Presenter {

    private Context context;

    public LoginPresenter(Context context) {
        this.context = context;
    }


    //注册
    @Override
    public void register(String username, String password, String repassword) {
        addSubscribe(create(LoginApiService.class).register(username, password, password), new BaseObserver<RegisterBean>(getView()) {
            @Override
            protected void onSuccess(RegisterBean data) {
                getView().backRegisterSuc(data);
            }

            @Override
            protected void onFail(Throwable data) {
                getView().backRegisterFail(data.getMessage());
            }

        });
    }

    //登陆
    @Override
    public void login(String telephone, String password) {

//        addSubscribe(create(LoginApiService.class).login(telephone, HanziToPinyin.getInstance().md5Decode(HanziToPinyin.getInstance().md5Decode(password))),
//                new BaseObserver<LoginBean>(getView()) {
//            @Override
//            protected void onSuccess(LoginBean data) {
//                getView().backLoginSuc(data);
//            }
//
//            @Override
//            protected void onFail(Throwable data) {
//                getView().backLoginFail(data.getMessage());
//            }
//
//        });

        addSubscribe(create(LoginApiService.class).datashow(1), new BaseObserver() {
            @Override
            protected void onSuccess(Object data) {

            }

            @Override
            protected void onFail(Throwable data) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
    }
}

