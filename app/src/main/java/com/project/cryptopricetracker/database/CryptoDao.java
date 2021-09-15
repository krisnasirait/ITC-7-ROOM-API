package com.project.cryptopricetracker.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface CryptoDao {
    @Query("Select * from " + CryptoEntity.TABLE_NAME)
    List<CryptoEntity> getAllData();
    @Insert
    void insert(CryptoEntity cryptoEntity);
    @Update
    void update(CryptoEntity cryptoEntity);
    @Delete
    void delete(CryptoEntity cryptoEntity);
}
