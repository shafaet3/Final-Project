package com.example.project.gms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonAddBin, buttonViewBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddBin = findViewById(R.id.id_btn_add_bin);
        buttonViewBin = findViewById(R.id.id_btn_view_bin);
        buttonAddBin.setOnClickListener(this);
        buttonViewBin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_add_bin:
                Intent intentAddBin = new Intent(MainActivity.this, AddBinActivity.class);
                startActivity(intentAddBin);
                break;
            case R.id.id_btn_view_bin:
                Intent intentGarbageLevel = new Intent(MainActivity.this, ViewBinActivity.class);
                startActivity(intentGarbageLevel);
                break;
            default:
                break;
        }
    }
}
