package com.example.zyday02.presenter;

import com.example.zyday02.callback.HomeCallback;
import com.example.zyday02.model.HomeNewsModel;
import com.example.zyday02.model.HomeStudentModel;
import com.example.zyday02.view.IHomeNewsView;
import com.example.zyday02.view.IHomeStudentsView;

public class HomeStudentPresenterImllp {
    private IHomeStudentsView mView;
    private HomeStudentModel model;

    public HomeStudentPresenterImllp(IHomeStudentsView mView) {
        this.mView = mView;
        model=new HomeStudentModel();
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
