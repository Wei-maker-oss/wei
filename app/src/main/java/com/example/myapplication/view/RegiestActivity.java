package com.example.myapplication.view;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.presenter.MainPresenterImpl;

public class RegiestActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {
    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    public MainPresenterImpl getPresenter() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPass() {
        return null;
    }

    @Override
    public void getLoginDate(String string) {

    }
}
