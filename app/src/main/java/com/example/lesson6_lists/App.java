package com.example.lesson6_lists;

import android.app.Application;
import android.content.Context;

import com.example.lesson6_lists.data.SnappyNoteRepositoryImpl;
import com.example.lesson6_lists.domain.NoteRepository;

public class App extends Application {

    private static final String SHARED_PREFERENCES_NAME = "com.example.gb03_android_on_java_notes";

    private static App instance;
    private SnappyNoteRepositoryImpl noteRepository = new SnappyNoteRepositoryImpl();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        noteRepository.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        noteRepository.destroy();
    }

    public static App get() {
        return instance;
    }

    public NoteRepository getNoteRepository() {
        return noteRepository;
    }

    public SharedPreferences getNoteSharedPreferences() {
        return getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
    }
}
