package com.example.homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCounts;
    private Button btnPlus;
    private int counts = 0;
    final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        textCounts = findViewById(R.id.counts);
        btnPlus = findViewById(R.id.Button);

        btnPlus.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counts++;
            textCounts.setText("" + counts);
        }
    };

    @Override
    protected void onStart() {
        Toast toast = Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT);
        toast.show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, "Стоп активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, "Пауза активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, "Возобновление активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY, counts);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        counts = savedInstanceState.getInt(KEY);
        textCounts.setText("" + counts);
        super.onRestoreInstanceState(savedInstanceState);
    }
}