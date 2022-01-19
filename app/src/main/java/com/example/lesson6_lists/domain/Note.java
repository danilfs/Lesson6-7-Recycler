package com.example.lesson6_lists.domain;

import java.util.Date;

public class Note {
    private final int id;
    private Date date;
    private String header;
    private String text;

    public Note(int id, Date date, String header, String text) {
        this.id = id;
        this.date = date;
        this.header = header;
        this.text = text;
    }

    public Note(int id, String header, String text) {
        this(id, new Date(), header, text);
    }

    public Note(int id) {
        this(id, "", "");
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return text;
    }

    public void setContent(String text) {
        this.text = text;
    }
}
