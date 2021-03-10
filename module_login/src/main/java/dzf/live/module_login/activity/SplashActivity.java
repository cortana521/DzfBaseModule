package dzf.live.module_login.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;


import com.dzf.live.utils.StatusBarUtil;
import com.dzf.mvp.BaseActivity;

import dzf.live.module_login.R;
import dzf.live.module_login.contract.SplashContract;
import dzf.live.module_login.presenter.SplashPresenter;

@SuppressLint("Registered")
public class SplashActivity extends BaseActivity<SplashContract.View,
        SplashContract.Presenter> implements SplashContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public SplashContract.Presenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public SplashContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        StatusBarUtil.setTranslucent(this,0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goMain();
            }
        }, 3 * 1000);
    }

    /**
     * 进入主页面
     */
    private void goMain() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
