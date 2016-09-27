package com.example.usuario_stn_01.sqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Sqllite.CrearBaseDatos;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTelefono;
    EditText editVerison;
    Button button;
    ListView listregistros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTelefono = (EditText)findViewById(R.id.editText);
        editVerison =(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        listregistros=(ListView)findViewById(R.id.listView);
        ObtenerTelefonos();
    }
    public void ObtenerTelefonos(){
        try{
            CrearBaseDatos telefonos = new CrearBaseDatos(this, "telefonos", null, 1);
            SQLiteDatabase bd = telefonos.getWritableDatabase();
            String query="Select * from telefono";
            Cursor cursor = bd.rawQuery(query,null);
            // looping through all rows and adding to list
            ArrayList<String> registros=new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    registros.add("ID:"+Integer.parseInt(cursor.getString(0))+
                                    "- Telefono:"+cursor.getString(1)+
                                    "- Version:"+cursor.getString(2));
                } while (cursor.moveToNext());
            }
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,registros);
            listregistros.setAdapter(adapter);
        }catch (Exception error){
            Toast.makeText(this, error.toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void crear(String telefono,String version) {
        try {
            CrearBaseDatos telefonos = new CrearBaseDatos(this, "telefonos", null, 1);
            SQLiteDatabase bd = telefonos.getWritableDatabase();
            ContentValues registro = new ContentValues();  //es una clase para guardar datos
            registro.put("telefono", telefono);
            registro.put("version", version);
            bd.insert("telefono", null, registro);
            bd.close();
            Toast.makeText(this, "Se cargaron los datos en la tabla",
                    Toast.LENGTH_SHORT).show();
            Limpiar();
        }catch (Exception error){
            Toast.makeText(this, error.toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                crear(editTelefono.getText().toString(),editVerison.getText().toString());
                ObtenerTelefonos();
        }
    }

    public void Limpiar(){
        editTelefono.setText("");
        editVerison.setText("");
    }
}
