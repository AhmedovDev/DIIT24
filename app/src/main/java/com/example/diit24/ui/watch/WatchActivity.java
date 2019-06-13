package com.example.diit24.ui.watch;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diit24.R;
import com.example.diit24.ui.watch.watch_fragment.HoursAndDate;
import com.example.diit24.ui.watch.watch_fragment.WatchFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WatchActivity extends AppCompatActivity {
    private TextView hour;
    private TextView date;
    private Button start;
    private Button stop;
    private FrameLayout frameContainer;
    private String data;
    DataFromActivityToFragment dataFromActivityToFragment;

    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment;
    List<HoursAndDate> hoursAndDates = new ArrayList<>();


    //Количество секунд на секундомере.
    private int seconds = 0;
    //Секундомер работает?
    private boolean running;
    int hours2 = 0;
    int minutes2 = 0;
    int secs2 = 0;
    int count = 1;
    private String MY_FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            fragment = WatchFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_list, fragment, MY_FRAGMENT_TAG)
                    .commit();
        } else {
            fragment = (WatchFragment) getSupportFragmentManager()
                    .findFragmentByTag(MY_FRAGMENT_TAG);
        }

        setContentView(R.layout.activity_watch);
        runTimer();
        giveDate();
        data = giveDate();
        actionBarChange();
        start = findViewById(R.id.start_button);
        stop = findViewById(R.id.reset_button);
        frameContainer = findViewById(R.id.fragment_list);

        start.setOnClickListener(v -> {
            running = true;
        });


        fragment = fm.findFragmentById(R.id.fragment_list);
        if (fragment == null) {
            fragment = WatchFragment.newInstance();
            dataFromActivityToFragment = (DataFromActivityToFragment) fragment;
            fm.beginTransaction()
                    .add(R.id.fragment_list, fragment)
                    .commit();
        }

    }


//    //Запустить секундомер при щелчке на кнопке Start.
//    public void onClickStart(View view) {
//      running = true;
//    }
//    //Запустить секундомер при щелчке на кнопке Stop.
//
//    //Сбросить секундомер при щелчке на кнопке Reset.
//    public void onClickStop(View view) {
//        running = false;
//        seconds = 0;
//        hour = findViewById(R.id.hours);
//    }

    //Обновление показаний таймера.
    public void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);


                stop.setOnClickListener(v -> {
                    seconds = 0;
                    String allTime = String.format("%d:%02d:%02d", hours2 = hours2 + hours, minutes2 = minutes2 + minutes, secs2 = secs2 + secs);
                    hour = findViewById(R.id.hours);
                    hour.setText(allTime);

//                    WatchFragment watchFragment = new WatchFragment();
//                    watchFragment.showHoursAndDate("scsd","ewfdewf");

                    // fragment = WatchFragment.newInstance(giveDate(),time);
                    if (running == true) {
                        running = false;
                        dataFromActivityToFragment.sendData(String.valueOf(count++), giveDate(), time);
                    } else
                        Toast.makeText(WatchActivity.this, "Вы не начали работу над задачей!", Toast.LENGTH_SHORT).show();

                });
            }
        });
    }


    public String giveDate() {

        date = findViewById(R.id.date);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d.MM.yyyy");
        date.setText(sdf.format(cal.getTime()));
        return sdf.format(cal.getTime());
    }

    // Задать цвет градиент Actionbar
    private void actionBarChange() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    public interface DataFromActivityToFragment {
        void sendData(String count, String data, String hour);
    }
// Запрет на смену ориентации.


}
