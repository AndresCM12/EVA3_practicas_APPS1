package com.example.eva3_1_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linux -- > proceso --> tiene un hilo de ejecucion principal
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
                Log.wtf("Hilo principal", "i = "+ (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}