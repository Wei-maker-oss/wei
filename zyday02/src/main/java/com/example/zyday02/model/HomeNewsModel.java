package com.example.zyday02.model;

import com.example.zyday02.ApiServer;
import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.bean.NewsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeNewsModel {
    public void request(HomeCallback homeCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getNewsDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean value) {
                        if (homeCallback != null) {
                            homeCallback.onScuess(value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeCallback.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
