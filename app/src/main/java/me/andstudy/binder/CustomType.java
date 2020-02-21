package me.andstudy.binder;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomType implements Parcelable {

    private String aString;
    private int aInteger;

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public int getaInteger() {
        return aInteger;
    }

    public void setaInteger(int aInteger) {
        this.aInteger = aInteger;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.aString);
        dest.writeInt(this.aInteger);
    }

    public CustomType() {
    }

    protected CustomType(Parcel in) {
        this.aString = in.readString();
        this.aInteger = in.readInt();
    }

    public static final Parcelable.Creator<CustomType> CREATOR = new Parcelable.Creator<CustomType>() {
        @Override
        public CustomType createFromParcel(Parcel source) {
            return new CustomType(source);
        }

        @Override
        public CustomType[] newArray(int size) {
            return new CustomType[size];
        }
    };
}
