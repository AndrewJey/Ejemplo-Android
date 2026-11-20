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
        Bundle bundle = getIntent() != null ? getIntent().getExtras() : null;
        String texto = bundle != null ? bundle.getString("texto") : null;
        if (texto == null || texto.trim().isEmpty()) {
            text.setText("No escribiste nada");
        } else {
            text.setText(texto.trim());
        }
    }
}
