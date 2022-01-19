package com.example.lesson6_lists.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.ui.editor.EditorFragment;
import com.example.lesson6_lists.ui.list.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.Controller, EditorFragment.Controller {

    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = ListFragment.getInstance();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, listFragment)
                    .commit();
        }
    }

    @Override
    public void onNoteSelected(Note note) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, EditorFragment.getInstance(note))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onNoteChanged(Note note) {
        listFragment.notifyNoteChanged(note);
    }
}