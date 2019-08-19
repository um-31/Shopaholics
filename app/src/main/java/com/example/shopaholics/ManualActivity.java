package com.example.shopaholics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class ManualActivity extends AppCompatActivity {
        WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        webView = (WebView) findViewById(R.id.webManual);
        webView.loadUrl("file:///android_asset/Manual.html");
    }
}
