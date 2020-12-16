package com.example.zyday02.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zyday02.R;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WelcomActivity extends AppCompatActivity {
    private TextView welcom_tv;
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        initView();
        initTime();
    }

    private void initView() {
        welcom_tv=findViewById(R.id.welcom_tv);
    }

    private void initTime() {
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        int timer = (int) (5 - aLong);
                        if (timer > 0) {
                            welcom_tv.setText("剩余" + timer + "秒");
                        } else {
                            startActivity(new Intent(WelcomActivity.this, LoginActivity.class));
                            subscribe.dispose();
                        }
                    }
                });
    }
}