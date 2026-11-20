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
    public void ObtenerTelefonos() {
        CrearBaseDatos telefonos = null;
        SQLiteDatabase bd = null;
        Cursor cursor = null;
        try {
            telefonos = new CrearBaseDatos(this, "telefonos", null, 1);
            bd = telefonos.getReadableDatabase();
            cursor = bd.rawQuery("SELECT id, telefono, version FROM telefono ORDER BY id DESC", null);
            ArrayList<String> registros = new ArrayList<String>();
            if (cursor.moveToFirst()) {
                do {
                    registros.add("ID:" + cursor.getInt(0)
                            + " - Teléfono:" + cursor.getString(1)
                            + " - Versión:" + cursor.getString(2));
                } while (cursor.moveToNext());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registros);
            listregistros.setAdapter(adapter);
        } catch (Exception error) {
            Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show();
        } finally {
            if (cursor != null) cursor.close();
            if (bd != null) bd.close();
            if (telefonos != null) telefonos.close();
        }
    }

    public void crear(String telefono, String version) {
        String telTrim = telefono != null ? telefono.trim() : "";
        String verTrim = version != null ? version.trim() : "";
        if (telTrim.isEmpty() || verTrim.isEmpty()) {
            Toast.makeText(this, "Complete teléfono y versión antes de guardar.", Toast.LENGTH_SHORT).show();
            return;
        }
        CrearBaseDatos telefonos = null;
        SQLiteDatabase bd = null;
        try {
            telefonos = new CrearBaseDatos(this, "telefonos", null, 1);
            bd = telefonos.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("telefono", telTrim);
            registro.put("version", verTrim);
            long rowId = bd.insert("telefono", null, registro);
            if (rowId != -1) {
                Toast.makeText(this, "Se cargaron los datos en la tabla", Toast.LENGTH_SHORT).show();
                Limpiar();
            } else {
                Toast.makeText(this, "No se pudo insertar el registro.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception error) {
            Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show();
        } finally {
            if (bd != null) bd.close();
            if (telefonos != null) telefonos.close();
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
