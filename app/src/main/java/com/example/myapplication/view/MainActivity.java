package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.contract.MainContract;
import com.example.myapplication.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainContract.IMainView {

    private EditText editTextName;
    private EditText editTextPass;
    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName=findViewById(R.id.et_name);
        editTextPass=findViewById(R.id.et_pass);

        presenter = new MainPresenterImpl(this);
    }

    @Override
    public String getUserName() {
        return editTextName.getText().toString();
    }

    @Override
    public String getUserPass() {
        return editTextPass.getText().toString();
    }

    // 数据返回
    @Override
    public void getLoginDate(String string) {

    }
}