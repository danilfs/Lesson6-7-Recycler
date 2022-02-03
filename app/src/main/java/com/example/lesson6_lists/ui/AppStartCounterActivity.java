package com.example.lesson6_lists.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.api.Context;

public class AppStartCounterActivity extends AppCompatActivity {

    private static final String COUNTER_EXTRA_KEY = "COUNTER_EXTRA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start_counter);
        int counter = getIntent().getIntExtra(COUNTER_EXTRA_KEY, 0);
        TextView counterTextView = findViewById(R.id.counter_text_view);
        counterTextView.setText("Start counter: " + counter);
    }

    public static Intent newIntent(Context context, int counter) {
        Intent intent = new Intent(context, AppStartCounterActivity.class);
        intent.putExtra(COUNTER_EXTRA_KEY, counter);
        return intent;
    }
}
