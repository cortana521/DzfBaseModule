package dzf.live.module_login.fragment;


import com.dzf.mvp.BaseFragment;

import dzf.live.module_login.R;
import dzf.live.module_login.contract.LoginContract;
import dzf.live.module_login.presenter.LoginPresenter;


public class LoginFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login_layout;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(mContext);
    }

    @Override
    public LoginContract.View createView() {
        return null;
    }

    @Override
    public void init() {
//
    }

}
