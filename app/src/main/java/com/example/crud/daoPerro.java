package com.example.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoPerro {
    SQLiteDatabase bd;
    ArrayList<Perro> Lista = new ArrayList<Perro>();

    Perro c;
    Context ct;
    String nombreBD;
    String tabla = "create table if not exists perro(id integer primary key autoincrement, nombre text, dueno text)";

    public daoPerro(Context c){
        this.ct = c;
        bd = c.openOrCreateDatabase(nombreBD,Context.MODE_PRIVATE,null);
        bd.execSQL(tabla);
    }

    public boolean insertar(Perro c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",c.getNombre());
        contenedor.put("dueno",c.getDueño());
        return(bd.insert("perro",null,contenedor))>0;
    }
    public boolean eliminar(int id){
        return (bd.delete("perro","id="+id,null))>0;
    }
    public boolean editar(Perro c){
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",c.getNombre());
        contenedor.put("dueno",c.getDueño());
        return (bd.update("perro",contenedor,"id="+c.getId(),null))>0;
    }
    public ArrayList<Perro>verTodo(){
        Lista.clear();
        Cursor cursor = bd.rawQuery("select * from perro",null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Lista.add(new Perro(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return Lista;
    }

    public Perro verUno(int posicion){
        Cursor cursor = bd.rawQuery("select * from perro",null);
        cursor.moveToPosition(posicion);
        c = new Perro(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2));
        return c;
    }
}
