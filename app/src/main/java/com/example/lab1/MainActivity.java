package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3624.beers.MESSAGE";
    private Button mButton;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate Called");
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.cryptoList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        CoinAdapter.RecyclerViewClickListener listener = new
                CoinAdapter.RecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        launchDetailActivity(position);
                    }
                };

        mAdapter = new CoinAdapter(Coin.getCoins(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void launchDetailActivity(int position){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);

        /*mButton = findViewById(R.id.btnLaunchActivity);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launchDetailActivity("ETH");
            }
        });*/

        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity("ETH");
            }
        });*/

        /*mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity("Hello from DetailActivity *******************");
                }
            });*/
    }

    private void launchDetailActivity(String message){
        Intent intent = new Intent( this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy Called");
    }


}

