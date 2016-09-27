package Sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USUARIO-STN-01 on 23/11/2015.
 */
public class CrearBaseDatos extends SQLiteOpenHelper {
    public CrearBaseDatos(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    //creamos la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table telefono(id  INTEGER PRIMARY KEY AUTOINCREMENT, telefono text, version text)");
    }

    //borrar la tabla y crear la nueva tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {

    }
}
