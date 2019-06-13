package com.example.diit24.mvp.watch_fragment;

import com.example.diit24.data.global.DataManager;
import com.example.diit24.mvp.global.MvpPresenter;
import com.example.diit24.ui.watch.watch_fragment.HoursAndDate;

import java.util.ArrayList;
import java.util.List;
public class WatchFragmentPresenter extends MvpPresenter<WatchFragmentView> {
    private DataManager dataManager;

    List<HoursAndDate> hoursAndDates = new ArrayList<>();

    public WatchFragmentPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void addHoursndDate(String count , String hour, String date) {
        getView().showHoursAndDate(hoursAndDates);
        hoursAndDates.add(new HoursAndDate(count,hour, date));
    }
}