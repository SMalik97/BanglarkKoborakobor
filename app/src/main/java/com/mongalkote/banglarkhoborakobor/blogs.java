package com.mongalkote.banglarkhoborakobor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebView;

public class blogs extends AppCompatActivity {
    WebView web;
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);

        web=(WebView)findViewById(R.id.web);
        refresh=(SwipeRefreshLayout)findViewById(R.id.refresh);


    }
}
