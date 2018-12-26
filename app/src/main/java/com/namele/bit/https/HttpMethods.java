package com.namele.bit.https;


import com.namele.bit.info.TestBean;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yangbo on 2018/2/10
 */

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 10;  //默认超时时间
    public static final String BASE_URL = Http.TEST_ROOT;

    private Retrofit retrofit;
    private ApiService apiService;

    private static final HttpMethods ourInstance = new HttpMethods();

    public static HttpMethods getInstance() {
        return ourInstance;
    }

    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
            //builder.addInterceptor(new LoggingInterceptor());
        }


        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }


    private <T> void toSubscribe(Observable<T> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Function<HttpResult<T>, T> {

        /**
         * Apply some calculation to the input value and return some other value.
         *
         * @param tHttpResult the input value
         * @return the output value
         * @throws Exception on error
         */
        @Override
        public T apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
            if (tHttpResult.getCode() != 1) {
                throw new ApiException(tHttpResult.getCode());
            }
            return tHttpResult.getData();
        }
    }

    /**
     * @param subscriber
     */
    public void collectRedPackge(Observer<TestBean> subscriber, Map<String, String> params) {
        Observable<TestBean> observable = apiService.collectRedPackge(params);
        toSubscribe(observable, subscriber);
    }

}
