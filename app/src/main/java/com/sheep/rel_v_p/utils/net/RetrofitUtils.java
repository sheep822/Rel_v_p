package com.sheep.rel_v_p.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements NetWorkInterface {

    private static volatile RetrofitUtils retrofitUtils;
    private final ApiService apiService;

    private RetrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    @Override
    public <B> void get(String url, RelCallBack<B> callBack) {
        apiService.get(url)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            callBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <B> void post(String url, RelCallBack<B> callBack) {
        apiService.post(url)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            callBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <B> void psotpar(String url, HashMap<String, String> map, RelCallBack<B> callBack) {
        apiService.postpar(url, map)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            callBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
