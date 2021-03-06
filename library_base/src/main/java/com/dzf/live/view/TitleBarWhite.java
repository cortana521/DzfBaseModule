package com.dzf.live.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.dzf.live.R;
import com.dzf.live.utils.ResUtil;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;


/**
 * Created by dongxl on 2018/1/3.
 */

public class TitleBarWhite extends RelativeLayout {
    private Context mContext;

    private AppCompatTextView mTitleTV;
    private ProgressBar mTitleBarPB;
    private AppCompatImageView mFilterIV;

    private AppCompatImageView mTitleMiddleIV;

    private AppCompatImageView mTitleLeftIV;
    private AppCompatTextView mTitleLeftTV;

    private RelativeLayout mRightContent;
    private FrameLayout mTitleRightFl;
    private AppCompatTextView mTitleRightTV;
    private AppCompatImageView mTitleRightIV;
    private AppCompatImageView mTitleRight2IV;
    private AppCompatImageView mTitleRight3IV;
    private FrameLayout mTitleRight4IV;

    private LinearLayout mMiddleTitle;
    private AppCompatTextView mMiddleTitleTV1;
    private AppCompatTextView mMiddleTitleTV2;


    private View mTitleBottomLine;

    private int titleBarHeight;


    public TitleBarWhite(Context context) {
        this(context, null);
    }

