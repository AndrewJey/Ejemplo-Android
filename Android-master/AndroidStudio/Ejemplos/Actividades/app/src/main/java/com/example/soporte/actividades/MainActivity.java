package com.example.soporte.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button boton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        setEvents();
    }

    public void setEvents() {
        final Intent intent = new Intent(this, NuevaActividad.class);//Se crea una instancia de la actividad a mostrar
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();//Se utiliza para enviar datos entre actividades
                bundle.putString("texto", editText.getText().toString());//Se ingresa el dato que se va enviar a la otra acitvidad
                intent.putExtras(bundle); //Se le asigna el objeto bundle a la nueva actividad
                startActivity(intent);//Se empieza la actividad
            }
        });
    }
}
