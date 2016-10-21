package com.example.rasheedmenem.time;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //The definition of variables
    public int progressmax = 0                         ;

    public TextView timer                              ;

    public Button done                                 ;

    public timer t                                     ;

    private ProgressBar progressBar                    ;

    private int mProgressStatus = 0                    ;

    public static TextView titlemision1 = null         ;

    //==============================================================================================



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(this , "onCreate" , Toast.LENGTH_SHORT).show();
        // findviewbyid

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        timer = (TextView) findViewById(R.id.timertext);
        titlemision1 = (TextView)findViewById(R.id.titlemisiontext) ;

        //==============================================================================================


        titlemision1.setText(voidcall.name);

        //to set time this like --> 00:00:00

           long x = (voidcall.Time_call * 3600000) + (voidcall.min_call * 60000) ;
           timer.setText(String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(x),
                TimeUnit.MILLISECONDS.toMinutes(x) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(x)),
                TimeUnit.MILLISECONDS.toSeconds(x) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))));

        //==============================================================================================



        // start timerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
        done = (Button) findViewById(R.id.start);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // progress bar
                  int minprog     = voidcall.min_call      ;
                  int hourprog    = voidcall.Time_call     ;
                  int rminprog    = minprog * 60           ;
                  int rhourprog   = hourprog * 3600        ;
                  int finalresult = rminprog + rhourprog   ;

                  progressmax = finalresult ;
                  progressBar.setMax(progressmax);

                 thread th = new thread();
                 th.start();

                // change varible to milis
                long x = (voidcall.Time_call * 3600000) + (voidcall.min_call * 60000) ;

                // put x in timer
                timer.setText(String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(x),
                        TimeUnit.MILLISECONDS.toMinutes(x) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(x)),
                        TimeUnit.MILLISECONDS.toSeconds(x) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))));
                t = new timer(x , 1000);
                t.start();

            }
        });
        //==============================================================================================



       // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //==============================================================================================

        //floating action bar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(i);
            }
        });

    }
    //==============================================================================================

    // thread to run a progress
    class thread extends  Thread{
        public void run(){
            while(mProgressStatus < progressmax) {
                progressBar.setSecondaryProgress(mProgressStatus);
                mProgressStatus++;

                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //==============================================================================================

// run the timerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
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




// menuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
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
/*
if( voidcall.Time_call == 1 ){
                    progressmax = 3600 ;
                    progressBar.setMax(progressmax);

                }
                if( voidcall.Time_call == 2 ){
                    progressmax = 7200 ;
                    progressBar.setMax(progressmax);

                }
                if(voidcall.min_call == 1){
                    progressmax = 60 ;
                    progressBar.setMax(progressmax);
                }
 */