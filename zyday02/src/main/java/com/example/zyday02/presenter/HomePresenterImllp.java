package com.example.zyday02.presenter;

import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.HomeModel;
import com.example.zyday02.view.IVHomeView;

public class HomePresenterImllp {
    private IVHomeView mView;
    private HomeModel model;

    public HomePresenterImllp(IVHomeView mView) {
        this.mView = mView;
        model=new HomeModel();
    }

    public void starBanner() {
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
