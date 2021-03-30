package com.dzf.mvp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.dzf.live.utils.ResUtil;
import com.dzf.live.utils.StatusBarUtil;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;


/**
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 */
public abstract class BaseActivity<V extends BaseViewImp, P extends BasePresenter<V>> extends AppCompatActivity {

    //引用V层和P层
    private P presenter;
    private V view;
    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉TitleBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (isOpenImmersive()) {
            immersive();
        }
        ButterKnife.bind(this);
        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 禁止所有的activity横屏

        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
        init();
    }

    //由子类指定具体类型
    public abstract int getLayoutId();

    public abstract P createPresenter();

    public abstract V createView();

    public abstract void init();

    /**
     * 是否使用沉浸式，子类复写该方法来确定是否采用沉浸式
     *
     * @return
     */
    public boolean isOpenImmersive() {
        return true;
    }

    /**
     * 具体沉浸的样式，可以根据需要自行修改状态栏和导航栏的颜色
     */
    public void immersive() {
        StatusBarUtil.setColor(this, ResUtil.getColor(R.color.nine_image_text_color),0);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
