package com.example.cronometromaur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int segundos=0;
    private boolean ejecucion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicioTiempo();
    }

    public void start (View view){
        ejecucion = true;
    }

    public void stop (View view){
        ejecucion=false;
    }

    public void reset (View view){
        ejecucion=false;
        segundos=0;
    }

    private void inicioTiempo (){
        TextView txt_Tiempo= findViewById(R.id.txt_Tiempo);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = segundos/3600;
                int min =(segundos%3600)/60;
                int seg = segundos%60;
                String tiempo = String.format("%02d:%02d:%02d",hrs, min, seg);
                txt_Tiempo.setText(tiempo);
                if (ejecucion){
                    segundos++;
                }
                handler.postDelayed(this, 0);
            }
        });
    }
}