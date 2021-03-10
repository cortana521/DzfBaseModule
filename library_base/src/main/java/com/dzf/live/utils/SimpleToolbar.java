package com.dzf.live.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.dzf.live.R;

import androidx.appcompat.widget.Toolbar;

/**
 * @author HuangFusheng
 * 自定义Toolbar
 */
public class SimpleToolbar extends Toolbar {
    /**
     * 左侧Title
     */
    private ImageView mImgtLeftTitle;

    /**
     * 中间Title
     */
    private TextView mTxtMiddleTitle;
    /**
     * 右侧Title
     */
    private TextView mTxtRightTitle;

    /**
     * 右侧mipmap
     */
    public ImageView mImgRightTitle;


    private Context context;

    public SimpleToolbar(Context context) {
        this(context, null);
    }

    public SimpleToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_simple_toolbar, this);
        mImgtLeftTitle = (ImageView) findViewById(R.id.img_left_title);
        mTxtMiddleTitle = (TextView) findViewById(R.id.txt_main_title);
        mTxtRightTitle = (TextView) findViewById(R.id.txt_right_title);
        mImgRightTitle = (ImageView) findViewById(R.id.img_right_title);
    }


    //设置中间title的内容
    public void setMainTitle(String text) {
        this.setTitle(" ");
        mTxtMiddleTitle.setVisibility(View.VISIBLE);
        mTxtMiddleTitle.setText(text);
    }

    //设置中间title的内容文字的颜色
    public void setMainTitleColor(int color) {
        mTxtMiddleTitle.setTextColor(color);
    }

    //设置title左边图标
    public void setLeftTitleDrawable(int res) {
        mImgtLeftTitle.setVisibility(View.VISIBLE);
        mImgtLeftTitle.setImageResource(res);
    }

    //设置title左边点击事件
    public void setLeftTitleClickListener(OnClickListener onClickListener) {
        mImgtLeftTitle.setOnClickListener(onClickListener);
    }

    //设置title右边文字
    public void setRightTitleText(String text) {
        mTxtRightTitle.setVisibility(View.VISIBLE);
        mImgRightTitle.setVisibility(GONE);
        mTxtRightTitle.setText(text);
    }

    //设置title右边文字颜色
    public void setRightTitleColor(int color) {
        mTxtRightTitle.setTextColor(color);
    }

    //设置title右边图标
    public void setRightTitleDrawable(int res) {
        mTxtRightTitle.setVisibility(View.GONE);
        mImgRightTitle.setVisibility(View.VISIBLE);
        mImgRightTitle.setImageResource(res);
    }


    public void setRightTitleVisibility(boolean visibility) {
        if (!visibility)
            mImgRightTitle.setVisibility(GONE);
        else
            mImgRightTitle.setVisibility(VISIBLE);
    }

    public void setRightTextVisibility(boolean visibility) {
        if (!visibility)
            mTxtRightTitle.setVisibility(GONE);
        else
            mTxtRightTitle.setVisibility(VISIBLE);
    }

    //设置title右边文字点击事件
    public void setRightTitleClickListener(OnClickListener onClickListener) {
        mTxtRightTitle.setOnClickListener(onClickListener);
    }

    //设置右边图标点击事件
    public void setRightImgClickListener(OnClickListener onClickListener) {
        mImgRightTitle.setOnClickListener(onClickListener);
    }

    //设置标题点击事件
    public void setTitleClickListener(OnClickListener onClickListener) {
        mTxtMiddleTitle.setOnClickListener(onClickListener);
    }
}
