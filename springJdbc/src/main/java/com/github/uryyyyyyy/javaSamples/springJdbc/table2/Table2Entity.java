package com.github.uryyyyyyy.javaSamples.springJdbc.table2;


import java.sql.Time;
import java.sql.Timestamp;

public class Table2Entity {
    private Timestamp dateTime;
    private Timestamp onlyDate;
    private Time onlyTime;

    public Table2Entity(){}

    public Table2Entity(Timestamp dateTime, Timestamp onlyDate, Time onlyTime) {
        this.dateTime = dateTime;
        this.onlyDate = onlyDate;
        this.onlyTime = onlyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table2Entity that = (Table2Entity) o;

        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (onlyDate != null ? !onlyDate.equals(that.onlyDate) : that.onlyDate != null) return false;
        return onlyTime != null ? onlyTime.equals(that.onlyTime) : that.onlyTime == null;

    }

    @Override
    public int hashCode() {
        int result = dateTime != null ? dateTime.hashCode() : 0;
        result = 31 * result + (onlyDate != null ? onlyDate.hashCode() : 0);
        result = 31 * result + (onlyTime != null ? onlyTime.hashCode() : 0);
        return result;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Timestamp getOnlyDate() {
        return onlyDate;
    }

    public void setOnlyDate(Timestamp onlyDate) {
        this.onlyDate = onlyDate;
    }

    public Time getOnlyTime() {
        return onlyTime;
    }

    public void setOnlyTime(Time onlyTime) {
        this.onlyTime = onlyTime;
    }
}