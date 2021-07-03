package com.example.eva3_7_handler_banner;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwUno;
    Thread tBanner;
    int flag =1;
    //a trav[es de un handler interactuar con la interf[az gr[afica
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //interactuamos con la ui
            switch (flag){
                case(1):
                     imgVwUno.setImageResource(R.drawable.uno);
                    break;
                case(2):
                    imgVwUno.setImageResource(R.drawable.dos);
                    break;
                case (3):
                    imgVwUno.setImageResource(R.drawable.tres);
                    break;
            }
            if(flag ==3){
                flag=1;
            }else{
                flag++;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwUno = findViewById(R.id.imgVwUno);


        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //solicitar el mensaje
                        Message message = handler.obtainMessage();
                        //enviar un mensaje
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}