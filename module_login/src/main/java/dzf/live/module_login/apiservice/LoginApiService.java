package dzf.live.module_login.apiservice;


import com.dzf.mvp.BaseResponse;

import dzf.live.module_login.bean.LoginBean;
import dzf.live.module_login.bean.RegisterBean;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApiService {
    /**
     * 注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse<RegisterBean>> register(@Field("username") String username,
                                                    @Field("password") String password,
                                                    @Field("repassword") String repassword);

    /**
     * 登录
     * @param telephone
     * @param password
     * @return
     */
    @POST("index.php?g=mobile&m=register&a=login")
    @FormUrlEncoded
    Observable<BaseResponse<LoginBean>> login(@Field("telephone") String telephone,
                                              @Field("password") String password);

    /**
     * 数据展示
     * @param page
     * @return
     */
    @GET("/index.php")
    Observable<BaseResponse<LoginBean>> datashow(@Query("g=hrm&m=forum&a=index&{page}") int page);


}
