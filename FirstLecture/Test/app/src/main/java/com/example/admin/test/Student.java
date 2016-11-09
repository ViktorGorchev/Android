package com.example.admin.test;

import android.os.Parcel;
import android.os.Parcelable;

//for object transfer must be implemented interface Parcelable
public class Student implements Parcelable {

    private int mAge;

    public Student(int mAge) {
        this.setAge(mAge);
    }

    public int getAge() {
        return this.mAge;
    }

    private void setAge(int mAge) {
        this.mAge = mAge;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //for object transfer must have the following which was created using http://www.parcelabler.com/ tool
    // in the tool must be paste the above code
    protected Student(Parcel in) {
        mAge = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAge);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
