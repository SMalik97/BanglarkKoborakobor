package com.mongalkote.banglarkhoborakobor;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        View view=inflater.inflate(R.layout.fragment_news_police, null);
        // Inflate the layout for this fragment
        card1=(CardView)view.findViewById(R.id.card1);
        card1.setVisibility(View.INVISIBLE);
        newsImage1=(ImageView)view.findViewById(R.id.newsImage1);
        newsTitle1=(TextView)view.findViewById(R.id.newsTitle1);

        //start loading news.....................................
        loader = (DotsLoaderView)view.findViewById(R.id.dotload);
        loader.show();
//load first 15 news
        //first10news f10n=new first10news();
       // new Thread(f10n).start();

        Date c= Calendar.getInstance().getTime();
        SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
        d=df.format(c);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);





        return view;
    }

}
