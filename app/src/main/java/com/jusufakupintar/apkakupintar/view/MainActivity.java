package com.jusufakupintar.apkakupintar.view;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.jusufakupintar.apkakupintar.Adapter.UniversitasAdapter;
import com.jusufakupintar.apkakupintar.Database;
import com.jusufakupintar.apkakupintar.Model.UniversitasModel;
import com.jusufakupintar.apkakupintar.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvList;

    private Database db;
    private UniversitasAdapter adapter;
    private List<UniversitasModel> univer = new ArrayList<>();
    SliderView sliderMyuniv;
    TextView greetText;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Database(this);
        rvList = findViewById(R.id.rv_univ);

        adapter = new UniversitasAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUnivtast();
    }

    private void getUnivtast() {
        univer = db.getUniv();
        adapter.setUniver(univer);
    }
}