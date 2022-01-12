package com.example.lesson6_lists;

import android.app.Application;
import android.content.Context;

import com.example.lesson6_lists.data.SimpleNoteRepoImpl;
import com.example.lesson6_lists.domain.NoteRepo;

public class App extends Application {

    private NoteRepo noteRepository = new SimpleNoteRepoImpl();

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public NoteRepo getNoteRepository() {
        return noteRepository;
    }
}
