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

}
