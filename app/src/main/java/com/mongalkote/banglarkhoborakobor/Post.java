package com.mongalkote.banglarkhoborakobor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class Post extends AppCompatActivity {
    TextView title,rnt1,rnt2,rnt3,rnt4;
    WebView content,pic;
    Gson gson;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    Map<String, Object> mapContent;
    String id,cat;
    String iu,rurl;
    String mapImage;
    ImageView fb,wa,tw,g,sh,rni1,rni2,rni3,rni4;
    LinearLayout share1;
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    HorizontalScrollView sc1,sc2;
    List<Object> list;
    String[] postTitle;
    String postImage[]=new String[5];
    CardView rnews1,rnews2,rnews3,rnews4;
    int rpostId[]=new int[20];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        //Display back button on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        title = (TextView) findViewById(R.id.show_news);
        content = (WebView)findViewById(R.id.content);
        pic=(WebView)findViewById(R.id.pic);
        fb=(ImageView)findViewById(R.id.fb);
        wa=(ImageView)findViewById(R.id.wa);
        g=(ImageView)findViewById(R.id.g);
        tw=(ImageView)findViewById(R.id.tw);
        sh=(ImageView)findViewById(R.id.sh);
        share1=(LinearLayout)findViewById(R.id.share1);
        share1.setVisibility(View.INVISIBLE);
        sc1=(HorizontalScrollView)findViewById(R.id.sc1);
        sc2=(HorizontalScrollView)findViewById(R.id.sc2);
        sc1.setVisibility(View.INVISIBLE);
        sc2.setVisibility(View.INVISIBLE);
        rni1=(ImageView)findViewById(R.id.rni1);
        rni2=(ImageView)findViewById(R.id.rni2);
        rni3=(ImageView)findViewById(R.id.rni3);
        rni4=(ImageView)findViewById(R.id.rni4);

        rnt1=(TextView)findViewById(R.id.rnt1);
        rnt2=(TextView)findViewById(R.id.rnt2);
        rnt3=(TextView)findViewById(R.id.rnt3);
        rnt4=(TextView)findViewById(R.id.rnt4);

        rnews1=(CardView)findViewById(R.id.rnews1);
        rnews2=(CardView)findViewById(R.id.rnews2);
        rnews3=(CardView)findViewById(R.id.rnews3);
        rnews4=(CardView)findViewById(R.id.rnews4);

        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent p=new Intent(Intent.ACTION_SEND);
                    p.setType("text/plain");
                    p.putExtra(Intent.EXTRA_TEXT,title.getText().toString()+"\nread this news from here "+"https://mongalkote.com/archives/"+id);
                    p.setPackage("com.whatsapp");
                    startActivity(p);
                }catch (Exception e){
                    Toast.makeText(Post.this, "Please install Whatsapp app", Toast.LENGTH_SHORT).show();
                }

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent p=new Intent(Intent.ACTION_SEND);
                    p.setType("text/plain");
                    String uristring="https://mongalkote.com/archives/"+id;
                    p.putExtra(Intent.EXTRA_TEXT,uristring);
                    p.setPackage("com.facebook.lite");
                    startActivity(p);
                }catch (Exception e){
                    Toast.makeText(Post.this, "Please install Facebook app", Toast.LENGTH_SHORT).show();
                }

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent p=new Intent(Intent.ACTION_SEND);
                    p.setType("text/plain");
                    p.putExtra(Intent.EXTRA_TEXT,title.getText().toString()+"\nread this news from here "+"https://mongalkote.com/archives/"+id);
                    p.setPackage("com.google.android.apps.plus");
                    startActivity(p);
                }catch (Exception e){
                    Toast.makeText(Post.this, "Please install google+ app", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent p=new Intent(Intent.ACTION_SEND);
                    p.setType("text/plain");
                    p.putExtra(Intent.EXTRA_TEXT,title.getText().toString()+"\nread this news from here "+"https://mongalkote.com/archives/"+id);
                    p.setPackage("advance.twitter.android");
                    startActivity(p);
                }catch (Exception e){
                    Toast.makeText(Post.this, "Please install Twitter app", Toast.LENGTH_SHORT).show();
                }

            }
        });

        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //share activity
                Intent p=new Intent(Intent.ACTION_SEND);
                p.setType("text/plain");
                p.putExtra(Intent.EXTRA_TEXT,title.getText().toString()+"\nread this news from here "+"https://mongalkote.com/archives/"+id);
                startActivity(p);

            }
        });


