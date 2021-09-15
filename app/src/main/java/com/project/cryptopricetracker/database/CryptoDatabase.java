package com.project.cryptopricetracker.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = CryptoEntity.class, exportSchema = false, version = 1)

public abstract class CryptoDatabase extends RoomDatabase {
    private static CryptoDatabase instance;

    public static synchronized CryptoDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), CryptoDatabase.class, "crypto.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract CryptoDao cryptoDao();
}
