package com.mongalkote.banglarkhoborakobor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

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
}
