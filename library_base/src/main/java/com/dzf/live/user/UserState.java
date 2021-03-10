package com.dzf.live.user;


import com.dzf.live.utils.SharePreUtils;

public class UserState {

    public static String getUserId() {

        return SharePreUtils.getString("userid");
    }

}
