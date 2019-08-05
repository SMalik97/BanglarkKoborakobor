package com.mongalkote.banglarkhoborakobor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.Toast;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String newsCategory="sera";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Fragment fragment = new news_sera();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.refresh, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {
            readFile();
            switch (name){
                case "sera":
                    Fragment fragment = new news_sera();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment);
                    transaction.commit();
                    break;
                case "police":
                    Fragment fragment2 = new news_police();
                    FragmentManager manager2 = getSupportFragmentManager();
                    FragmentTransaction transaction2 = manager2.beginTransaction();
                    transaction2.replace(R.id.frameLayout, fragment2);
                    transaction2.commit();
                    break;
                case "prosason":
                    Fragment fragment3 = new news_prosason();
                    FragmentManager manager3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = manager3.beginTransaction();
                    transaction3.replace(R.id.frameLayout, fragment3);
                    transaction3.commit();
                    break;
                case "rajnity":
                    Fragment fragment4 = new news_rajnity();
                    FragmentManager manager4 = getSupportFragmentManager();
                    FragmentTransaction transaction4 = manager4.beginTransaction();
                    transaction4.replace(R.id.frameLayout, fragment4);
                    transaction4.commit();
                    break;
                case "biggapon":
                    Fragment fragment5 = new news_biggapon();
                    FragmentManager manager5 = getSupportFragmentManager();
                    FragmentTransaction transaction5 = manager5.beginTransaction();
                    transaction5.replace(R.id.frameLayout, fragment5);
                    transaction5.commit();
                    break;
                case "kriya":
                    Fragment fragment6 = new news_kriya();
                    FragmentManager manager6 = getSupportFragmentManager();
                    FragmentTransaction transaction6 = manager6.beginTransaction();
                    transaction6.replace(R.id.frameLayout, fragment6);
                    transaction6.commit();
                    break;
                case "sahitya":
                    Fragment fragment7 = new news_sahitya();
                    FragmentManager manager7 = getSupportFragmentManager();
                    FragmentTransaction transaction7 = manager7.beginTransaction();
                    transaction7.replace(R.id.frameLayout, fragment7);
                    transaction7.commit();
                    break;
                case "loksova":
                    Fragment fragment8 = new news_loksova();
                    FragmentManager manager8 = getSupportFragmentManager();
                    FragmentTransaction transaction8 = manager8.beginTransaction();
                    transaction8.replace(R.id.frameLayout, fragment8);
                    transaction8.commit();
                    break;
                case "video":
                    Fragment fragment9 = new news_video();
                    FragmentManager manager9 = getSupportFragmentManager();
                    FragmentTransaction transaction9 = manager9.beginTransaction();
                    transaction9.replace(R.id.frameLayout, fragment9);
                    transaction9.commit();
                    break;
            }
            Toast.makeText(getApplicationContext(), "Refreshing...", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_sera) {
            Fragment fragment = new news_sera();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("sera");
        } else if (id == R.id.nav_police) {
            Fragment fragment = new news_police();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("police");
        } else if (id == R.id.nav_prosason) {
            Fragment fragment = new news_prosason();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("prosason");
        } else if (id == R.id.nav_rajnity) {
            Fragment fragment = new news_rajnity();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("rajnity");
        } else if (id == R.id.nav_biggapon) {
            Fragment fragment = new news_biggapon();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("biggapon");
        }else if (id == R.id.nav_kriya) {
            Fragment fragment = new news_kriya();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("kriya");
        }else if (id == R.id.nav_sahitya) {
            Fragment fragment = new news_sahitya();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("sahitya");
        }else if (id == R.id.nav_loksova) {
            Fragment fragment = new news_loksova();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("loksova");
        }else if (id == R.id.nav_video) {
            Fragment fragment = new news_video();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();

            saveFile("video");
        }else if (id == R.id.nav_kspc) {
            String u="https://katwapresscorner.blogspot.com";
            openInCustomTab(u);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        }else if (id == R.id.nav_mongalkote) {
            String u="https://katwapresscorner.blogspot.com";
            openInCustomTab(u);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        }else if (id == R.id.nav_bk) {
            String u="https://banglarkhoborakhobor.blogspot.com";
            openInCustomTab(u);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        }else if (id == R.id.nav_share) {
            Intent p=new Intent(Intent.ACTION_SEND);
            p.setType("text/plain");
            p.putExtra(Intent.EXTRA_TEXT,"Download the best news app Banglar Khoborakhobor and get daily news update. Download the app now from here "+"https://play.google.com/store/apps/details?id=com.mongalkote.banglarkhoborakobor");
            startActivity(p);
        }else if (id == R.id.nav_about) {
            AlertDialog.Builder alert=new AlertDialog.Builder(Home.this);
            alert.setTitle("");
            alert.setIcon(R.drawable.information);
            alert.setMessage("বাংলার খবরাখবর"+"\n"+"version: 4.1"+"\n\n"+"mongalkote.com is a news portal where we give importance to bengali news from every corner"+"\n\n"+"Contact us: "+"mongalkote.news@gmail.com");
            alert.setPositiveButton("OK",null);
            // Showing Alert Message
            alert.show();
            return true;
        }





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void readFile(){
        SharedPreferences sharedPrefe=getSharedPreferences(newsCategory, Context.MODE_PRIVATE);
        String defaultValue="sera";
        name=sharedPrefe.getString("name",defaultValue);
    }
    private void saveFile(String pname){
        SharedPreferences sharedPref=getSharedPreferences(newsCategory,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("name",pname);
        editor.apply();
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
            customtabintent.build().intent.setPackage("com.android.chrome").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        }
        customtabintent.build().launchUrl(getApplicationContext(),websiteUri);
    }


    private boolean chromeInstalled(){
        try{
            getPackageManager().getPackageInfo("com.android.chrome",0);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
