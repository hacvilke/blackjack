package com.hacvilke.blackjack;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View;

public class MainActivity extends Activity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        ws.setTextZoom(100);
        web.setOverScrollMode(View.OVER_SCROLL_NEVER);
        setContentView(web);
        web.loadUrl("file:///android_asset/www/index.html");
    }
    @Override
    protected void onPause() { super.onPause(); if (web != null) web.onPause(); }
    @Override
    protected void onResume() { super.onResume(); if (web != null) web.onResume(); }
    @Override
    public void onBackPressed() { /* table stays open: finish quietly */ finishAffinity(); }
}
