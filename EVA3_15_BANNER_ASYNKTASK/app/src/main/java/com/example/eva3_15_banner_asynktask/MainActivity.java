package com.example.eva3_15_banner_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgVwImagen;
    int imagen = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwImagen = findViewById(R.id.imgVwBanner);
        MiClaseAsincrona miCa = new MiClaseAsincrona();
        miCa.execute(10,500);
        //15 --> BANNER_ASYNKTASK
        //16 --> LOAD_IMAGE_ASYNKSTASK
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,Void>{
        @Override
        protected void onPreExecute() { //Si pueden interactuar con la UI

            super.onPreExecute();

        }
        @Override //no se puede interactuar con la ui
        protected Void doInBackground(Integer... integers) { //equivalente a un run() en un Thread
            while(true){
                try {
                    Thread.sleep(1000);
                    publishProgress(""+imagen);
                    if(imagen == 2){
                        imagen = 0;
                    }else{
                        imagen++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            switch(imagen){
                case 0:
                    imgVwImagen.setImageResource(R.drawable.f1);
                    break;
                case 1:
                    imgVwImagen.setImageResource(R.drawable.f2);
                    break;
                case 2:
                    imgVwImagen.setImageResource(R.drawable.f3);
                    break;

            }


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }


    }
}