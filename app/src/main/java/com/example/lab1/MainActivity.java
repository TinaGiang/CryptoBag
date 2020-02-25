package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String EXTRA_MESSAGE = "au.edu.unsw.infs3624.beers.MESSAGE";
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i(TAG, msg: "onCreate Called");
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btnLaunchActivity);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity("Hello from DetailActivity *******************");
                }
            });
    }

    private void launchDetailActivity(String message){
        Intent intent = new Intent( this, DetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//        Log.i(TAG, msg: "onStart Called");
//    }
//
//    @Overrride
//    protected void onResume(){
//        super.onResume();
//        Log.i(TAG, msg: "onResume Called");
//    }


}

