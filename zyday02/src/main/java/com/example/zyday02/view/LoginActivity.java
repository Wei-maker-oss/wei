package com.example.zyday02.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zyday02.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private Button btn_login;
    private String mName;
    private String mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initDate();
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private void initDate() {
        mName = etName.getText().toString();
        mPass = etPassword.getText().toString();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mName=="H2003xs" && mPass=="H2003"){
                    // 页面跳转
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));

//            SharedPreferences sp = getSharedPreferences("abc", MODE_PRIVATE);
//            SharedPreferences.Editor edit = sp.edit();
//            SharedPreferences.Editor flage = edit.putBoolean("flage", true);

                }else {
                    Toast.makeText(LoginActivity.this, "输入错误", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }

            }
        });
    }
}