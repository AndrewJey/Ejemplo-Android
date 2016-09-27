package com.example.soporte.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NuevaActividad extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);
        text = (TextView) findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();//Se obtiene el bundle recibido desde la otra actividad
        if (bundle.getString("texto").length() == 0) {
            text.setText("No escribiste nada");
        } else {
            text.setText(bundle.getString("texto"));
        }
    }
}
