package dzf.live.module_login.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.dzf.live.router.RouterActivityPath;
import com.dzf.live.utils.LogUtils;
import com.dzf.live.utils.ToastUtils;
import com.dzf.live.view.ClearEditText;
import com.dzf.mvp.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import dzf.live.library_photo.PhotoPicker;
import dzf.live.library_photo.PhotoPreview;
import dzf.live.module_login.R;
import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;
import dzf.live.module_login.contract.LoginContract;
import dzf.live.module_login.presenter.LoginPresenter;

@Route(path = RouterActivityPath.Login.PAGER_LOGIN)
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements
        LoginContract.View {
    private ArrayList<String> selImageList = new ArrayList<>(); //当前选择的所有图片
    @Autowired(name = "title")
    String title;
    private ClearEditText cetName, cetPsd;
    private TextView tvLogin;
    private TextView tvRegister;
    private ImageView ivPic;

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
        ivPic = findViewById(R.id.ivPic);
        cetName = findViewById(R.id.cetName);
        cetPsd = findViewById(R.id.cetPsd);
        tvLogin = findViewById(R.id.tvLogin);
        tvRegister = findViewById(R.id.tvRegister);

        ivPic.setOnClickListener(View -> {
            LogUtils.e("点击了");
            getPresenter().initPhotoPicker(this,selImageList);
        });

        tvLogin.setOnClickListener(View -> {
//            getPresenter().login(cetName.getText().toString(), cetPsd.getText().toString());
            ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
            finish();
        });
        tvRegister.setOnClickListener(View -> {
            ARouter.getInstance().build(RouterActivityPath.Login.PAGER_REGISTER)
                    .navigation();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selImageList.clear();
        //选择返回
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {
            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            }
            if (photos != null) {
                selImageList.addAll(photos);
            }
//            adapter.notifyDataSetChanged();
        }
//        num.setText(selImageList.size() + "/9");
        //拍照功能或者裁剪功能返回
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.CROP_CODE) {
//            recyclerView.setVisibility(View.GONE); data.getStringExtra(PhotoPicker.KEY_CAMEAR_PATH)
            selImageList.add(data.getStringExtra(PhotoPicker.KEY_CAMEAR_PATH));

        }
        LogUtils.e(selImageList.toString());
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
