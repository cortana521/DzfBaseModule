package dzf.live.library_main.presenter;

import android.content.Context;

import dzf.live.library_main.contract.MainContract;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/29
 * Time: 14:54
 */
public class MainPresenter extends MainContract.Presenter {

    private Context mContext;

    public MainPresenter(Context context) {
        mContext = context;
    }
}
