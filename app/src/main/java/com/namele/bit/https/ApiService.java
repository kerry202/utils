package com.namele.bit.https;



import com.namele.bit.info.TestBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by yangbo on 2018/2/10
 */

public interface ApiService {

    /**
     * @return
     */
    //get请求方式  少量参数注解用@Query 参数多QueryMap
    @GET(Http.APP_CHECKVERSION)
    Observable<TestBean> collectRedPackge(@QueryMap Map<String, String> fields);

    ////POST请求注解@FieldMap
    //注册
    @FormUrlEncoded
    @POST(Http.APP_CHECKVERSION)
    Observable<TestBean> Register(@FieldMap Map<String, String> fields);


}
