package dzf.live.library_main.activity;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.dzf.live.router.RouterActivityPath;
import com.dzf.mvp.BaseActivity;
import com.dzf.mvp.BaseModel;

import dzf.live.library_main.contract.MainContract;
import dzf.live.library_main.presenter.MainPresenter;
import dzf.live.module_main.R;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<MainContract.MainView,MainContract.Presenter> implements MainContract.MainView {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public MainContract.MainView createView() {
        return this;
    }

    @Override
    public void init() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onErrorCode(BaseModel model) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onProgress(int progress) {

    }
}
