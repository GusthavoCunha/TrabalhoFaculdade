package cunha.gusthavo.appgames;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "AppGames";

    public Banco( Context context ){
        super(context, NOME , null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS jogos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL," +
                " ano INTEGER," +
                " criador TEXT NOT NULL) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        if ( oldVersion == 2 && newVersion 3){
//            db.execSQL(" ALTER TABLE filme ADD COLUMN diretor TEXT");
//        }

//        if ( oldVersion == 1 && newVersion 3){
//            db.execSQL(" ALTER TABLE filme ADD COLUMN diretor TEXT");
//            db.execSQL(" ALTER TABLE filme ADD COLUMN premios TEXT");
//        }
    }




}
