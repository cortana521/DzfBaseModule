package dzf.live.module_login.activity;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dzf.live.base.BaseAppManager;
import com.dzf.live.router.RouterActivityPath;
import com.dzf.live.utils.ToastUtils;
import com.dzf.live.view.ClearEditText;
import com.dzf.mvp.BaseActivity;

import dzf.live.module_login.R;
import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;
import dzf.live.module_login.contract.LoginContract;
import dzf.live.module_login.presenter.LoginPresenter;

@Route(path = RouterActivityPath.Login.PAGER_REGISTER)
public class RegisterActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements
        LoginContract.View, View.OnClickListener {

    @Autowired(name = "title")
    String title;
    private ClearEditText cetName1, cetPsd1, cetPsd2;
    private TextView tvRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
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
        cetName1 = findViewById(R.id.cetName1);
        cetPsd2 = findViewById(R.id.cetPsd2);
        cetPsd1 = findViewById(R.id.cetPsd1);
        tvRegister = findViewById(R.id.tvLogin1);

        tvRegister.setOnClickListener(View -> {
            getPresenter().register(cetName1.getText().toString(), cetPsd1.getText().toString(), cetPsd2.getText().toString());
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
        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN)
                .navigation();
        BaseAppManager.getAppManager().finishActivity(LoginActivity.class);
        finish();
    }

    @Override
    public void backLoginSuc(LoginBean mLoginBean) {
        ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN)
                .navigation();
        finish();
    }

    @Override
    public void backRegisterFail(String msg) {
        ToastUtils.showToast(this, msg);

    }

    @Override
    public void backLoginFail(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
//        if (R.id.tvLogin == id) {
//            getPresenter().login("jhonjson", "qs110134");
//        }
    }
}
