package dzf.live.library_photo.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import dzf.live.library_photo.R;
import dzf.live.library_photo.refreshview.listener.ILoadingLayout;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2020/10/12
 * Time: 11:01
 */
public class FootLoadingView extends LinearLayout implements ILoadingLayout {

    private TextView mTitleTv;
    private ProgressBar mProgress;

    public FootLoadingView(Context context) {
        this(context, null);
    }

    public FootLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.xscrollview_footer, this);
        mTitleTv = (TextView) findViewById(R.id.xscrollview_footer_hint_textview);
        mProgress = (ProgressBar) findViewById(R.id.xscrollview_footer_progressbar);
    }

    @Override
    public void pullToRefresh() {
        mTitleTv.setVisibility(View.VISIBLE);
        mTitleTv.setText(getResources().getString(
                R.string.xscrollview_footer_hint_normal));
    }

    @Override
    public void releaseToRefresh() {
        mTitleTv.setVisibility(View.VISIBLE);
        mTitleTv.setText(getResources().getString(
                R.string.xrefreshview_footer_hint_release));
    }

    @Override
    public void refreshing() {
        mTitleTv.setVisibility(View.INVISIBLE);
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void normal() {
        mTitleTv.setVisibility(View.VISIBLE);
        mTitleTv.setText(getResources().getString(
                R.string.xscrollview_footer_hint_normal));
        mProgress.setVisibility(View.GONE);
    }
}
