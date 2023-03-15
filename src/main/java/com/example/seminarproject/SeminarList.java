package com.example.seminarproject;

public class SeminarList {

    // Field
    private int id;
    private String topic;
    private String guest;
    private String date;
    private String venue;

    // constructor:

    public SeminarList(int id,String topic,String guest, String date, String venue){
        this.id=id;
        this.topic=topic;
        this.guest=guest;
        this.date=date;
        this.venue=venue;
    }

    // Getter and Setter method
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
