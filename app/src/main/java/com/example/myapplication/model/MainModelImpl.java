package com.example.myapplication.model;

import com.example.myapplication.contract.MainContract;

public class MainModelImpl implements MainContract.IMainModel {
    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getLoginDate() {
        presenter.loginResult("登录成功");
    }
}
