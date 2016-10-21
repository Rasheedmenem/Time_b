package com.example.rasheedmenem.time;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Main2Activity extends AppCompatActivity {
    //The definition of variables
    TextView to                ;
    TextView TitleMision       ;
    TextView TimeMisionchoose  ;
    TextView TimeMision        ;
    Switch onClock             ;
    Button finishbtn           ;


    Calendar c = Calendar.getInstance() ;
    int hour   = c.get(Calendar.HOUR)   ;
    int Minute = c.get(Calendar.HOUR)   ;
    int h = 0 ;
    int h1 = 0;
    int r = 0 ;
    int m = 0 ;
    int m1 = 0 ;
    int mr = 0 ;
    MainActivity main ;
    //==============================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //findview by id
        TitleMision      = (TextView) findViewById(R.id.TitleMision)      ;

        TimeMisionchoose = (TextView) findViewById(R.id.MisionTimeChoose) ;

        TimeMision       = (TextView) findViewById(R.id.TimeMision)       ;

        onClock          = (Switch)   findViewById(R.id.switchClock)      ;

        finishbtn        = (Button)   findViewById(R.id.Finishbtn)        ;

        to               = (TextView) findViewById(R.id.to)               ;
        //==============================================================================================

        // to make a time in main2
        TimeMisionchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                        TimeMisionchoose.setText("Mision time :  From : " + hour + ":" + minute);
                        h = hour ;
                        m = minute ;

                    }
                }, hour , Minute , true);
                timePickerDialog.setTitle("Select time from");
                timePickerDialog.show();
            }
        });

        to.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TimePickerDialog time = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                to.setText("to : " + hour + ":" + minute);
                                h1 = hour ;
                                m1= minute ;
                                r = h1 - h ;
                                mr = m1 - m ;
                                long x = r *3600000 + mr * 60000;
                                TimeMision.setText("to : " + String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(x),
                                        TimeUnit.MILLISECONDS.toMinutes(x) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(x)),
                                        TimeUnit.MILLISECONDS.toSeconds(x) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(x))));
                          }
                        }, hour , Minute , true);
                        time.setTitle("Select time from");
                        time.show();
                    }
                });
        //to set what users saved
        finishbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this , MainActivity.class);

                 voidcall.name = "" + TitleMision.getText();

                 voidcall.Time_call = r ;

                //r is the hour
                 voidcall.min_call = mr ;

                // is the minute

                startActivity(intent);

            }
        });
        //==============================================================================================

        //==============================================================================================
    }

}
