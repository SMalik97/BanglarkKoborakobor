package com.mongalkote.banglarkhoborakobor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class blogs extends AppCompatActivity {
    WebView mWebView;
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);

        getSupportActionBar().hide();

        mWebView=(WebView)findViewById(R.id.web);
        refresh=(SwipeRefreshLayout)findViewById(R.id.refresh);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://atnmedicare.com/atnkunmadmunmedicare/");


    }
}
