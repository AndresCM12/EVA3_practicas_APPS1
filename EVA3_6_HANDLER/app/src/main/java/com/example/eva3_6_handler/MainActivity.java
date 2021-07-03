package com.example.eva3_6_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwMensaje;
    Thread thread;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //aqui debemos modificar la interfaz grafica
            //trabajo muy ligero --> una tarea intensa va a trabar la ui
            String cade = (String)msg.obj;
            int what = msg.what;
            txtVwMensaje.append("El hilo = "+what + " Imprime " + cade + "\n");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensaje = findViewById(R.id.txtVwMensaje);
        txtVwMensaje.setText("Hola :3 \n");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i = "+ i;
                        i++;
                        //solicitamos un mensaje
                        //poner info en el mensaje
                        Message message = handler.obtainMessage(100, cade);
                        //devolverlo
                        handler.sendMessage(message);

                        Log.wtf("Runnable",cade);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}