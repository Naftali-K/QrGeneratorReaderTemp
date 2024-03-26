package com.nk.qrgeneratorreadertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.qr_generator_1_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrGenerator1Activity.class));
            }
        });

        findViewById(R.id.qr_generator_2_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrGenerator2Activity.class));
            }
        });

        findViewById(R.id.qr_generator_3_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrGenerator3Activity.class));
            }
        });

        findViewById(R.id.qr_generator_4_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrGenerator4Activity.class));
            }
        });



        findViewById(R.id.qr_scanner_1_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrScanner1Activity.class));
            }
        });

        findViewById(R.id.qr_scanner_2_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), QrScanner2Activity.class));
            }
        });
    }
}