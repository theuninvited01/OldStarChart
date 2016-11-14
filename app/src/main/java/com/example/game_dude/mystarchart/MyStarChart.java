package com.example.game_dude.mystarchart;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyStarChart extends AppCompatActivity {

    EditText userBdateLbl;
    EditText userBdate;
    EditText userBtimeLbl;
    EditText userBtime;
    Button selectDateTimeBtn;
    DatePicker userBDatePicker;
    TimePicker userBTimePicker;
    String bDate;
    String bTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_star_chart);

        userBdateLbl = (EditText) findViewById(R.id.userBdLbl);
        userBdate = (EditText) findViewById(R.id.userBd);
        userBtimeLbl = (EditText) findViewById(R.id.userBtLbl);
        userBtime = (EditText) findViewById(R.id.userBtime);
        selectDateTimeBtn = (Button) findViewById(R.id.choose_dateTime_btn);
        selectDateTimeBtn.setText("Select Birthdate");
        userBDatePicker = (DatePicker) findViewById(R.id.userBdPick);
        userBTimePicker = (TimePicker) findViewById(R.id.userBtPicker);

        userBtimeLbl.setVisibility(View.INVISIBLE);
        userBtime.setVisibility(View.INVISIBLE);
        userBTimePicker.setVisibility(View.INVISIBLE);
        userBdateLbl.setFocusable(false);
        userBdate.setFocusable(false);
        userBtimeLbl.setFocusable(false);

        userBDatePicker.init(1972, 0, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int yr, int moy, int dom) {

                bDate = ((moy + 1) + "-" + dom + "-" + yr);
                userBdate.setText(bDate);
            }
        });

        userBTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int h, int min) {
                bTime = (h+":"+min);
                userBtime.setText(bTime);
            }
        });

        selectDateTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bDate != null) {
                    userBdate.setText(bDate);
                    selectDateTimeBtn.setText("Select Birth Time");
                    userBDatePicker.setVisibility(View.INVISIBLE);
                    userBtimeLbl.setVisibility(View.VISIBLE);
                    userBtime.setVisibility(View.VISIBLE);
                    userBTimePicker.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public int getUserSign(Date bDate) {

        Calendar c = GregorianCalendar.getInstance();
        c.setTime(bDate);
        int yr = c.get(Calendar.YEAR);
        String profile = "";
        int sign = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date caDate = sdf.parse("12-19-" + yr);
            Date aqDate = sdf.parse("01-20-" + yr);
            Date pDate = sdf.parse("02-20-" + yr);
            Date aDate = sdf.parse("03-19-" + yr);
            Date tDate = sdf.parse("04-20-" + yr);
            Date gDate = sdf.parse("05-20-" + yr);
            Date cDate = sdf.parse("06-22-" + yr);
            Date lDate = sdf.parse("07-22-" + yr);
            Date vDate = sdf.parse("08-22-" + yr);
            Date liDate = sdf.parse("09-22-" + yr);
            Date scDate = sdf.parse("10-21-" + yr);
            Date saDate = sdf.parse("11-22-" + yr);
            if (bDate.after(pDate) && bDate.before(aDate)) {
                //profile = getString(R.string.pices_profile);
                sign = 12;
            } else if (bDate.after(aDate) && bDate.before(tDate)) {
                //profile = getString(R.string.aries_profile);
                sign = 1;
            } else if (bDate.after(tDate) && bDate.before(gDate)) {
                //profile = getString(R.string.taurus_profile);
                sign = 2;
            } else if (bDate.after(gDate) && bDate.before(cDate)) {
                //profile = getString(R.string.gemini_profile);
                sign = 3;
            } else if (bDate.after(cDate) && bDate.before(lDate)) {
                //profile = getString(R.string.cancer_profile);
                sign = 4;
            } else if (bDate.after(lDate) && bDate.before(vDate)) {
                //profile = getString(R.string.leo_profile);
                sign = 5;
            } else if (bDate.after(vDate) && bDate.before(liDate)) {
                //profile = getString(R.string.virgo_profile);
                sign = 6;
            } else if (bDate.after(liDate) && bDate.before(scDate)) {
                //profile = getString(R.string.libra_profile);
                sign = 7;
            } else if (bDate.after(scDate) && bDate.before(saDate)) {
                //profile = getString(R.string.scorpio_profile);
                sign = 8;
            } else if (bDate.after(saDate) && bDate.before(caDate)) {
                //profile = getString(R.string.sagittarius_profile);
                sign = 9;
            } else if (bDate.after(caDate) || bDate.before(aqDate)) {
                //profile = getString(R.string.capricorn_profile);
                sign = 10;
            } else if (bDate.after(aqDate) && bDate.before(pDate)) {
                //profile = getString(R.string.aquarius_profile);
                sign = 11;
            }
            return sign;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}



