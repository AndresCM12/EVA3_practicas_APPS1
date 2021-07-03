package com.example.ev3_20_servicio_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwUno;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MyService.class);
        txtVwUno = findViewById(R.id.txtVwUno);
        txtVwUno.setText(""+ R.raw.song);
    }

    public void iniciar(View v){
        startService(intent);
    }

    public void detener(View v){
        stopService(intent);
    }
}