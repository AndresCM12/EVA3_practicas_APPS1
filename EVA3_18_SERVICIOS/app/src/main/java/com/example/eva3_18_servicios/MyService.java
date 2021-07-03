package com.example.eva3_18_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread miHilo;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("servicio", "OnCreate");
        miHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("servicio", "trabajo en segundo plano");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.wtf("servicio", "termina trabajo en segundo plano");
                        break;
                    }
                }

            }
        };
        miHilo.start();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("servicio", "OnStart");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("servicio", "OnDestroy");
        miHilo.interrupt();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}