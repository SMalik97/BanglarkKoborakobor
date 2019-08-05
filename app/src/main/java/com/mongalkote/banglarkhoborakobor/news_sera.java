package com.mongalkote.banglarkhoborakobor;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import steelkiwi.com.library.DotsLoaderView;


public class news_sera extends Fragment {
ScrollView scroller;
LinearLayout loading_news_sera,loading_news_police,loading_news_prosason,loading_news_rajnity,loading_news_loksova,loading_news_onno;
    List<Object> list;
    Gson gson;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    Map<String, Object> mapSubtitle;
    String[] postTitle;
    String[] postSubtitle;
    String postDate[]=new String[20];
    String mapImage;
    String postImage[]=new String[20];
    Button sb1;
    RecyclerView sr1;
    ProgressBar sp1;

    //String[] postId;
    int postId[]=new int[20];
    private TextView newsTitle1,newsTitle2,newsTitle3,newsTitle4,newsTitle5,newsTitle6,newsTitle7,newsTitle8,newsTitle9,newsTitle10,newsTitle11,newsTitle12,newsTitle13,newsTitle14,newsTitle15,newsTitle16,newsTitle17,newsTitle18,newsTitle19,newsTitle20;
    private TextView newsSubtitle2,newsSubtitle3,newsSubtitle4,newsSubtitle6,newsSubtitle7,newsSubtitle8,newsSubtitle10,newsSubtitle11,newsSubtitle12,newsSubtitle14,newsSubtitle15,newsSubtitle16,newsSubtitle18,newsSubtitle19,newsSubtitle20;
    private ImageView newsImage1,newsImage2,newsImage3,newsImage4,newsImage5,newsImage6,newsImage7,newsImage8,newsImage9,newsImage10,newsImage11,newsImage12,newsImage13,newsImage14,newsImage15,newsImage16,newsImage17,newsImage18,newsImage19,newsImage20;
    String url1 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=66&per_page=4";
    String url2 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=64&per_page=4";
    String url3 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=65&per_page=4";
    String url4 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=63&per_page=4";
    String url5 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=69&per_page=4";
    String url6 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=67&per_page=5";
    AVLoadingIndicatorView loader;
    TextView prosason;
    int trying=0,trying2=0,trying3=0,trying4=0;
    String d;
    TextView date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,date13,date19,date20,onnodate1,onnodate2,onnodate3,onnodate4,onnodate5;
    LinearLayout anno1,anno2,anno3,anno4,anno5;
    TextView onnotitle1,onnotitle2,onnotitle3,onnotitle4,onnotitle5;
    ImageView onnoimg1,onnoimg2,onnoimg3,onnoimg4,onnoimg5;
    public news_sera() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news_sera, null);
        sb1=(Button)view.findViewById(R.id.sb1);
        sp1=(ProgressBar)view.findViewById(R.id.sp1);
        sr1=(RecyclerView)view.findViewById(R.id.sr1);
        sp1.setVisibility(View.INVISIBLE);
        sb1.setVisibility(View.INVISIBLE);

        scroller=(ScrollView)view.findViewById(R.id.scroller);
        loading_news_sera=(LinearLayout)view.findViewById(R.id.loading_news_sera);
        loading_news_sera.setVisibility(View.INVISIBLE);

        loading_news_police=(LinearLayout)view.findViewById(R.id.loading_news_police);
        loading_news_police.setVisibility(View.INVISIBLE);

        loading_news_prosason=(LinearLayout)view.findViewById(R.id.loading_news_prosason);
        loading_news_prosason.setVisibility(View.INVISIBLE);

        loading_news_rajnity=(LinearLayout)view.findViewById(R.id.loading_news_rajnity);
        loading_news_rajnity.setVisibility(View.INVISIBLE);

        loading_news_loksova=(LinearLayout)view.findViewById(R.id.loading_news_loksova);
        loading_news_loksova.setVisibility(View.INVISIBLE);

        loading_news_onno=(LinearLayout)view.findViewById(R.id.loading_news_anno);
        loading_news_onno.setVisibility(View.INVISIBLE);

        anno1=(LinearLayout)view.findViewById(R.id.anno1);
        anno2=(LinearLayout)view.findViewById(R.id.anno2);
        anno3=(LinearLayout)view.findViewById(R.id.anno3);
        anno4=(LinearLayout)view.findViewById(R.id.anno4);
        anno5=(LinearLayout)view.findViewById(R.id.anno5);



        date1=(TextView)view.findViewById(R.id.date1);
        date2=(TextView)view.findViewById(R.id.date2);
        date3=(TextView)view.findViewById(R.id.date3);
        date4=(TextView)view.findViewById(R.id.date4);
        date5=(TextView)view.findViewById(R.id.date5);
        date6=(TextView)view.findViewById(R.id.date6);
        date7=(TextView)view.findViewById(R.id.date7);
        date8=(TextView)view.findViewById(R.id.date8);
        date9=(TextView)view.findViewById(R.id.date9);
        date10=(TextView)view.findViewById(R.id.date10);
        date11=(TextView)view.findViewById(R.id.date11);
        date12=(TextView)view.findViewById(R.id.date12);
        date13=(TextView)view.findViewById(R.id.date13);
        date19=(TextView)view.findViewById(R.id.date19);
        date20=(TextView)view.findViewById(R.id.date20);
        onnodate1=(TextView)view.findViewById(R.id.onnodate1);
        onnodate2=(TextView)view.findViewById(R.id.onnodate2);
        onnodate3=(TextView)view.findViewById(R.id.onnodate3);
        onnodate4=(TextView)view.findViewById(R.id.onnodate4);
        onnodate5=(TextView)view.findViewById(R.id.onnodate5);



        newsImage1=(ImageView)view.findViewById(R.id.newsImage1);
        newsImage2=(ImageView)view.findViewById(R.id.newsImage2);
        newsImage3=(ImageView)view.findViewById(R.id.newsImage3);
        newsImage4=(ImageView)view.findViewById(R.id.newsImage4);

        newsTitle1=(TextView)view.findViewById(R.id.newsTitle1);
        newsTitle2=(TextView)view.findViewById(R.id.newsTitle2);
        newsTitle3=(TextView)view.findViewById(R.id.newsTitle3);
        newsTitle4=(TextView)view.findViewById(R.id.newsTitle4);

        newsSubtitle2=(TextView)view.findViewById(R.id.newsSubtitle2);
        newsSubtitle3=(TextView)view.findViewById(R.id.newsSubtitle3);
        newsSubtitle4=(TextView)view.findViewById(R.id.newsSubtitle4);


        // Police ..............................................................................
        newsImage5=(ImageView)view.findViewById(R.id.newsImage5);
        newsImage6=(ImageView)view.findViewById(R.id.newsImage6);
        newsImage7=(ImageView)view.findViewById(R.id.newsImage7);
        newsImage8=(ImageView)view.findViewById(R.id.newsImage8);

        newsTitle5=(TextView)view.findViewById(R.id.newsTitle5);
        newsTitle6=(TextView)view.findViewById(R.id.newsTitle6);
        newsTitle7=(TextView)view.findViewById(R.id.newsTitle7);
        newsTitle8=(TextView)view.findViewById(R.id.newsTitle8);

        newsSubtitle6=(TextView)view.findViewById(R.id.newsSubtitle6);
        newsSubtitle7=(TextView)view.findViewById(R.id.newsSubtitle7);
        newsSubtitle8=(TextView)view.findViewById(R.id.newsSubtitle8);



        // Prosason ..............................................................................
        newsImage9=(ImageView)view.findViewById(R.id.newsImage9);
        newsImage10=(ImageView)view.findViewById(R.id.newsImage10);
        newsImage11=(ImageView)view.findViewById(R.id.newsImage11);
        newsImage12=(ImageView)view.findViewById(R.id.newsImage12);

        newsTitle9=(TextView)view.findViewById(R.id.newsTitle9);
        newsTitle10=(TextView)view.findViewById(R.id.newsTitle10);
        newsTitle11=(TextView)view.findViewById(R.id.newsTitle11);
        newsTitle12=(TextView)view.findViewById(R.id.newsTitle12);

        newsSubtitle10=(TextView)view.findViewById(R.id.newsSubtitle10);
        newsSubtitle11=(TextView)view.findViewById(R.id.newsSubtitle11);
        newsSubtitle12=(TextView)view.findViewById(R.id.newsSubtitle12);



        //rajnity ................................................................................
        newsImage13=(ImageView)view.findViewById(R.id.newsImage13);
        newsImage14=(ImageView)view.findViewById(R.id.newsImage14);
        newsImage15=(ImageView)view.findViewById(R.id.newsImage15);
        newsImage16=(ImageView)view.findViewById(R.id.newsImage16);

        newsTitle13=(TextView)view.findViewById(R.id.newsTitle13);
        newsTitle14=(TextView)view.findViewById(R.id.newsTitle14);
        newsTitle15=(TextView)view.findViewById(R.id.newsTitle15);
        newsTitle16=(TextView)view.findViewById(R.id.newsTitle16);

        newsSubtitle14=(TextView)view.findViewById(R.id.newsSubtitle14);
        newsSubtitle15=(TextView)view.findViewById(R.id.newsSubtitle15);
        newsSubtitle16=(TextView)view.findViewById(R.id.newsSubtitle16);



        //loksova................................................................................
        newsImage17=(ImageView)view.findViewById(R.id.newsImage17);
        newsImage18=(ImageView)view.findViewById(R.id.newsImage18);
        newsImage19=(ImageView)view.findViewById(R.id.newsImage19);
        newsImage20=(ImageView)view.findViewById(R.id.newsImage20);

        newsTitle17=(TextView)view.findViewById(R.id.newsTitle17);
        newsTitle18=(TextView)view.findViewById(R.id.newsTitle18);
        newsTitle19=(TextView)view.findViewById(R.id.newsTitle19);
        newsTitle20=(TextView)view.findViewById(R.id.newsTitle20);

        newsSubtitle18=(TextView)view.findViewById(R.id.newsSubtitle18);
        newsSubtitle19=(TextView)view.findViewById(R.id.newsSubtitle19);
        newsSubtitle20=(TextView)view.findViewById(R.id.newsSubtitle20);



        //onno..........................................................
        onnotitle1=(TextView)view.findViewById(R.id.onnotitle1);
        onnotitle2=(TextView)view.findViewById(R.id. onnotitle2);
        onnotitle3=(TextView)view.findViewById(R.id.onnotitle3);
        onnotitle4=(TextView)view.findViewById(R.id.onnotitle4);
        onnotitle5=(TextView)view.findViewById(R.id.onnotitle5);

        onnoimg1=(ImageView)view.findViewById(R.id.onnoimg1);
        onnoimg2=(ImageView)view.findViewById(R.id.onnoimg2);
        onnoimg3=(ImageView)view.findViewById(R.id.onnoimg3);
        onnoimg4=(ImageView)view.findViewById(R.id.onnoimg4);
        onnoimg5=(ImageView)view.findViewById(R.id.onnoimg5);


        //start loading news.....................................
        loader = (AVLoadingIndicatorView) view.findViewById(R.id.dotload);
        loader.show();

        loadNewsSera lns=new loadNewsSera();
        new Thread(lns).start();


        //Load more news button click event
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb1.setVisibility(View.INVISIBLE);
                sp1.setVisibility(View.VISIBLE);
                loadannoseraextra ll=new loadannoseraextra();
                new Thread(ll).start();


            }
        });


