package com.example.zyday02.presenter;

import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.HomeModel;
import com.example.zyday02.model.HomeNewsModel;
import com.example.zyday02.view.IHomeNewsView;
import com.example.zyday02.view.IVHomeView;

public class HomeNewsPresenterImllp {
    private IHomeNewsView mView;
    private HomeNewsModel model;

    public HomeNewsPresenterImllp(IHomeNewsView mView) {
        this.mView = mView;
        model = new HomeNewsModel();
    }

    public void start() {
        model.request(new HomeCallback() {
            @Override
            public void onScuess(Object object) {
                mView.onShowScuess(object);

            }

            @Override
            public void onFail(String msg) {
                mView.onShowFail(msg);
            }
        });
    }
}
