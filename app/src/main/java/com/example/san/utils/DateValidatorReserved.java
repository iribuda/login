package com.example.san.utils;

import android.os.Parcel;

import com.google.android.material.datepicker.CalendarConstraints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateValidatorReserved implements CalendarConstraints.DateValidator {

    private Long startDate;
    private Long endDate;

    public DateValidatorReserved(Long startDate, Long endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    DateValidatorReserved(){}

    private Calendar utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    public static final Creator<DateValidatorReserved> CREATOR =
            new Creator<DateValidatorReserved>() {
                @Override
                public DateValidatorReserved createFromParcel(Parcel source) {
                    return new DateValidatorReserved();
                }

                @Override
                public DateValidatorReserved[] newArray(int size) {
                    return new DateValidatorReserved[size];
                }
            };

    @Override
    public boolean isValid(long date) {
        if (date>=this.startDate && date<=this.endDate){
            return false;
        }
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DateValidatorReserved)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        Object[] hashedFields = {};
        return Arrays.hashCode(hashedFields);
    }
}