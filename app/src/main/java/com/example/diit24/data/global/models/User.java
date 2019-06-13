package com.example.diit24.data.global.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {
    @SerializedName("mail")
    private String mail;

    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String password;

    @SerializedName("photo")
    private String photo;

    @SerializedName("adress")
    private String adress;

    @SerializedName("sex")
    private String sex;

    @SerializedName("date")
    private String date;

    @SerializedName("fio")
    private String fio;

    protected User(Parcel in) {
        mail = in.readString();
        id = in.readString();
        password = in.readString();
        photo = in.readString();
        adress = in.readString();
        sex = in.readString();
        date = in.readString();
        fio = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {return mail;}

    public void setMail (String mail) {this.mail = mail;}

    public String getPassword() {return password;}

    public void setPassword (String password) {this.password = password;}

    public String getPhoto() {return photo;}

    public void setPhoto (String photo) {this.photo = photo;}

    public String getAdress() {return adress;}

    public void setAdress (String adress) {this.adress = adress;}

    public String getSex() {return sex;}

    public void setSex (String sex) {this.sex = sex;}

    public String getDate() {return date;}

    public void setDate (String date) {this.date = date;}

    public String getFio() {return fio;}

    public void setFio (String fio) {this.fio = fio;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mail);
        dest.writeString(id);
        dest.writeString(password);
        dest.writeString(photo);
        dest.writeString(adress);
        dest.writeString(sex);
        dest.writeString(date);
        dest.writeString(fio);
    }
}

