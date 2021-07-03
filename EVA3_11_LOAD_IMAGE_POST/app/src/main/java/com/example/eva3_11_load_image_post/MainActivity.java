package com.example.eva3_11_load_image_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmap;
    ImageView imgVw;
    Handler handler = new Handler();
    Runnable background = new Runnable() {
        @Override
        public void run() {
                bitmap = descargarImagen("https://i.pinimg.com/originals/8d/a8/ae/8da8aea3377f74b824935440acf0545c.jpg");
                handler.post(foreground);
            }
    };
    //TRABAJO CON UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {

            imgVw.setImageBitmap(bitmap);
        }
    };
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        thread = new Thread(background);
        thread.start();

    }
    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}