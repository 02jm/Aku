package com.jusufakupintar.apkakupintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jusufakupintar.apkakupintar.view.MainActivity;

public class splase extends AppCompatActivity {
    private int waktu_loading=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splase);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent beranda=new Intent(splase.this, MainActivity.class);
                startActivity(beranda);
                finish();
            }
        }, waktu_loading);
    }
}
