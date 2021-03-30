
package dzf.live.module_login.presenter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.dzf.live.utils.HanziToPinyin;
import com.dzf.mvp.BaseObserver;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.ArrayList;
import java.util.List;

import dzf.live.library_photo.PhotoPicker;
import dzf.live.module_login.R;
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

        addSubscribe(create(LoginApiService.class).login(telephone, HanziToPinyin.getInstance().md5Decode(HanziToPinyin.getInstance().md5Decode(password))),
                new BaseObserver<LoginBean>(getView()) {
                    @Override
                    protected void onSuccess(LoginBean data) {
                        getView().backLoginSuc(data);
                    }

                    @Override
                    protected void onFail(Throwable data) {
                        getView().backLoginFail(data.getMessage());
                    }

                });

    }

    @Override
    public void initPhotoPicker(Activity context, ArrayList selectedPhotos) {
        AndPermission.with(context)
                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
//                        PhotoPicker.builder()
//                                .setPhotoCount(1)
//                                .setShowCamera(true)
//                                .setPreviewEnabled(true)
//                                .setSelected(selectedPhotos)
//                                .start(context);

                        PhotoPicker.builder()
                                .setPhotoCount(1)
                                .setPreviewEnabled(true)
//                                .setOpenCamera(true)
                                .setShowCamera(true)
                                .setCrop(false)
                                .setCropXY(1, 1)
                                .start(context);
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                    }
                }).start();
    }
}

