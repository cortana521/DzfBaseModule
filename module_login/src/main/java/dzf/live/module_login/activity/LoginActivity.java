package dzf.live.module_login.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dzf.live.router.RouterActivityPath;
import com.dzf.live.utils.ToastUtils;
import com.dzf.live.view.ClearEditText;
import com.dzf.mvp.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import dzf.live.module_login.R;
import dzf.live.module_login.R2;
import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;
import dzf.live.module_login.contract.LoginContract;
import dzf.live.module_login.presenter.LoginPresenter;

@Route(path = RouterActivityPath.Login.PAGER_LOGIN)
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements
        LoginContract.View {

    @Autowired(name = "title")
    String title;
    private ClearEditText cetName, cetPsd;
    private TextView tvLogin;
    private TextView tvRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @Override
    public void init() {

        cetName = findViewById(R.id.cetName);
        cetPsd = findViewById(R.id.cetPsd);
        tvLogin = findViewById(R.id.tvLogin);
        tvRegister = findViewById(R.id.tvRegister);


        tvLogin.setOnClickListener(View -> {
            getPresenter().login(cetName.getText().toString(), cetPsd.getText().toString());
        });
        tvRegister.setOnClickListener(View -> {
            ARouter.getInstance().build(RouterActivityPath.Login.PAGER_REGISTER)
                    .navigation();
        });

    }

    @Override
    public boolean isOpenImmersive() {
        return true;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void backRegisterSuc(RegisterBean mRegisterBean) {

    }

    @Override
    public void backLoginSuc(LoginBean mLoginBean) {
//        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN)
//                .navigation();
//        finish();
    }

    @Override
    public void backRegisterFail(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public void backLoginFail(String msg) {
        ToastUtils.showToast(this, msg);
    }

}
