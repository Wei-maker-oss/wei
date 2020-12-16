package com.example.myapplication.contract;

public class MainContract {

    public interface IMainView{
        String getUserName();
        String getUserPass();

        void getLoginDate(String string);
    }

    public interface IMainModel{
        void getLoginDate();
    }

    public interface IMainPresenter{
        void login(String name,String pass);
        void loginResult(String result);
    }
}
