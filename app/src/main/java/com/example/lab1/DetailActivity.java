package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.util.Log;

import java.text.NumberFormat;
import java.util.ArrayList;

/*public class DetailActivity extends AppCompatActivity {
    private TextView mDetailMessage;
    private Button mShowVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        mDetailMessage = findViewById(R.id.tvdetailMessage);
        mDetailMessage.setText(message);

        mShowVideoButton = findViewById(R.id.btnShowVideo);
        mShowVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideo("https:www.youtube.com/watch?v=-iIbc-h9ijc");
            }

        });

    }

    private void showVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}*/

public class DetailActivity extends AppCompatActivity {
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView mSearch;

    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mName = findViewById(R.id.coinName);
        //mSymbol = findViewById(R.id.Symbol);
        mValue = findViewById(R.id.ValueOutput);
        mChange1h = findViewById(R.id.Change1hOutput);
        mChange24h = findViewById(R.id.Change24hOutput);
        mChange7d = findViewById(R.id.Change7dOutput);
        mMarketcap = findViewById(R.id.MarketcapOutput);
        mVolume = findViewById(R.id.VolumeOutput);
        mSearch = findViewById(R.id.searchBtn);

        Intent intent = getIntent();
        String coinSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Log.i(TAG, "Coin-Symbol = " + coinSymbol);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Coin> coins = Coin.getCoins();

        final Coin coin = Coin.searchCoin(coinSymbol);

        //final Coin coin = Coin.getCoins().get(0);

        mName.setText(coin.getName());
        //mSymbol.setText(coin.getSymbol());
        mValue.setText(formatter.format(coin.getValue()));
        mChange1h.setText((coin.getChange1h()) + "%");
        mChange24h.setText((coin.getChange24h()) + "%");
        mChange7d.setText((coin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(coin.getMarketcap()));
        mVolume.setText(formatter.format(coin.getVolume()));
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchCoin(coin.getName());
            }
        });

    }

        private void searchCoin(String name) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name));
            startActivity(intent);
        }

    }











