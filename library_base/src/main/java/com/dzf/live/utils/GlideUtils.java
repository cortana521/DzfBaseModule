package com.dzf.live.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dzf.live.R;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/29
 * Time: 17:39
 */
public class GlideUtils {
    private static GlideUtils instance;

    public static GlideUtils getInstance() {
        if (instance == null) {//主要为了避免不必要的同步
            synchronized (GlideUtils.class) {
                if (instance == null) {  //为了在空的情况下创建实例
                    instance = new GlideUtils();
                }
            }
        }
        return instance;
    }


    public void setImageViewPhoto(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.image_loading)
//                .error(R.drawable.pick)
                .into(imageView);
    }

}
