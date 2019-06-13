package com.example.diit24.mvp.watch_fragment;

import com.example.diit24.mvp.global.MvpView;
import com.example.diit24.ui.watch.watch_fragment.HoursAndDate;

import java.util.List;

public interface WatchFragmentView extends MvpView {

    void showHoursAndDate(List<HoursAndDate> list);
}
