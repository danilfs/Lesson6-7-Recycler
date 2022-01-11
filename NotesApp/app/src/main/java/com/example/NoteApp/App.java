package com.example.NoteApp;

import android.app.Application;
import android.content.Context;

import com.example.NoteApp.data.SampleNoteRepository;
import com.example.NoteApp.domain.NoteRepository;

public class App extends Application {

    private NoteRepository noteRepository = new SampleNoteRepository();

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public NoteRepository getNoteRepository() {
        return noteRepository;
    }
}
