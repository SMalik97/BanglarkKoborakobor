package com.mongalkote.banglarkhoborakobor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import steelkiwi.com.library.DotsLoaderView;


public class news_video extends Fragment {
    List<Object> list;
    Gson gson;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    Map<String, Object> mapSubtitle;
    String[] postTitle;
    String[] postSubtitle;
    String mapImage;
    String postImage[] = new String[20];
    int postId[] = new int[20];
    String url1 = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=107&per_page=15";
    int trying = 0;
    CardView card1;
    ImageView newsImage1;
    TextView newsTitle1;
    DotsLoaderView loader;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String d;

    public news_video() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_news_video, null);

        //start loading news.....................................
        loader = (DotsLoaderView)view.findViewById(R.id.dotload);
        loader.show();
//load first 15 news
        first10news f10n=new first10news();
        new Thread(f10n).start();

        Date c= Calendar.getInstance().getTime();
        SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
        d=df.format(c);


        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }


    //Load news of 15 news ..........................................................................
    class first10news implements Runnable{
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
                            /*String d=(String) mapTitle.get("date");
                            Toast.makeText(getContext(), d+"", Toast.LENGTH_SHORT).show();*/
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




                        DataAdapter adpt=new DataAdapter(postTitle,postSubtitle,postImage);
                        recyclerView.setAdapter(adpt);
                        loader.hide();


                    }catch (Exception e){
                        // Toast.makeText(getContext(), "Json parsing error", Toast.LENGTH_SHORT).show();
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
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_video, viewGroup, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int i) {

            viewHolder.ntitle.setText(postTitle[i]);
            //viewHolder.nstitle.setText(postSubtitle[i+1]);
            Glide.with(viewHolder.nimg.getContext()).load(postImage[i]).crossFade().into(viewHolder.nimg);
            //viewHolder.ndate3.setText(d);


            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Intent a=new Intent(getContext(),Post.class);
                    a.putExtra("id",postId[i]+"");
                    a.putExtra("cat","video");
                    startActivity(a);*/
                    String u="https://mongalkote.com/archives/"+postId[i];
                    openInCustomTab(u);
                    getActivity().overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
                }
            });

        }



        @Override
        public int getItemCount() {
            return 15;
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


    //chrome custom tab
    private void openInCustomTab(String url){
        Uri websiteUri;
        if (!url.contains("https://")&&!url.contains("http://")){
            websiteUri=Uri.parse("http://"+url);
        }else {
            websiteUri=Uri.parse(url);
        }
        CustomTabsIntent.Builder customtabintent=new CustomTabsIntent.Builder();
        customtabintent.setToolbarColor(Color.parseColor("#3f51b5"));
        customtabintent.setShowTitle(true);
        if (chromeInstalled()){
            customtabintent.build().intent.setPackage("com.android.chrome");
        }
        customtabintent.build().launchUrl(getContext(),websiteUri);
    }


    private boolean chromeInstalled(){
        try{
            getActivity().getPackageManager().getPackageInfo("com.android.chrome",0);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}