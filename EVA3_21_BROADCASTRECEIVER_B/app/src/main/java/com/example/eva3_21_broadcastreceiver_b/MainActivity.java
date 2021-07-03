package com.example.eva3_21_broadcastreceiver_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Filter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwUno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwUno = findViewById(R.id.txtVwUno);
        BroadcastReceiver broadcastReceiver = new MiBroadCast();
        IntentFilter intentFilter = new IntentFilter("mensaje");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    class MiBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwUno.append("\n");
            txtVwUno.append(intent.getStringExtra("mensaje"));
        }
    }
}