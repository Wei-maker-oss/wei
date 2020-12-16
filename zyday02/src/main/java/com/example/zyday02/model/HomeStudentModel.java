package com.example.zyday02.model;

import com.example.zyday02.ApiServer;
import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.bean.StudentBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeStudentModel {
    public void request(HomeCallback homeCallback) {
        new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getStudentDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StudentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StudentBean value) {
                        if(homeCallback !=null){
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
