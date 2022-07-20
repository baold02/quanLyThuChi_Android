package com.example.quanlythuchi_android.ACTIVITY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlythuchi_android.DAO.NguoiDungDao;
import com.example.quanlythuchi_android.R;

public class LoginActivity extends AppCompatActivity {
    EditText edttK, edtMk;
    Button btnDn, btnDk;
    NguoiDungDao nguoiDungDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
    }

    private void AnhXa(){
        nguoiDungDao = new NguoiDungDao(LoginActivity.this);
        edttK = findViewById(R.id.edtTk);
        edtMk = findViewById(R.id.edtMk);
        btnDn = findViewById(R.id.btnDn);
        btnDk = findViewById(R.id.btnDk);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}