
package com.example.seminar1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DAM_LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart - exemplu nivel error");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "onResume - exemplu nivel warning");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause - exemplu nivel debug");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop - exemplu nivel info");
    }
}
