package com.project.cryptopricetracker;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.project.cryptopricetracker.database.CryptoDao;
import com.project.cryptopricetracker.database.CryptoDatabase;
import com.project.cryptopricetracker.database.CryptoEntity;
import com.project.cryptopricetracker.model.CryptingResponse;
import com.project.cryptopricetracker.model.MarketsItem;
import com.project.cryptopricetracker.service.CryptingListener;
import com.project.cryptopricetracker.service.CryptingService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static CryptoDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = CryptoDatabase.getInstance(this);
        new CryptingService().getMarkets(MarketsListener);

        RecyclerView recyclerView = findViewById(R.id.rv_dataItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CryptoAdapter(new ArrayList<>(database.cryptoDao().getAllData())));

    }

    CryptingListener<List<MarketsItem>> MarketsListener = new CryptingListener<List<MarketsItem>>() {
        @Override
        public void onSuccess(List<MarketsItem> items) {

            CryptoDatabase cryptoDatabase = CryptoDatabase.getInstance(getApplication());
            CryptoDao cryptoDao = cryptoDatabase.cryptoDao();
            for(int i = 0; i < items.size(); i++){
                CryptoEntity entity = new CryptoEntity(
                        items.get(i).getSymbol(),
                        String.valueOf(items.get(i).getPrice())
                );
                if(entity != null){
                    cryptoDao.insert(entity);
                }
            }

        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };

}