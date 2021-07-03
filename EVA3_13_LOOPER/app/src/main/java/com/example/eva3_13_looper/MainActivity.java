package com.example.eva3_13_looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwUno;
    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            txtVwUno.append("\n" + (String)msg.obj);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwUno = findViewById(R.id.txtVwUno);
        Background background = new Background();
        background.ejectuarTarea(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++){
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage(100,"i = "+i);
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = handler.obtainMessage(100,"Fin del hilo a");
                handler.sendMessage(message);

            }
        }).ejectuarTarea(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = handler.obtainMessage(100,"Fin del hilo b");
                handler.sendMessage(message);
            }
        });
    }
}

class Background extends HandlerThread{
    Handler handler;
    public Background() {
        super("Background");
        start();

        handler = new Handler(getLooper());


    }

    public Background ejectuarTarea(Runnable tarea){
        handler.post(tarea);
        return this;
    }
}