package com.dzf.live.router;

/**
 *
 * Created by jhonjson on 2019/2/20
 * @describe 用于组件开发中，ARouter单Activity跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 */

public class RouterActivityPath {
    /**
     * 主业务组件
     */
    public static class Main {
        private static final String MAIN = "/main";
        /*主业务界面*/
        public static final String PAGER_MAIN = MAIN +"/main";
    }

    /**
     * 登陆业务组件
     */
    public static class Login {
        private static final String LOGIN = "/login";
        /*登陆业务界面*/
        public static final String PAGER_LOGIN = LOGIN +"/login";

        /*注册业务界面*/
        public static final String PAGER_REGISTER = LOGIN +"/Register";
    }


    /**
     * 登陆业务组件
     */
    public static class Setting {

        private static final String SETTING = "/Setting";
        /*关于界面*/
        public static final String PAGER_SETTING_ABOUT = SETTING +"/about";
    }

}
