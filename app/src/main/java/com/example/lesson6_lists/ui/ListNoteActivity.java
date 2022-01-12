package com.example.lesson6_lists.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lesson6_lists.App;
import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.NoteEntity;
import com.example.lesson6_lists.domain.NoteRepo;

public class ListNoteActivity extends AppCompatActivity implements NoteViewHolder.Callbacks {

    private static final int EDITOR_REQUEST_CODE = 42;

    private NoteRepo noteRepository;
    private NoteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);

        noteRepository = App.get(this).getNoteRepository();
        initView();
    }

    private void initView() {
        initRecyclerView();
        findViewById(R.id.add_note_button).setOnClickListener(this::onClickAddNoteButton);
    }

    private void initRecyclerView() {
        RecyclerView noteRecyclerView = findViewById(R.id.note_recycler_view);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(noteRepository.getNotes(), this);
        noteRecyclerView.setAdapter(adapter);
    }

    private void onClickAddNoteButton(View view) {
        NoteEntity note = noteRepository.createNote();
        showNoteEditor(note);
    }

    @Override
    public void onNoteSelected(int noteId, int position) {
        NoteEntity note = noteRepository.findNote(noteId);
        if (note != null) {
            showNoteEditor(note);
        }
    }

    @Override
    public boolean onNoteRemove(int noteId, int position) {
        if (noteRepository.removeNote(noteId)) {
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position, adapter.getItemCount() - position);
            return true;
        }
        return false;
    }

    private void showNoteEditor(NoteEntity note) {
        Intent intent = new Intent(this, EditorNoteActivity.class);
        intent.putExtra(EditorNoteActivity.NOTE_ID_EXTRA_KEY, note.getId());
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDITOR_REQUEST_CODE) {
            adapter.notifyDataSetChanged();
        }
    }
}