//.......................................................................
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scroller.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    Rect sb=new Rect();
                    scroller.getHitRect(sb);
                    prosason=(TextView)view.findViewById(R.id.prosason);
                    if (prosason.getLocalVisibleRect(sb)){
                        //Visible
                    }else {
                        //Invisible
                    }
                }
            });
        }*/
//.................................................................................

        return view;
    }






    //Load news of Sera category ..........................................................................
    class loadNewsSera implements Runnable{
        @Override
        public void run() {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url1));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url1));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered").toString();
                            mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                            postSubtitle[i] = (String) mapTitle.get("rendered").toString();
                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                            final String id1=String.valueOf(postId[0]);
                            final String id2=String.valueOf(postId[1]);
                            final String id3=String.valueOf(postId[2]);
                            final String id4=String.valueOf(postId[3]);

                            Glide.with(getContext()).load(postImage[0]).crossFade().into(newsImage1);
                            Glide.with(getContext()).load(postImage[1]).crossFade().into(newsImage2);
                            Glide.with(getContext()).load(postImage[2]).crossFade().into(newsImage3);
                            Glide.with(getContext()).load(postImage[3]).crossFade().into(newsImage4);

                            newsTitle1.setText(postTitle[0]);
                            newsTitle2.setText(postTitle[1]);
                            newsTitle3.setText(postTitle[2]);
                            newsTitle4.setText(postTitle[3]);

                            newsSubtitle2.setText(postSubtitle[1]);
                            newsSubtitle3.setText(postSubtitle[2]);
                            newsSubtitle4.setText(postSubtitle[3]);

                            date1.setText(postDate[1]);
                            date2.setText(postDate[2]);
                            date3.setText(postDate[3]);

                            loading_news_sera.setVisibility(View.VISIBLE);
                            loader.hide();

                            CardView card1=(CardView)getView().findViewById(R.id.card1);
                            card1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id1);
                                    i.putExtra("cat","sera");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card2=(CardView)getView().findViewById(R.id.card2);
                            card2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id2);
                                    i.putExtra("cat","sera");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card3=(CardView)getView().findViewById(R.id.card3);
                            card3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id3);
                                    i.putExtra("cat","sera");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card4=(CardView)getView().findViewById(R.id.card4);
                            card4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id4);
                             class loadannoNews implements Runnable{
        @Override
        public void run() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url6, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url4));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url4));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");

                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                        final String id21=String.valueOf(postId[0]);
                        final String id22=String.valueOf(postId[1]);
                        final String id23=String.valueOf(postId[2]);
                        final String id24=String.valueOf(postId[3]);
                        final String id25=String.valueOf(postId[4]);

                        Glide.with(getContext()).load(postImage[0]).crossFade().into(onnoimg1);
                        Glide.with(getContext()).load(postImage[1]).crossFade().into(onnoimg2);
                        Glide.with(getContext()).load(postImage[2]).crossFade().into(onnoimg3);
                        Glide.with(getContext()).load(postImage[3]).crossFade().into(onnoimg4);
                        Glide.with(getContext()).load(postImage[4]).crossFade().into(onnoimg5);

                        onnotitle1.setText(postTitle[0]);
                        onnotitle2.setText(postTitle[1]);
                        onnotitle3.setText(postTitle[2]);
                        onnotitle4.setText(postTitle[3]);
                        onnotitle5.setText(postTitle[4]);

                        onnodate1.setText(postDate[0]);
                        onnodate2.setText(postDate[1]);
                        onnodate3.setText(postDate[2]);
                        onnodate4.setText(postDate[3]);
                        onnodate5.setText(postDate[4]);


                        loading_news_onno.setVisibility(View.VISIBLE);

                        sb1.setVisibility(View.VISIBLE);

                        anno1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id21);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id22);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id23);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id24);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id25);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });


                    }catch (Exception e){
                        //Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                        run();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (trying4!=4){
                        Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                        run();
                        trying4=trying4+1;
                    }else {
                        Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }
        }
        }       i.putExtra("cat","sera");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });





                            loadNewsploice lnp = new loadNewsploice();
                            new Thread(lnp).start();
                        }catch (Exception e){
                           // Toast.makeText(getContext(),"Json parsing error", Toast.LENGTH_SHORT).show();
                            run();
                        }



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (trying!=4){
                            Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                            run();
                            trying=trying+1;
                        }else {
                            Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                try {
                    RequestQueue rQueue = Volley.newRequestQueue(getContext());
                    rQueue.add(stringRequest);
                }catch (Exception e){

                }


        }
    }

    //Load news of Police category ..................................................................................
    class loadNewsploice implements Runnable{
        @Override
        public void run() {

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url2));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url2));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");
                            mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                            postSubtitle[i] = (String) mapTitle.get("rendered");
                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }
                            final String id5=String.valueOf(postId[0]);
                            final String id6=String.valueOf(postId[1]);
                            final String id7=String.valueOf(postId[2]);
                            final String id8=String.valueOf(postId[3]);

                            Glide.with(getContext()).load(postImage[0]).crossFade().into(newsImage5);
                            Glide.with(getContext()).load(postImage[1]).crossFade().into(newsImage6);
                            Glide.with(getContext()).load(postImage[2]).crossFade().into(newsImage7);
                            Glide.with(getContext()).load(postImage[3]).crossFade().into(newsImage8);

                            newsTitle5.setText(postTitle[0]);
                            newsTitle6.setText(postTitle[1]);
                            newsTitle7.setText(postTitle[2]);
                            newsTitle8.setText(postTitle[3]);

                            newsSubtitle6.setText(postSubtitle[1]);
                            newsSubtitle7.setText(postSubtitle[2]);
                            newsSubtitle8.setText(postSubtitle[3]);

                            date4.setText(postDate[1]);
                            date5.setText(postDate[2]);
                            date6.setText(postDate[3]);

                            loading_news_police.setVisibility(View.VISIBLE);


                            CardView card5=(CardView)getView().findViewById(R.id.card5);
                            card5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id5);
                                    i.putExtra("cat","police");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card6=(CardView)getView().findViewById(R.id.card6);
                            card6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id6);
                                    i.putExtra("cat","police");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card7=(CardView)getView().findViewById(R.id.card7);
                            card7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id7);
                                    i.putExtra("cat","police");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card8=(CardView)getView().findViewById(R.id.card8);
                            card8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id8);
                                    i.putExtra("cat","police");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });



                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    loadNewsprosason lnp = new loadNewsprosason();
                                    new Thread(lnp).start();
                                }
                            },1000);


                        }catch (Exception e){
                            //Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                            run();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (trying2!=4){
                            Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                            run();
                            trying2=trying2+1;
                        }else {
                            Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }



        }
    }




    //Load news of Prosason category ..................................................................................
    class loadNewsprosason implements Runnable {
        @Override
        public void run() {

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url3, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url3));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url3));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");
                            mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                            postSubtitle[i] = (String) mapTitle.get("rendered");
                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                            final String id9=String.valueOf(postId[0]);
                            final String id10=String.valueOf(postId[1]);
                            final String id11=String.valueOf(postId[2]);
                            final String id12=String.valueOf(postId[3]);

                            Glide.with(getContext()).load(postImage[0]).crossFade().into(newsImage9);
                            Glide.with(getContext()).load(postImage[1]).crossFade().into(newsImage10);
                            Glide.with(getContext()).load(postImage[2]).crossFade().into(newsImage11);
                            Glide.with(getContext()).load(postImage[3]).crossFade().into(newsImage12);

                            newsTitle9.setText(postTitle[0]);
                            newsTitle10.setText(postTitle[1]);
                            newsTitle11.setText(postTitle[2]);
                            newsTitle12.setText(postTitle[3]);

                            newsSubtitle10.setText(postSubtitle[1]);
                            newsSubtitle11.setText(postSubtitle[2]);
                            newsSubtitle12.setText(postSubtitle[3]);

                            date7.setText(postDate[1]);
                            date8.setText(postDate[2]);
                            date9.setText(postDate[3]);

                            loading_news_prosason.setVisibility(View.VISIBLE);

                            CardView card9=(CardView)getView().findViewById(R.id.card9);
                            card9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id9);
                                    i.putExtra("cat","prosason");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card10=(CardView)getView().findViewById(R.id.card10);
                            card10.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id10);
                                    i.putExtra("cat","prosason");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card11=(CardView)getView().findViewById(R.id.card11);
                            card11.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id11);
                                    i.putExtra("cat","prosason");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });

                            CardView card12=(CardView)getView().findViewById(R.id.card12);
                            card12.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getContext(),Post.class);
                                    i.putExtra("id",id12);
                                    i.putExtra("cat","prosason");
                                    startActivity(i);
                                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                }
                            });



                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    loadNewsrajnity lnr = new loadNewsrajnity();
                                    new Thread(lnr).start();
                                }
                            },1000);
                        }catch (Exception e){
                           // Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                            run();
                        }




                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (trying3!=4){
                            Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                            run();
                            trying3=trying3+1;
                        }else {
                            Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }
            }

    }



        //Load news of Rajnity category ..................................................................................
        class loadNewsrajnity implements Runnable {
            @Override
            public void run() {
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url4, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                            gson = new Gson();
                            JsonReader reader = new JsonReader(new StringReader(url4));
                            reader.setLenient(true);
                            list = (List) gson.fromJson(response, List.class);
                            postTitle = new String[list.size()];
                            postSubtitle = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                JsonReader reader2 = new JsonReader(new StringReader(url4));
                                reader2.setLenient(true);
                                mapPost = (Map<String, Object>) list.get(i);
                                int id = ((Double) mapPost.get("id")).intValue();
                                postId[i] = id;
                                String dd=(String) mapPost.get("date");
                                postDate[i]=dd.substring(0,10);
                                mapTitle = (Map<String, Object>) mapPost.get("title");
                                postTitle[i] = (String) mapTitle.get("rendered");
                                mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                                postSubtitle[i] = (String) mapTitle.get("rendered");
                                mapImage = (String) mapPost.get("jetpack_featured_media_url");
                                if (mapImage.equals("")) {
                                    postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                                } else {
                                    postImage[i] = mapImage;
                                }
                            }

                                final String id13=String.valueOf(postId[0]);
                                final String id14=String.valueOf(postId[1]);
                                final String id15=String.valueOf(postId[2]);
                                final String id16=String.valueOf(postId[3]);

                                Glide.with(getContext()).load(postImage[0]).crossFade().into(newsImage13);
                                Glide.with(getContext()).load(postImage[1]).crossFade().into(newsImage14);
                                Glide.with(getContext()).load(postImage[2]).crossFade().into(newsImage15);
                                Glide.with(getContext()).load(postImage[3]).crossFade().into(newsImage16);

                                newsTitle13.setText(postTitle[0]);
                                newsTitle14.setText(postTitle[1]);
                                newsTitle15.setText(postTitle[2]);
                                newsTitle16.setText(postTitle[3]);

                                newsSubtitle14.setText(postSubtitle[1]);
                                newsSubtitle15.setText(postSubtitle[2]);
                                newsSubtitle16.setText(postSubtitle[3]);

                                date10.setText(postDate[1]);
                                date11.setText(postDate[2]);
                                date12.setText(postDate[3]);

                                loading_news_rajnity.setVisibility(View.VISIBLE);

                                CardView card13=(CardView)getView().findViewById(R.id.card13);
                                card13.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i=new Intent(getContext(),Post.class);
                                        i.putExtra("id",id13);
                                        i.putExtra("cat","rajnity");
                                        startActivity(i);
                                        getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                    }
                                });

                                CardView card14=(CardView)getView().findViewById(R.id.card14);
                                card14.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i=new Intent(getContext(),Post.class);
                                        i.putExtra("id",id14);
                                        i.putExtra("cat","rajnity");
                                        startActivity(i);
                                        getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                    }
                                });

                                CardView card15=(CardView)getView().findViewById(R.id.card15);
                                card15.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i=new Intent(getContext(),Post.class);
                                        i.putExtra("id",id15);
                                        i.putExtra("cat","rajnity");
                                        startActivity(i);
                                        getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                    }
                                });

                                CardView card16=(CardView)getView().findViewById(R.id.card16);
                                card16.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent i=new Intent(getContext(),Post.class);
                                        i.putExtra("id",id16);
                                        i.putExtra("cat","rajnity");
                                        startActivity(i);
                                        getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                                    }
                                });

                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        loadNewsloksova lnr = new loadNewsloksova();
                                        new Thread(lnr).start();
                                    }
                                },1000);


                            }catch (Exception e){
                                //Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                                run();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            if (trying4!=4){
                                Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                                run();
                                trying4=trying4+1;
                            }else {
                                Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                try {
                    RequestQueue rQueue = Volley.newRequestQueue(getContext());
                    rQueue.add(stringRequest);
                }catch (Exception e){

                }
            }
        }


    //Load news of loksova category ..................................................................................
    class loadNewsloksova implements Runnable {
        @Override
        public void run() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url5, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url4));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url4));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");
                            mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                            postSubtitle[i] = (String) mapTitle.get("rendered");
                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                        final String id17=String.valueOf(postId[0]);
                        final String id18=String.valueOf(postId[1]);
                        final String id19=String.valueOf(postId[2]);
                        final String id20=String.valueOf(postId[3]);

                        Glide.with(getContext()).load(postImage[0]).crossFade().into(newsImage17);
                        Glide.with(getContext()).load(postImage[1]).crossFade().into(newsImage18);
                        Glide.with(getContext()).load(postImage[2]).crossFade().into(newsImage19);
                        Glide.with(getContext()).load(postImage[3]).crossFade().into(newsImage20);

                        newsTitle17.setText(postTitle[0]);
                        newsTitle18.setText(postTitle[1]);
                        newsTitle19.setText(postTitle[2]);
                        newsTitle20.setText(postTitle[3]);

                        newsSubtitle18.setText(postSubtitle[1]);
                        newsSubtitle19.setText(postSubtitle[2]);
                        newsSubtitle20.setText(postSubtitle[3]);

                        date13.setText(postDate[1]);
                        date19.setText(postDate[2]);
                        date20.setText(postDate[3]);

                        loading_news_loksova.setVisibility(View.VISIBLE);

                        CardView card17=(CardView)getView().findViewById(R.id.card17);
                        card17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id17);
                                i.putExtra("cat","loksova");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        CardView card18=(CardView)getView().findViewById(R.id.card18);
                        card18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id18);
                                i.putExtra("cat","loksova");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        CardView card19=(CardView)getView().findViewById(R.id.card19);
                        card19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id19);
                                i.putExtra("cat","loksova");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        CardView card20=(CardView)getView().findViewById(R.id.card20);
                        card20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id20);
                                i.putExtra("cat","loksova");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });


                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                loadannoNews lnr = new loadannoNews();
                                new Thread(lnr).start();
                            }
                        },1000);




                    }catch (Exception e){
                        //Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                        run();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (trying4!=4){
                        Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                        run();
                        trying4=trying4+1;
                    }else {
                        Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }
        }
    }


    class loadannoNews implements Runnable{
        @Override
        public void run() {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url6, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url4));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url4));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");

                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                        final String id21=String.valueOf(postId[0]);
                        final String id22=String.valueOf(postId[1]);
                        final String id23=String.valueOf(postId[2]);
                        final String id24=String.valueOf(postId[3]);
                        final String id25=String.valueOf(postId[4]);

                        Glide.with(getContext()).load(postImage[0]).crossFade().into(onnoimg1);
                        Glide.with(getContext()).load(postImage[1]).crossFade().into(onnoimg2);
                        Glide.with(getContext()).load(postImage[2]).crossFade().into(onnoimg3);
                        Glide.with(getContext()).load(postImage[3]).crossFade().into(onnoimg4);
                        Glide.with(getContext()).load(postImage[4]).crossFade().into(onnoimg5);

                        onnotitle1.setText(postTitle[0]);
                        onnotitle2.setText(postTitle[1]);
                        onnotitle3.setText(postTitle[2]);
                        onnotitle4.setText(postTitle[3]);
                        onnotitle5.setText(postTitle[4]);

                        onnodate1.setText(postDate[0]);
                        onnodate2.setText(postDate[1]);
                        onnodate3.setText(postDate[2]);
                        onnodate4.setText(postDate[3]);
                        onnodate5.setText(postDate[4]);


                        loading_news_onno.setVisibility(View.VISIBLE);

                       // sb1.setVisibility(View.VISIBLE);

                        anno1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id21);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id22);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id23);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id24);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });

                        anno5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i=new Intent(getContext(),Post.class);
                                i.putExtra("id",id25);
                                i.putExtra("cat","onno");
                                startActivity(i);
                                getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                            }
                        });


                    }catch (Exception e){
                        //Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                        run();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (trying4!=4){
                        Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                        run();
                        trying4=trying4+1;
                    }else {
                        Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }
        }
        }

    class loadannoseraextra implements Runnable{
        @Override
        public void run() {
            final String url7 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=67&per_page=15";
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url7, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        gson = new Gson();
                        JsonReader reader = new JsonReader(new StringReader(url7));
                        reader.setLenient(true);
                        list = (List) gson.fromJson(response, List.class);
                        postTitle = new String[list.size()];
                        postSubtitle = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            JsonReader reader2 = new JsonReader(new StringReader(url7));
                            reader2.setLenient(true);
                            mapPost = (Map<String, Object>) list.get(i);
                            int id = ((Double) mapPost.get("id")).intValue();
                            postId[i] = id;
                            String dd=(String) mapPost.get("date");
                            postDate[i]=dd.substring(0,10);
                            mapTitle = (Map<String, Object>) mapPost.get("title");
                            postTitle[i] = (String) mapTitle.get("rendered");
                            mapSubtitle = (Map<String, Object>) mapPost.get("excerpt");
                            postSubtitle[i] = (String) mapSubtitle.get("rendered");

                            mapImage = (String) mapPost.get("jetpack_featured_media_url");
                            if (mapImage.equals("")) {
                                postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                            } else {
                                postImage[i] = mapImage;
                            }
                        }

                        DataAdapter adpt=new DataAdapter(postTitle,postSubtitle,postImage);
                        sr1.setAdapter(adpt);

                    }catch (Exception e){
                        Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
                        run();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if (trying4!=4){
                        Toast.makeText(getContext(), "Slow network connection!", Toast.LENGTH_SHORT).show();
                        run();
                        trying4=trying4+1;
                    }else {
                        Toast.makeText(getContext(), "Slow network connection, Please refresh the page!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            try {
                RequestQueue rQueue = Volley.newRequestQueue(getContext());
                rQueue.add(stringRequest);
            }catch (Exception e){

            }
        }
    }


    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private String[] postTitle;
        private String[] postSubtitle;
        private String[] postImage;

        public DataAdapter(String[] postTitle,String[] postSubtitle,String[] postImage) {
            this.postTitle = postTitle ;
            this.postSubtitle = postSubtitle ;
            this.postImage=postImage;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list, viewGroup, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.ntitle.setText(postTitle[i]);
            viewHolder.nstitle.setText(postSubtitle[i]);
            Glide.with(viewHolder.nimg.getContext()).load(postImage[i]).crossFade().into(viewHolder.nimg);
            viewHolder.ndate3.setText(postDate[i]);


            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int j=i+1;
                    Intent i=new Intent(getContext(),Post.class);
                    i.putExtra("id",postId[j]+"");
                    i.putExtra("cat","sera");
                    startActivity(i);
                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                }
            });

        }
        @Override
        public int getItemCount() {
            return list.size();
        }//return size of array

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView ntitle,nstitle,ndate3;
            private ImageView nimg;
            public ViewHolder(View view) {
                super(view);

                ntitle = (TextView)view.findViewById(R.id.newsTitle3);
                nstitle = (TextView)view.findViewById(R.id.newsSubtitle3);
                nimg=(ImageView)view.findViewById(R.id.newsImage3);
                ndate3=(TextView)view.findViewById(R.id.ndate3);
            }
        }

    }



    }



