package com.example.eva1_12_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    /*Clima[] aClimaCd = {
            new Clima(R.drawable.sunny, 28, "Chihuahua", "Despejado con viento"),
            new Clima(R.drawable.atmospher, 25, "Delicias", "Vientos huracanados"),
            new Clima(R.drawable.cloudy, 24, "Camargo", "Nublado"),
            new Clima(R.drawable.light_rain, 23, "Casas Grandes", "Poca lluvia"),
            new Clima(R.drawable.rainy, 22, "Parral", "Lluviosos"),
            new Clima(R.drawable.snow, 13, "Cuauhtemoc", "Nieve"),
            new Clima(R.drawable.thunderstorm, 30, "Guerrero", "Tormenta de rayos"),
            new Clima(R.drawable.tornado, 20, "Creel", "Despejado con viento"),

    };*/

    List<Clima> lstCiudades = new ArrayList<>();
    ListView lstVwClima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clima);
        Prueba<Integer> obj = new Prueba();
    }


    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima = findViewById(R.id.lstVwClima);
        //lstVwClima.setAdapter(new ClimaAdaptador(this, R.layout.activity_main, aClimaCd));
        ConexionClima cc = new ConexionClima();
        cc.execute("http://api.openweathermap.org/data/2.5/find?lat=28.6&lon=-106&cnt=30&units=metric&appid=97ee46f541e25b94bc301c9a6f6c8388");
    }
                                            //URL, NADA, JSON
    class ConexionClima extends AsyncTask<String, Void, String>{

        //aqui vamos a hacer la conexion
        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResu = null;

            //HttpUrlConnection
            try {
                URL url = new URL(sUrl);
                //aqui se realiza la conexion
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                //aqui verificamos si la conexion fue exitosa
                if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    //aqui es como leer un archivo de texto
                    InputStreamReader  isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;

        }

        //aqui vamos a llenar la lista con datos
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!(s.equals("") || s == null)){
                try {
                    JSONObject jsObj = new JSONObject(s);
                    //recuperamos el arreglo de ciudades
                    JSONArray jsaCiudades = jsObj.getJSONArray("list");

                    for(int i=0; i<jsaCiudades.length(); i++){
                        JSONObject jsonCiudad = jsaCiudades.getJSONObject(i);//recuperar una ciudad particular
                        //leer ciudad
                        Clima climaCiudad = new Clima();
                        climaCiudad.setCiudad(jsonCiudad.getString("name"));
                        JSONObject jsonMain = jsonCiudad.getJSONObject("main");
                        climaCiudad.setTemp(jsonMain.getDouble("temp"));
                        JSONArray jsonArrayWeather = jsonCiudad.getJSONArray("weather");
                        //tomamos el primer elemento
                        JSONObject jsonClimaActual = jsonArrayWeather.getJSONObject(0);
                        climaCiudad.setDesc(jsonClimaActual.getString("description"));

                        int id = jsonClimaActual.getInt("id");
                        if(id <300){
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        }else if(id <400){
                            climaCiudad.setImagen(R.drawable.light_rain);
                        }else if(id <600){
                            climaCiudad.setImagen(R.drawable.rainy);
                        }else if(id <700){
                            climaCiudad.setImagen(R.drawable.snow);
                        }else if(id <800) {
                            climaCiudad.setImagen(R.drawable.atmospher);
                        }else if(id <801) {
                            climaCiudad.setImagen(R.drawable.sunny);
                        }else if(id <900) {
                            climaCiudad.setImagen(R.drawable.cloudy);
                        }else{
                            climaCiudad.setImagen(R.drawable.tornado);
                        }
                        lstCiudades.add(climaCiudad);
                    }
                    lstVwClima.setAdapter(new ClimaAdaptador(MainActivity.this, R.layout.activity_main,
                            lstCiudades));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.wtf("CONEXION",s);
        }


    }
}

class Prueba<T>{
    private T algo;

    public T getAlgo() {
        return algo;
    }

    public void setAlgo(T algo) {
        this.algo = algo;
    }
}