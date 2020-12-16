package com.example.myapplication.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T>  extends AppCompatActivity {
    public T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if(presenter == null){
            presenter=getPresenter();
        }

        initView();
        initDate();
    }

    protected abstract void initDate();
    protected abstract void initView();
    protected abstract int getLayoutID();
    public abstract T getPresenter();
}
