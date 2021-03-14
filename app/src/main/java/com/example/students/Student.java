package com.example.students;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    String studentName = "";
    String studentPhone = "";
    String studentEmail = "";

    protected Student(Parcel in) {
        studentName = in.readString();
        studentPhone = in.readString();
        studentEmail = in.readString();
    }

    public Student() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentName);
        dest.writeString(studentPhone);
        dest.writeString(studentEmail);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
