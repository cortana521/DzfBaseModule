package com.dzf.mvp;

import com.dzf.live.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/5/25
 * Time: 15:45
 */
public class MultipartBuilder {

    /**
     * 单文件上传构造.
     *
     * @param file 文件
     * @param requestBody 请求体
     * @return MultipartBody
     */
    public static MultipartBody fileToMultipartBody(File file, RequestBody requestBody) {
        MultipartBody.Builder builder = new MultipartBody.Builder();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("fileName", file.getName());
//        jsonObject.addProperty("fileSha", Utils.getFileSha1(file));
        jsonObject.addProperty("appId", "test0002");

        builder.addFormDataPart("file", file.getName(), requestBody);

        builder.addFormDataPart("params", jsonObject.toString());
        builder.setType(MultipartBody.FORM);
        return builder.build();
    }

    /**
     * 多文件上传构造.
     * @param files 文件列表
     * @param fileUploadObserver 文件上传回调
     * @return MultipartBody
     */
    public static MultipartBody filesToMultipartBody(List<File> files,
                                                     FileUploadObserver<ResponseBody> fileUploadObserver) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        JsonArray jsonArray = new JsonArray();

        Gson gson = new Gson();
        for (File file : files) {
            UploadFileRequestBody uploadFileRequestBody =
                    new UploadFileRequestBody(file, fileUploadObserver);
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("fileName", file.getName());
//            jsonObject.addProperty("fileSha", Utils.getFileSha1(file));
            jsonObject.addProperty("appId", "test0002");

            jsonArray.add(jsonObject);
            LogUtils.d(jsonObject.toString());
            builder.addFormDataPart("file", file.getName(), uploadFileRequestBody);
        }

        builder.addFormDataPart("params", gson.toJson(jsonArray));

        LogUtils.d(gson.toJson(jsonArray));
        builder.setType(MultipartBody.FORM);
        return builder.build();
    }
}
