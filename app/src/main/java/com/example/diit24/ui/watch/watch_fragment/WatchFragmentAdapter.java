package com.example.diit24.ui.watch.watch_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diit24.R;

import java.util.List;

public class WatchFragmentAdapter extends RecyclerView.Adapter<WatchFragmentAdapter.Holder> {


    private List<HoursAndDate> hoursAndDate;
    int num = 0;

    WatchFragmentAdapter(List<HoursAndDate> hoursAndDates) {
        this.hoursAndDate = hoursAndDates;

    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_hour,
                parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.setData(hoursAndDate.get(position));
//        HoursAndDate hoursAndDates = hoursAndDate.get(position);
//        holder.date.setText(hoursAndDates.getDate());
//        holder.hours.setText(hoursAndDates.getHour());
    }

    @Override
    public int getItemCount() {
        return hoursAndDate.size();
    }

    public void setList(List<HoursAndDate> hoursAndDates) {
        this.hoursAndDate = hoursAndDates;
    }

    public class Holder extends RecyclerView.ViewHolder {
        final TextView date, hours, count;

        Holder(View view) {
            super(view);

            date = view.findViewById(R.id.date_save);
            hours = view.findViewById(R.id.hours_save);
            count = view.findViewById(R.id.count);
        }

        public void setData(HoursAndDate hoursAndDate) {
            date.setText(hoursAndDate.getDate());
            hours.setText(hoursAndDate.getHour());
            count.setText(hoursAndDate.getCount());

        }
    }
}