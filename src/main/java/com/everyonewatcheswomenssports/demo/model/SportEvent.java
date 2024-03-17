package com.everyonewatcheswomenssports.demo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SportEvent {

    private String eventName;
    private LocalDateTime eventTime;
    private String eventNetwork;
    private String eventUrl;


    //todo may want to change the formatter later on to just time of day?
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    //constructor
    public SportEvent (String eventName, String eventTimeString, String eventNetwork, String eventUrl) {
        this.eventName = eventName;
        this.eventTime = LocalDateTime.parse(eventTimeString, formatter);
        this.eventNetwork = eventNetwork;
        this.eventUrl = eventUrl;
    }

    //getters and setters
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTimeString) {
        this.eventTime = LocalDateTime.parse(eventTimeString, formatter);
    }

    public String getEventNetwork() {
        return eventNetwork;
    }

    public void setEventNetwork(String eventNetwork) {
        this.eventNetwork = eventNetwork;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    @Override
    public String toString() {
        return "SportEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventTime='" + eventTime.format(formatter) + '\'' +
                ", eventNetwork='" + eventNetwork + '\'' +
                ", eventUrl='" + eventUrl + '\'' +
                '}';
    }

    public String getEventTimeString() {
        return eventTime.format(formatter);
    }
}
