package com.example.shopaholics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView finalorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        SharedPreferences sp = getSharedPreferences("com.example.arshdeep.store", Context.MODE_PRIVATE);

        finalorder = findViewById(R.id.finalorder);
        finalorder.setText("YOUR ORDER WILL BE DELIVERED TO : "+sp.getString("ADDRESS","Data Missing"));

    }
    public void onExit(View view) {
        finish();
    }
}
