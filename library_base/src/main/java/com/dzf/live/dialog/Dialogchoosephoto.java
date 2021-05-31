package com.dzf.live.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dzf.live.R;


/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2020/8/28
 * Time: 14:57
 */
public abstract class Dialogchoosephoto extends Dialog implements View.OnClickListener {

    private Activity activity;
    private RelativeLayout btnPickBySelect, btnPickByTake;
    private TextView tv_canvas, tv_photo;

    public Dialogchoosephoto(Activity activity) {
        super(activity, R.style.AlertDialogStyle);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_dialog);

        btnPickBySelect = (RelativeLayout) findViewById(R.id.btnPickBySelect);
        btnPickByTake = (RelativeLayout) findViewById(R.id.btnPickByTake);
        tv_canvas = (TextView) findViewById(R.id.tv_canvas);
        tv_photo = (TextView) findViewById(R.id.tv_photo);

        btnPickBySelect.setOnClickListener(this);
        btnPickByTake.setOnClickListener(this);

        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnPickBySelect) {
            btnPickBySelect();
            this.cancel();

        } else if (i == R.id.btnPickByTake) {
            btnPickByTake();
            this.cancel();

        }
    }

    public Dialogchoosephoto setTextContent(String content, String textContent) {
        tv_canvas.setText(content);
        tv_photo.setText(textContent);

        return this;
    }

    public abstract void btnPickBySelect();

    public abstract void btnPickByTake();

}
