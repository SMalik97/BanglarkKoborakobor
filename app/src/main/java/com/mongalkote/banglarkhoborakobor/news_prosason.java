package com.mongalkote.banglarkhoborakobor;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import steelkiwi.com.library.DotsLoaderView;


/**
 * A simple {@link Fragment} subclass.
 */
public class news_prosason extends Fragment {
    List<Object> list;
    Gson gson;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    Map<String, Object> mapSubtitle;
    String[] postTitle;
    String[] postSubtitle;
    String mapImage;
    String postImage[]=new String[20];
    int postId[]=new int[20];
    String url1="https://www.mongalkote.com/wp-json/wp/v2/posts?categories=65&per_page=15";
    int trying=0;
    CardView card1;
    ImageView newsImage1;
    TextView newsTitle1;
    DotsLoaderView loader;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String d;

    public news_prosason() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_prosason, container, false);
    }

}
