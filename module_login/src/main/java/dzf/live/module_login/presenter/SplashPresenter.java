package dzf.live.module_login.presenter;

import android.content.Context;
import android.util.Log;

import dzf.live.module_login.contract.SplashContract;


public class SplashPresenter extends SplashContract.Presenter {

    private Context context;

    public SplashPresenter(Context context) {
        this.context = context;
    }


    @Override
    public void getList() {

        Log.e("getList", "getList 请求数据  getList");
    }
}
