package com.dzf.mvp;

/**
 * View 父类接口
 */
public interface BaseViewImp {
    /**
     * 显示 loading
     */
    void showLoading();

    /**
     * 隐藏 loading
     */
    void hideLoading();

    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showError(String msg);

    /**
     * 错误码
     */
    void onErrorCode(BaseModel model);

    /**
     * 进度条显示
     */
    void showProgress();

    /**
     * 进度条隐藏
     */
    void hideProgress();

    /**
     * 文件下载进度监听
     *
     * @param progress
     */
    void onProgress(int progress);

}
