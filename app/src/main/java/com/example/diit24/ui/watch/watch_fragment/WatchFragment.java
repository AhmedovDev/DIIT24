package com.example.diit24.ui.watch.watch_fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diit24.App;
import com.example.diit24.R;
import com.example.diit24.mvp.watch_fragment.WatchFragmentPresenter;
import com.example.diit24.mvp.watch_fragment.WatchFragmentView;
import com.example.diit24.ui.watch.WatchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WatchFragment extends Fragment implements WatchFragmentView, WatchActivity.DataFromActivityToFragment {

        private WatchFragmentPresenter presenter;

        List<HoursAndDate> hoursAndDates = new ArrayList<>();
    String date;
    String time;
    RecyclerView recyclerView;
    WatchFragmentAdapter adapter;

    // Фича для сохранения состояния фрагмента
    Object myObject;
    private Bundle savedState = null;
    private boolean createdStateInDestroyView;
    private static final String SAVED_BUNDLE_TAG = "saved_bundle";

    public WatchFragment() {
        // Required empty public constructor
    }

    public static WatchFragment newInstance() {
        Bundle args = new Bundle();
        WatchFragment myFragment = new WatchFragment();
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watch, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        // создаем адаптер
        presenter = new WatchFragmentPresenter(App.dataManager);
        presenter.attachView(this);
        //presenter.addHoursndDate(getArguments().getString("time"), getArguments().getString("date"));

    }


    @Override
    public void showHoursAndDate(List<HoursAndDate> list) {
        hoursAndDates = list;
        adapter = new WatchFragmentAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
    }

    @Override
    public void sendData(String count,String data, String hour) {

        presenter.addHoursndDate( count,hour, data);
    }
}

