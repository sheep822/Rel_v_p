package com.sheep.two.utils.net;

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
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements NetWorkInterFace {
    private static volatile RetrofitUtils retrofitUtils;
    private final Apiservice apiservice;

    private RetrofitUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiservice = retrofit.create(Apiservice.class);
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
    public <B> void get(String url, RelCallBack<B> relCallBack) {
        apiservice.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = relCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            relCallBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        relCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <B> void post(String url, RelCallBack<B> relCallBack) {
        apiservice.post(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = relCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            relCallBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        relCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <B> void postpar(String url, HashMap<String, String> map, RelCallBack<B> relCallBack) {
        apiservice.postpar(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] interfaces = relCallBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            B b = new Gson().fromJson(json, type);
                            relCallBack.onSucess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        relCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
