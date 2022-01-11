package com.example.lesson6_lists.domain;

public class NoteEntity {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NoteEntity(int id, String header, String text) {
        this.id = id;
        this.header = header;
        this.text = text;
    }

    private int id;
    private String header;
    private String text;
}
