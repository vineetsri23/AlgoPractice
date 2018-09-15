package com.vineet.treebo.listeners.impl;

import com.vineet.treebo.listeners.Sensor;


public class SmokeSensor implements Sensor{
    public void raiseAlarm(final String message) {
        System.out.println(String.format("Smoke Alarm: %s", message));
    }
}
