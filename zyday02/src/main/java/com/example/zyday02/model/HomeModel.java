package com.example.zyday02.model;

import android.util.Log;

import com.example.zyday02.ApiServer;
import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.bean.BannerBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeModel {
    public void request(HomeCallback homeCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getBannerDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean value) {
                        if(homeCallback !=null){
                            homeCallback.onScuess(value);
                        }
                        Log.e("TAG","请求成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(homeCallback!=null){
                            homeCallback.onFail(e.getMessage());
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
