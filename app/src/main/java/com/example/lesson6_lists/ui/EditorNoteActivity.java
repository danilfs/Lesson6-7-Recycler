package com.example.lesson6_lists.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson6_lists.App;
import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.NoteEntity;
import com.example.lesson6_lists.domain.NoteRepo;
import com.google.android.material.textfield.TextInputEditText;

public class EditorNoteActivity extends AppCompatActivity {

    public static final String NOTE_ID_EXTRA_KEY = "note_id_extra_key";

    private NoteEntity note;
    private NoteRepo noteRepository;


    private TextInputEditText headerEditText;
    private TextInputEditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_note);

        noteRepository = App.get(this).getNoteRepository();

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(NOTE_ID_EXTRA_KEY)) {
            int noteId = intent.getIntExtra(NOTE_ID_EXTRA_KEY, -1);
            note = noteRepository.findNote(noteId);
        }

        initView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateNote();
    }

    private void initView() {
        headerEditText = findViewById(R.id.header_edit_text);
        contentEditText = findViewById(R.id.content_edit_text);

        if (note != null) {
            headerEditText.setText(note.getHeader());
            contentEditText.setText(note.getContent());
        }
    }

    private void updateNote() {
        note.setHeader(headerEditText.getText().toString());
        note.setContent(contentEditText.getText().toString());
        noteRepository.updateNote(note);
    }
}
