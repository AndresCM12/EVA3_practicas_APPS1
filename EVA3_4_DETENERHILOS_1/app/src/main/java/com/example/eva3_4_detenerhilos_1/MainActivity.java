package com.example.eva3_4_detenerhilos_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread infinito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infinito = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true){
                    Log.wtf("Hilo infinito", "i = "+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Log.wtf("Hilo infinito", "///////////// Se detuvo /////////////");
                        break;
                    }
                    i++;
                }
            }
        };
        infinito.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        infinito.interrupt();
    }
}