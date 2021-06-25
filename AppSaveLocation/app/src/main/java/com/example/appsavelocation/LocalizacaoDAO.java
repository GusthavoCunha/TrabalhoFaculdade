package com.example.appsavelocation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LocalizacaoDAO {


    public static void inserir(Localizacao localizacao, Context context) {
        ContentValues valores = new ContentValues();
        valores.put("nome", localizacao.getNome());
        valores.put("latitude", localizacao.getLatitude());
        valores.put("longitude", localizacao.getLongitude());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("localizacao", null, valores);
    }

    public static void editar(Localizacao localizacao, Context context) {
        ContentValues valores = new ContentValues();
        valores.put("nome", localizacao.getNome());
        valores.put("latitude", localizacao.getLatitude());
        valores.put("longitude", localizacao.getLongitude());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("localizacao", valores, " id  = " + localizacao.getId(), null);

    }

    public static void excluir(int id, Context context) {

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("localizacao", "id = " + id, null);

    }


    public static List<Localizacao> getLocalizacao(Context context){

        List<Localizacao> lista = new ArrayList<>();

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery( " SELECT * FROM filme ORDER BY nome ", null );


        if ( cursor.getCount() > 0 ) {

            cursor.moveToFirst();

            do{
                Localizacao localizacao = new Localizacao();
                localizacao.setId(cursor.getInt(0));
                localizacao.setNome(cursor.getString(1));
                localizacao.setLongitude( cursor.getDouble(2) );
                localizacao.setLatitude( cursor.getDouble(3) );

                lista.add( localizacao );

            }while( cursor.moveToNext() );

        }

        return lista;
    }


    public static Localizacao getLocalizacaoById(Context context, int id) {

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM filme WHERE id = " + id, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            Localizacao localizacao = new Localizacao();
            localizacao.setId(cursor.getInt(0));
            localizacao.setNome(cursor.getString(1));
            localizacao.setLongitude( cursor.getDouble(2) );
            localizacao.setLatitude( cursor.getDouble(3) );

            return localizacao;
        } else {
            return null;
        }
    }





}
