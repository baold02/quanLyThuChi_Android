package com.example.quanlythuchi_android.ACTIVITY;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlythuchi_android.DAO.NguoiDungDao;
import com.example.quanlythuchi_android.Models.NguoiDung;
import com.example.quanlythuchi_android.R;

import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {
    EditText edtHoTen, edtSdt, edtTk, edtMK, edtLai;
    Button btnDk, btnHuy;
    NguoiDungDao nguoiDungDAO;
    Context context = SignUpActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AnhXa();
    }
    public void AnhXa(){
        nguoiDungDAO = new NguoiDungDao(context);
        edtHoTen = findViewById(R.id.edtHt);
        edtSdt = findViewById(R.id.edtSdt);
        edtTk = findViewById(R.id.edtTk);
        edtMK = findViewById(R.id.edtMk);
        edtLai = findViewById(R.id.edtLaiMk);
        btnDk = findViewById(R.id.btnDk);
        btnHuy =findViewById(R.id.btnHuy);
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });

    }

    public  void SignUp(){
      String hoTen, sdt, tk ,mk, lai_mk;
      hoTen =edtHoTen.getText().toString().trim();
      sdt = edtSdt.getText().toString().trim();
      tk = edtTk.getText().toString().trim();
      mk = edtMK.getText().toString().trim();
      lai_mk = edtLai.getText().toString().trim();
        try {
            NguoiDung user = new NguoiDung(
                    tk , mk , hoTen , "" , sdt,lai_mk
            );
            user.setTongSoTien("0");

            if (nguoiDungDAO.insertNguoiDung(user) > 0) {

                dialog_chung(1 , context , "Đăng Kí Thành Công");
                rememberUser(tk , mk , true);
                startActivity(new Intent(context , LoginActivity.class));
                finish();
            } else if ( nguoiDungDAO.checkLogin(user.getUserName() , user.getPassword()) > 0){

                dialog_chung(0 , context , "Tài Khoản đã tồn tại !\nVui lòng chọn tài khoản khác.");

            } else {

                dialog_chung(1 , context , "Đăng Kí Thất Bại");
            }

        } catch (Exception ex) {
            Log.e("Error Đăng Kí  : \t\t", ex.toString());
        }

    }

    private void dialog_chung(Integer so, Context context, String tb) {
        switch (so) {
            case 0:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông Báo").setMessage(tb);
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case 1:
                Toast.makeText(context, tb, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void rememberUser(String tk, String mk, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        if (!status) {
            //xoa tinh trang luu tru truoc do
            edit.clear();
        } else {
            //luu du lieu
            edit.putString("USERNAME", tk);
            edit.putString("PASSWORD", mk);
            edit.putBoolean("REMEMBER", status);
//            Toast.makeText(getApplicationContext(), "Đã nhớ tài khoản",
//                    Toast.LENGTH_SHORT).show();

        }
    }
}