package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //(Clase)Thread --> clase para crear hilos
        //Crear propia clase que herede de Thread
        //Crear clase anonima
        //Sobreescribir el metodo run(){}

        Thread mihilo = new Thread(){
            //aqui van las tareas en segundo plano
            @Override
            public void run() {
                super.run();

                for (int i = 0; i <10; i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("Hilo principal", "i = "+(i+1));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        };
        mihilo.start();//iniciamos el hilo de ejecucion
        MiHilote mihilote = new MiHilote();
        mihilote.start();
        mihilote.run();//llamada a funcion dentro del hilo principal

    }
}

class MiHilote extends Thread{
    @Override
    public void run() {
        super.run();

        for (int i = 0; i <10; i++){
            try {
                Thread.sleep(1000);
                Log.wtf("Hilo principal", "x = "+(i+1));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}