    public TitleBarWhite(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarWhite(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleBarWhite(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @SuppressLint("ResourceType")
    private void init(Context context) {
        mContext = context;
        titleBarHeight = ResUtil.getDimens(mContext, 60);
        setTitleBarBackground(ResUtil.getColor(R.color.colorPrimary));
        LayoutInflater.from(mContext).inflate(R.layout.common_title_bar_white, this, true);
        ViewGroup.LayoutParams lp = this.getLayoutParams();
        if (null == lp) {
            lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, titleBarHeight);
        } else {
            lp.height = titleBarHeight;
        }
        this.setLayoutParams(lp);
        mTitleTV = (AppCompatTextView) findViewById(R.id.title_bar_title_TV);
        mTitleBarPB = (ProgressBar) findViewById(R.id.title_bar_PB);
        mFilterIV = (AppCompatImageView) findViewById(R.id.title_bar_filter_IV);

        mTitleMiddleIV = (AppCompatImageView) findViewById(R.id.title_bar_title_middle_IV);

        mTitleLeftIV = (AppCompatImageView) findViewById(R.id.title_bar_title_left_IV);
        mTitleLeftTV = (AppCompatTextView) findViewById(R.id.title_bar_title_left_TV);

        mRightContent = (RelativeLayout) findViewById(R.id.title_bar_right_content);

        mTitleRightFl = (FrameLayout) findViewById(R.id.title_bar_title_right_FL);
        mTitleRightTV = (AppCompatTextView) findViewById(R.id.title_bar_title_right_TV);

        mTitleRightIV = (AppCompatImageView) findViewById(R.id.title_bar_title_right_IV);
        mTitleRight2IV = (AppCompatImageView) findViewById(R.id.title_bar_title_right2_IV);
        mTitleRight3IV = (AppCompatImageView) findViewById(R.id.title_bar_title_right3_IV);
        mTitleRight4IV = findViewById(R.id.title_bar_title_right4_V);

        mTitleBottomLine = findViewById(R.id.title_bar_bottom_line);

        mMiddleTitle = findViewById(R.id.ll_title);
        mMiddleTitleTV1 = findViewById(R.id.title_bar_title_TV1);
        mMiddleTitleTV2 = findViewById(R.id.title_bar_title_TV2);
    }

    public void setTitleBarBackground(int color) {
        this.setBackgroundColor(color);
    }

    public void setTitleBarBackground(Drawable background) {
        this.setBackground(background);
    }

    public void setTitle(String title) {
        if (mTitleTV.getVisibility() != VISIBLE) {
            mTitleTV.setVisibility(VISIBLE);
        }
        mTitleTV.setText(title);
    }

    public void noTitleBar() {
        mOnLeftClick = null;
        setVisibility(View.GONE);
    }

    public AppCompatTextView getmTitleTV() {
        return mTitleTV;
    }

    public ProgressBar getmTitleBarPB() {
        return mTitleBarPB;
    }


    public void setTitleColor(int color) {
        if (mTitleTV.getVisibility() != VISIBLE) {
            mTitleTV.setVisibility(VISIBLE);
        }
        mTitleTV.setTextColor(color);
    }

    public void setLineVisibility(int visibility) {
        mTitleBottomLine.setVisibility(visibility);
    }

    public void setTitleLeftImageVisibility(int visible) {
        mTitleLeftIV.setVisibility(visible);
    }

    public void setLeftImage(Drawable d) {
        mTitleLeftIV.setImageDrawable(d);
        mTitleLeftIV.setVisibility(VISIBLE);
    }

    public void setLeftImageVisiable(boolean visiable) {
        mTitleLeftIV.setVisibility(visiable ? VISIBLE : GONE);
    }

    public void setRightTextVisibility(int visible) {
        mRightContent.setVisibility(visible);
        mTitleRightTV.setVisibility(visible);
    }

    /**
     * ??????????????????
     *
     * @param text
     */
    public void setLeftText(String text) {
        mTitleLeftTV.setVisibility(VISIBLE);
        mTitleLeftTV.setText(text);
    }

    public AppCompatTextView getLeftText() {
        return mTitleLeftTV;
    }

    //??????????????????
    public void setRightText(String text) {
        setRightTextVisibility(VISIBLE);
        mTitleRightTV.setText(text);
    }

    //??????????????????
    public AppCompatTextView getRightText() {
        return mTitleRightTV;
    }

    //????????????????????????
    public void setRightTextColor(int color) {
        mTitleRightTV.setTextColor(color);
    }

    /**
     * ???????????????????????????
     *
     * @param d
     */
    public void setRightImage(Drawable d) {
        mTitleRightIV.setImageDrawable(d);
        mRightContent.setVisibility(VISIBLE);
        mTitleRightIV.setVisibility(VISIBLE);
    }

    public AppCompatImageView getmTitleMiddleIV() {
//        mTitleMiddleIV.setVisibility(VISIBLE);
        return mTitleMiddleIV;
    }

    public AppCompatImageView getmTitleRightIV() {
        return mTitleRightIV;
    }

    /**
     * ???????????????????????????
     *
     * @param d
     */
    public void setRightImage2(Drawable d) {
        mTitleRight2IV.setImageDrawable(d);
        mRightContent.setVisibility(VISIBLE);
        mTitleRight2IV.setVisibility(VISIBLE);
    }

    /**
     * ???????????????????????????
     *
     * @param d
     */
    public void setRightImage3(Drawable d) {
        mTitleRight3IV.setImageDrawable(d);
        mRightContent.setVisibility(VISIBLE);
        mTitleRight3IV.setVisibility(VISIBLE);
    }

    /**
     * ???????????????????????????
     */
    public void setRightView4() {
        mRightContent.setVisibility(VISIBLE);
        mTitleRight4IV.setVisibility(VISIBLE);
    }

    public void setLeftOnClickListener(OnClickListener listener) {
        setTitleLeftImageVisibility(View.VISIBLE);
        mTitleLeftIV.setOnClickListener(listener);
    }

    public void setRightTextOnClickListener(OnClickListener listener) {
        mTitleRightTV.setOnClickListener(listener);
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param clickListener
     */
    public void setRightImageOnClickListener(OnClickListener clickListener) {
        mTitleRightIV.setOnClickListener(clickListener);
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param clickListener
     */
    public void setRightImage2OnClickListener(OnClickListener clickListener) {
        mTitleRight2IV.setOnClickListener(clickListener);
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param clickListener
     */
    public void setRightImage3OnClickListener(OnClickListener clickListener) {
        mTitleRight3IV.setOnClickListener(clickListener);
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param clickListener
     */
    public void setRightView4OnClickListener(OnClickListener clickListener) {
        mTitleRight4IV.setOnClickListener(clickListener);
    }

    public void setHeaderTitle(String title) {
        setUpMainTitle(title);
        mOnLeftClick = null;
        setTitleLeftImageVisibility(View.GONE);
        setRightTextVisibility(View.GONE);
    }


    public void setTitleBarWithLeftImage(String title) {
        this.setTitleBarWithLeftImage(title, null);
    }

    public void setTitleBarWithLeftImage(String title, OnLeftClick listener) {

        setUpMainTitle(title);

        setUpLeftImage(listener);

        setRightTextVisibility(View.GONE);
    }

    public void setTitleBarWithLeftAndRight(String title, String rightTitle, OnLeftClick leftListener, OnClickListener rightListener) {

        setUpMainTitle(title);

        setUpLeftImage(leftListener);

        setUpRightText(rightTitle, rightListener);
    }

    /**
     * ???????????????????????????????????????????????????????????????
     *
     * @param title         ??????
     * @param drawable      ????????????
     * @param leftListener  ????????????????????????
     * @param rightListener ????????????????????????
     */
    public void setTitleBarWithLeftAndRightImage(String title, Drawable drawable, OnLeftClick leftListener, OnClickListener rightListener) {

        setUpMainTitle(title);

        setUpLeftImage(leftListener);

        setUpRightImage(drawable, rightListener);
    }

    public void setTitleBarWithRight(String title, String rightTitle, OnClickListener rightListener) {

        setUpMainTitle(title);

        setUpRightText(rightTitle, rightListener);
    }


    /**
     * ???????????????
     *
     * @param title
     */
    public void setUpMainTitle(String title) {
        setVisibility(View.VISIBLE);
        setTitle(title);
    }

    /**
     * ???????????????????????????????????????
     *
     * @param listener
     */
    public void setUpLeftImage(OnLeftClick listener) {
        setTitleLeftImageVisibility(View.VISIBLE);

        mOnLeftClick = listener;
        setLeftOnClickListener(new TitleBarLeftDefaultListener());
    }

    /**
     * ???????????????????????????
     *
     * @param view
     */
    public void setUpRightCusView(View view) {
        setRightCusViewVisibility(View.VISIBLE);
//        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        lp.gravity = Gravity.CENTER_VERTICAL;
//        ViewGroup parent = (ViewGroup) v.getParent();
//
//        if (parent != null) {
//
//            parent.removeAllViews();
//
//        }
//        mTitleRightFl.addView(view, lp);
        mTitleRightFl.addView(view);
    }

    /**
     * ?????????????????????????????????
     *
     * @param visibility
     */
    public void setRightCusViewVisibility(int visibility) {
        mTitleRightFl.setVisibility(visibility);
        mRightContent.setVisibility(visibility);
    }

    /**
     * ???????????????view ??????
     *
     * @return
     */
    public View getRightCusView() {
        return mRightContent;
    }

    /**
     * ?????????????????????????????????
     *
     * @param rightTitle
     * @param rightListener
     */
    private void setUpRightText(String rightTitle, OnClickListener rightListener) {
        setRightText(rightTitle);
        if (rightListener != null) {
            setRightTextOnClickListener(rightListener);
        }
    }

    /**
     * ?????????????????????????????????
     *
     * @param drawable
     * @param rightListener
     */
    public void setUpRightImage(Drawable drawable, OnClickListener rightListener) {
        setRightImage(drawable);
        if (rightListener != null) {
            setRightImageOnClickListener(rightListener);
        }
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param drawable
     * @param rightListener
     */
    public void setUpRightImage2(Drawable drawable, OnClickListener rightListener) {
        setRightImage2(drawable);
        if (rightListener != null) {
            setRightImage2OnClickListener(rightListener);
        }
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param drawable
     * @param rightListener
     */
    public void setUpRightImage3(Drawable drawable, OnClickListener rightListener) {
        setRightImage3(drawable);
        if (rightListener != null) {
            setRightImage3OnClickListener(rightListener);
        }
    }

    /**
     * ??????????????????????????????????????????
     *
     * @param rightListener
     */
    public void setUpRightView4(OnClickListener rightListener) {
        setRightView4();
        if (rightListener != null) {
            setRightView4OnClickListener(rightListener);
        }
    }

    public int getTitleBarHeight() {
        return titleBarHeight;
    }

    /**
     * ??????????????????
     *
     * @param title1
     * @param title2
     */
    public void setMiddleTitle2(String title1, String title2) {
        if (mTitleTV.getVisibility() == VISIBLE) {
            mTitleTV.setVisibility(GONE);
        }
        if (mMiddleTitle.getVisibility() != VISIBLE) {
            mMiddleTitle.setVisibility(VISIBLE);
        }
        mMiddleTitleTV1.setText(title1);
        mMiddleTitleTV2.setText(title2);
    }

    public AppCompatTextView getmMiddleTitleTV1() {
        return mMiddleTitleTV1;
    }

    public AppCompatTextView getmMiddleTitleTV2() {
        return mMiddleTitleTV2;
    }

    private class TitleBarLeftDefaultListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        if (mOnLeftClick == null || !mOnLeftClick.onLeftClick()) {
            FragmentActivity activity = ((FragmentActivity) mContext);
            if (null != activity) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    if (!activity.isDestroyed()) {
                        activity.onBackPressed();
                    }
                } else {
                    activity.onBackPressed();
                }
            }
        }
    }

    private OnLeftClick mOnLeftClick;

    public interface OnLeftClick {
        /**
         * ?????????????????????????????????????????????
         *
         * @return true ???????????????????????? false ??????????????????
         * ????????????false??????????????????onBackPress????????????????????????????????????????????????????????????
         */
        boolean onLeftClick();
    }

}
