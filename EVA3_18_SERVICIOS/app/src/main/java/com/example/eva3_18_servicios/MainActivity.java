package com.example.eva3_18_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MyService.class);

    }


    public void iniciarServicio(View v){
        startService(intent);
    }

    public void detenerServicio(View v){
        stopService(intent);

    }
}

