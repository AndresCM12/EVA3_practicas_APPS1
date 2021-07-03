package com.example.eva3_10_banner_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImagen;
    SeekBar skVelocidad;
    TextView txtVwVel;
    int imagen = 0, velocidad = 2000;
    Handler handler = new Handler();
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(velocidad);
                    handler.post(foreground);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };
    //TRABAJO CON UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            switch(imagen){
                case 0:
                    imgVwImagen.setImageResource(R.drawable.f1);
                    imagen++;
                    break;
                case 1:
                    imgVwImagen.setImageResource(R.drawable.f2);
                    imagen++;
                case 2:
                    imgVwImagen.setImageResource(R.drawable.f3);
                    imagen = 0;
                    break;

            }
        }
    };
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skVelocidad = findViewById(R.id.skVelocidad);
        txtVwVel = findViewById(R.id.txtVwVelocidad);
        imgVwImagen = findViewById(R.id.imgVwImagen);
        thread = new Thread(background);
        thread.start();

        skVelocidad.setMax(1850);
        skVelocidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                velocidad = 2000-progress;
                txtVwVel.setText("La velocidad es de: "+velocidad+ " ms");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
