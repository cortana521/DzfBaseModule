package com.dzf.mvp;

import android.database.Observable;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/5/25
 * Time: 14:24
 */
public interface UploadFileApi {

    @Multipart
    @POST
    Observable<ResponseBody> uploadFile(@Url String url, @Body MultipartBody body);
}
