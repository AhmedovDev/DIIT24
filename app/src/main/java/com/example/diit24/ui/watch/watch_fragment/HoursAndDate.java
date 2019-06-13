package com.example.diit24.ui.watch.watch_fragment;

public class HoursAndDate {

    private String date;
    private String hour;
    private String count;

    public HoursAndDate (String count,String date, String hour){
        this.date = date;
        this.hour = hour;
        this.count = count;

    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return this.hour;
    }

        public void setHour(String hour) {
        this.hour = hour;
    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