//.......................................................................................................................
        //load news in webview
        id = getIntent().getExtras().getString("id");
        cat = getIntent().getExtras().getString("cat");


        String url = "https://www.mongalkote.com/wp-json/wp/v2/posts/"+id+"?fields=title,content";

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                gson = new Gson();
                mapPost = (Map<String, Object>) gson.fromJson(s, Map.class);
                mapTitle = (Map<String, Object>) mapPost.get("title");
                mapContent = (Map<String, Object>) mapPost.get("content");
                mapImage = (String) mapPost.get("jetpack_featured_media_url");

                title.setText(mapTitle.get("rendered").toString());
                content.getSettings().setJavaScriptEnabled(true);
                //content.getSettings().setLoadWithOverviewMode(true);
                //content.getSettings().setUseWideViewPort(true);
                //content.getSettings().setBuiltInZoomControls(true);

                content.loadData(mapContent.get("rendered").toString(),"text/html;charset=UTF-8",null);
                iu=mapPost.get("jetpack_featured_media_url").toString();

                pic.setWebViewClient(new WebViewClient());
                // for resize the image to fit webview
                pic.getSettings().setLoadWithOverviewMode(true);
                pic.getSettings().setUseWideViewPort(true);
                pic.getSettings().setJavaScriptEnabled(true);
                pic.loadUrl(iu);
                progressBar.setVisibility(View.INVISIBLE);
                share1.setVisibility(View.VISIBLE);

                //load relative news
                relenews a=new relenews();
                new Thread(a).start();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(Post.this, "Slow loading, please wait...", Toast.LENGTH_LONG).show();

                String url = "https://www.mongalkote.com/wp-json/wp/v2/posts/"+id+"?fields=title,content";
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        gson = new Gson();
                        mapPost = (Map<String, Object>) gson.fromJson(s, Map.class);
                        mapTitle = (Map<String, Object>) mapPost.get("title");
                        mapContent = (Map<String, Object>) mapPost.get("content");
                        mapImage = (String) mapPost.get("jetpack_featured_media_url");

                        title.setText(mapTitle.get("rendered").toString());
                        content.getSettings().setJavaScriptEnabled(true);
                        //content.getSettings().setLoadWithOverviewMode(true);
                        //content.getSettings().setUseWideViewPort(true);
                        //content.getSettings().setBuiltInZoomControls(true);


                        content.loadData(mapContent.get("rendered").toString(),"text/html;charset=UTF-8",null);
                        iu=mapPost.get("jetpack_featured_media_url").toString();
                        pic.setWebViewClient(new WebViewClient());
                        // for resize the image to fit webview
                        pic.getSettings().setLoadWithOverviewMode(true);
                        pic.getSettings().setUseWideViewPort(true);
                        pic.getSettings().setJavaScriptEnabled(true);
                        pic.loadUrl(iu);
                        progressBar.setVisibility(View.INVISIBLE);
                        share1.setVisibility(View.VISIBLE);

                        //load relative news
                        relenews a=new relenews();
                        new Thread(a).start();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Post.this, "Slow connection, Refresh the page", Toast.LENGTH_LONG).show();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(Post.this);
                rQueue.add(request);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(Post.this);
        rQueue.add(request);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        getMenuInflater().inflate(R.menu.refresh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in2,R.anim.slide_out2);
                break;

            case R.id.refresh:
                progressDialog = new ProgressDialog(Post.this);
                progressDialog.setMessage("Refreshing...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                String url = "https://www.mongalkote.com/wp-json/wp/v2/posts/"+id+"?fields=title,content";
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        gson = new Gson();
                        mapPost = (Map<String, Object>) gson.fromJson(s, Map.class);
                        mapTitle = (Map<String, Object>) mapPost.get("title");
                        mapContent = (Map<String, Object>) mapPost.get("content");
                        mapImage = (String) mapPost.get("jetpack_featured_media_url");

                        title.setText(mapTitle.get("rendered").toString());
                        content.getSettings().setJavaScriptEnabled(true);
                       // content.getSettings().setLoadWithOverviewMode(true);
                        //content.getSettings().setUseWideViewPort(true);
                        //content.getSettings().setBuiltInZoomControls(true);
                        content.loadData(mapContent.get("rendered").toString(),"text/html;charset=UTF-8",null);
                        iu=mapPost.get("jetpack_featured_media_url").toString();
                        pic.setWebViewClient(new WebViewClient());
                        // for resize the image to fit webview
                        pic.getSettings().setLoadWithOverviewMode(true);
                        pic.getSettings().setUseWideViewPort(true);
                        pic.getSettings().setJavaScriptEnabled(true);
                        pic.loadUrl(iu);
                        progressDialog.dismiss();
                        share1.setVisibility(View.VISIBLE);

                        //load relative news
                        relenews a=new relenews();
                        new Thread(a).start();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(Post.this, "Slow connection, Refresh the page", Toast.LENGTH_LONG).show();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(Post.this);
                rQueue.add(request);
                break;
            case R.id.action_share:
                //share activity
                Intent p=new Intent(Intent.ACTION_SEND);
                p.setType("text/plain");
                p.putExtra(Intent.EXTRA_TEXT,"Read the news now from here "+"https://mongalkote.com/archives/"+id);
                startActivity(p);
                break;
            case R.id.action_browser:
                //Rate activity
                String g="https://mongalkote.com/archives/"+id;
                Uri w= Uri.parse(g);
                Intent d=new Intent(Intent.ACTION_VIEW,w);
                if(d.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(d);
                }
                break;

        }
        return true;
    }
    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_in2,R.anim.slide_out2);
    }

    class relenews implements Runnable{
        @Override
        public void run() {
            switch (cat) {
                case "sera":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=64&per_page=4";
                    break;
                case "police":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=65&per_page=4";
                    break;
                case "prosason":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=63&per_page=4";
                    break;
                case "rajnity":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=67&per_page=4";
                    break;
                case "loksova":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=66&per_page=4";
                    break;
                case "onno":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=64&per_page=4";
                    break;
                case "kriya":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=65&per_page=4";
                    break;
                case "biggapon":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=63&per_page=4";
                    break;
                case "sahitya":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=67&per_page=4";
                    break;
                case "video":
                    rurl = "https://www.mongalkote.com/wp-json/wp/v2/posts?categories=107&per_page=4";
                    break;
            }


                StringRequest request = new StringRequest(Request.Method.GET, rurl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try{
                            gson = new Gson();
                            JsonReader reader = new JsonReader(new StringReader(rurl));
                            reader.setLenient(true);
                            list = (List) gson.fromJson(s, List.class);
                            postTitle = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                JsonReader reader2 = new JsonReader(new StringReader(rurl));
                                reader2.setLenient(true);
                                mapPost = (Map<String, Object>) list.get(i);
                                int id = ((Double) mapPost.get("id")).intValue();
                                rpostId[i] = id;
                                mapTitle = (Map<String, Object>) mapPost.get("title");
                                postTitle[i] = (String) mapTitle.get("rendered");
                                mapImage = (String) mapPost.get("jetpack_featured_media_url");
                                if (mapImage.equals("")) {
                                    postImage[i] = "https://i1.wp.com/mongalkote.com/wp-content/uploads/2018/12/IMG-20181224-WA0015.jpg?resize=768%2C294&ssl=1";
                                } else {
                                    postImage[i] = mapImage;
                                }
                            }


                            Glide.with(getApplicationContext()).load(postImage[0]).crossFade().into(rni1);
                            rnt1.setText(postTitle[0]);

                            Glide.with(getApplicationContext()).load(postImage[1]).crossFade().into(rni2);
                            rnt2.setText(postTitle[1]);

                            Glide.with(getApplicationContext()).load(postImage[2]).crossFade().into(rni3);
                            rnt3.setText(postTitle[2]);

                            Glide.with(getApplicationContext()).load(postImage[3]).crossFade().into(rni4);
                            rnt4.setText(postTitle[3]);

                            sc1.setVisibility(View.VISIBLE);
                            sc2.setVisibility(View.VISIBLE);

                            rnews1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getApplicationContext(),Post.class);
                                    i.putExtra("id",rpostId[0]+"");
                                    i.putExtra("cat",cat);
                                    startActivity(i);
                                    finish();
                                }
                            });

                            rnews2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getApplicationContext(),Post.class);
                                    i.putExtra("id",rpostId[1]+"");
                                    i.putExtra("cat",cat);
                                    startActivity(i);
                                    finish();
                                }
                            });

                            rnews3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getApplicationContext(),Post.class);
                                    i.putExtra("id",rpostId[2]+"");
                                    i.putExtra("cat",cat);
                                    startActivity(i);
                                    finish();
                                }
                            });

                            rnews4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent i=new Intent(getApplicationContext(),Post.class);
                                    i.putExtra("id",rpostId[3]+"");
                                    i.putExtra("cat",cat);
                                    startActivity(i);finish();

                                }
                            });
                        }catch (Exception e){
                            run();
                        }



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(Post.this, "Slow connection, Can't load relative news", Toast.LENGTH_LONG).show();
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(Post.this);
                rQueue.add(request);

        }
    }
}
