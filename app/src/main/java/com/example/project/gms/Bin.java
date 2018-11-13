package com.example.project.gms;

public class Bin {
    int garbage;
    String sensorId;
    String time;

    public Bin() {
    }

    public Bin(int garbage, String sensorId, String time) {
        this.garbage = garbage;
        this.sensorId = sensorId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "garbage=" + garbage +
                ", sensorId='" + sensorId + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getGarbage() {
        return garbage;
    }

    public void setGarbage(int garbage) {
        this.garbage = garbage;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
