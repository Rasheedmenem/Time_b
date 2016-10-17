package com.example.rasheedmenem.time;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView timer ;
    Button done ;
    timer t ;
    ProgressBar progressBar ;
    public static  int count = 0 ;
    public static TextView titlemision1 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this , "onCreate" , Toast.LENGTH_SHORT).show();
        // findviewbyid
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        timer = (TextView) findViewById(R.id.timertext);
        titlemision1 = (TextView)findViewById(R.id.titlemisiontext) ;

           titlemision1.setText(voidcall.name);
           long x = (voidcall.Time_call * 3600000) + (voidcall.min_call * 60000) ;

           timer.setText(String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(x),
                TimeUnit.MILLISECONDS.toMinutes(x) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(x)),
                TimeUnit.MILLISECONDS.toSeconds(x) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))));

        //==========================
        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long x = (voidcall.Time_call * 3600000) + (voidcall.min_call * 60000) ;


                timer.setText(String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(x),
                        TimeUnit.MILLISECONDS.toMinutes(x) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(x)),
                        TimeUnit.MILLISECONDS.toSeconds(x) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))));
                t = new timer(x , 1000);
                t.start();

            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(i);
            }
        });
    }





    class timer extends CountDownTimer{

        public  timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @SuppressLint("NewApi")
        @TargetApi(Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onTick(long l) {
            long milis = l ;

            String hms = String.format("%02d:%02d:%02d" , TimeUnit.MILLISECONDS.toHours(milis),
                    TimeUnit.MILLISECONDS.toMinutes(milis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milis)) ,
                    TimeUnit.MILLISECONDS.toSeconds(milis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milis)));
            timer.setText(hms);

            }

        @Override
        public void onFinish() {

        }


    }










































//==============================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //==============================================================================================



}
