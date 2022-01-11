package com.example.NoteApp.domain;

import java.util.Date;

public class NoteEntity {
    private final int id;
    private Date date;
    private String header;
    private String text;

    public NoteEntity(int id, Date date,String header, String text) {
        this.id = id;
        this.date = date;
        this.header = header;
        this.text = text;
    }

    public NoteEntity(int id, String header, String text) {
        this(id, new Date(), header, text);
    }

    public NoteEntity(int id) {
        this(id, "", "");
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
