package com.example.lesson6_lists.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Note implements Serializable {
    private UUID id;
    private Date date;
    private String header;
    private String text;

    public Note() {
        this.id = UUID.randomUUID();
        this.date = new Date();
    }

    public Note(Date date, String header, String text) {
        this();
        this.date = date;
        this.header = header;
        this.text = text;
    }

    public Note(String header, String text) {
        this();
        this.header = header;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
