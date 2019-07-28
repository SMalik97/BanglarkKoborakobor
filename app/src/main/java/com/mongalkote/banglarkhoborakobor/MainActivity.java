package com.mongalkote.banglarkhoborakobor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
ImageView imageView2;
TextView textView;
    String newsCategory="sera";
    String name;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        imageView2=(ImageView)findViewById(R.id.imageView2);
        textView=(TextView)findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);

        saveFile("sera");

        Animation a;
        a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        imageView2.startAnimation(a);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setVisibility(View.VISIBLE);
                        Animation a;
                        a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
                        textView.startAnimation(a);
                    }
                });
            }
        },2000);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkConnection();
                    }
                });
            }
        },4000);






    }
    private void saveFile(String pname){
        SharedPreferences sharedPref=getSharedPreferences(newsCategory, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("name",pname);
        editor.apply();
    }

    public void checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;

        if (connected){
            Intent i=new Intent(getApplicationContext(),Home.class);
            startActivity(i);
            finish();

        }else {
            showDialog();
        }
    }

    public void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_nointernet);
        builder.setTitle("No connection");
        builder.setMessage("It seems your device is offline\nPlease connect to the internet.");
        builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                checkConnection();

            }
        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.create().show();
    }
}
