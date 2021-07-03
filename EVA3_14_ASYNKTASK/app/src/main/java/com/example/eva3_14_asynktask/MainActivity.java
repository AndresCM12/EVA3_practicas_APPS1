package com.example.eva3_14_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwM = findViewById(R.id.txtVwM);
        VerySlowTask mica = new VerySlowTask();
        mica.execute(10,500);


    }
    class VerySlowTask extends AsyncTask<Integer, String, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwM.append("Se esta actualizando \n");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtVwM.append("Fin de la ejecución");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtVwM.append(""+values[0]+"\n");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int limite = integers[0];
            for( int i = 0; i<limite; i++){
                try {
                    Thread.sleep(1000);
                    publishProgress("i = "+ i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
}


}