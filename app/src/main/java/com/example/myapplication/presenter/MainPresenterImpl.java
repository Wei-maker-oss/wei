package com.example.myapplication.presenter;

import com.example.myapplication.contract.MainContract;
import com.example.myapplication.model.MainModelImpl;

public class MainPresenterImpl implements MainContract.IMainPresenter {

    private MainContract.IMainView mainView;
    private MainContract.IMainModel mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModelImpl(this);

    }

    @Override
    public void login(String name, String pass) {
        mainModel.getLoginDate();
    }

    @Override
    public void loginResult(String result) {
        mainView.getLoginDate(result);
    }
}
