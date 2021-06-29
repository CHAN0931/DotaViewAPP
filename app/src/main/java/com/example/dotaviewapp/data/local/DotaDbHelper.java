package com.example.dotaviewapp.data.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DotaDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "opendotalocal.db";
    private static final int DATABASE_VERSION = 1;

    public DotaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DotaContract.DotaSubscriber.TABLE_NAME + "("
                + DotaContract.DotaSubscriber._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DotaContract.DotaSubscriber.COLUMN_AVATAR_URL + " TEXT NOT NULL, "
                + DotaContract.DotaSubscriber.COLUMN_PLAYER_NAME + " TEXT NOT NULL, "
                + DotaContract.DotaSubscriber.COLUMN_ACC_ID + " INTEGER NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DotaContract.DotaSubscriber.TABLE_NAME + ";");
    }
}
