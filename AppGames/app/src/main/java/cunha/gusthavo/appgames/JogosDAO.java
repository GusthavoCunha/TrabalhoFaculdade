package cunha.gusthavo.appgames;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class JogosDAO {

    public static void inserir(Jogos jogos, Context context){
        ContentValues valores = new ContentValues();
        valores.put("nome", jogos.getNome());
        valores.put("ano", jogos.getAno());
        valores.put("criador", jogos.getCriador());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("jogos", null , valores);
    }

    public static void editar(Jogos jogos, Context context){
        ContentValues valores = new ContentValues();
        valores.put("nome", jogos.getNome());
        valores.put("ano", jogos.getAno());
        valores.put("criador", jogos.getCriador());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("jogos", valores, " id  = " + jogos.id, null);

    }

    public static void excluir(int id, Context context){

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete( "jogos", "id = " + id , null);

    }

    public static List<Jogos> getJogos(Context context){

        List<Jogos> lista = new ArrayList<>();

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        banco.onCreate( db );
        Cursor cursor = db.rawQuery( " SELECT * FROM jogos ORDER BY nome ", null );

        if ( cursor.getCount() > 0 ) {

            cursor.moveToFirst();

            do{
                Jogos jogos = new Jogos();
                jogos.id = cursor.getInt(0);
                jogos.setNome(cursor.getString(1));
                jogos.setAno( cursor.getInt(2) );
                jogos.setCriador( cursor.getString(3));

                lista.add( jogos );

            }while( cursor.moveToNext() );

        }

        return lista;
    }

    public static Jogos getJogosById(Context context, int id) {

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(" SELECT * FROM jogos WHERE id = " + id, null);

        if (cursor.getCount() > 0 ) {

            cursor.moveToFirst();

            Jogos jogos = new Jogos();
            jogos.id = cursor.getInt(0);
            jogos.setNome(cursor.getString(1));
            jogos.setAno(cursor.getInt(2));
            jogos.setCriador( cursor.getString(3));

            return jogos;
        } else {
            return null;
        }
    }
}

