package fr.utt.if26.lingvist;

import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

/**
 * Created by wxw on 2018/1/13.
 */

public class SQLiteDataBaseSerializable implements Serializable {
    private SQLiteDatabase db;
    public SQLiteDataBaseSerializable(AssetsDatabaseManager mg, String name){
        this.db = mg.getDatabase(name);
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
}
