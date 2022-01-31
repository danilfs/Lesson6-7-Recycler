package com.example.lesson6_lists;

import android.app.Application;
import android.content.Context;

import com.example.lesson6_lists.data.MemoryNoteRepository;
import com.example.lesson6_lists.domain.NoteRepository;

public class App extends Application {

    private NoteRepository noteRepository = new MemoryNoteRepository();

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public NoteRepository getNoteRepository() {
        return noteRepository;
    }
}
