package com.example.eva3_2_runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <10; i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("Runnable principal", "i = "+(i+1));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread thread = new Thread(miRunnable);
        thread.start();

        MiClaseRun miClaseRun = new MiClaseRun();
        Thread threaduno = new Thread(miClaseRun);
        threaduno.run();
    }
}

class MiClaseRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10; i++){
            try {
                Thread.sleep(1000);
                Log.wtf("Runnable principal", "x = "+(i+1));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}