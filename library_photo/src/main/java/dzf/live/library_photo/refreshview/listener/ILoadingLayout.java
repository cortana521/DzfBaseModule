package dzf.live.library_photo.refreshview.listener;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2020/10/12
 * Time: 10:44
 */
public interface ILoadingLayout {
    public void pullToRefresh();

    public void releaseToRefresh();

    public void refreshing();

    public void normal();
}
