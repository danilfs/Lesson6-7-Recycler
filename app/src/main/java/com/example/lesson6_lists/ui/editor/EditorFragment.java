package com.example.lesson6_lists.ui.editor;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lesson6_lists.App;
import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.domain.NoteRepository;
import com.google.android.material.textfield.TextInputEditText;

public class EditorFragment extends Fragment {

    public static final String NOTE_ID_KEY = "note_id_key";

    private Note note;
    private NoteRepository repository;

    private TextInputEditText headerEditText;
    private TextInputEditText contentEditText;

    private Context context;
    private Controller controller;

    public interface Controller {
        void onNoteChanged(Note note);
    }

    public static EditorFragment getInstance(Note note) {
        EditorFragment fragment = new EditorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NOTE_ID_KEY, note.getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof Controller) {
            controller = (Controller) context;
        } else {
            throw new IllegalStateException("Activity must implement EditorFragment.Controller");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        updateNote();
        controller.onNoteChanged(note);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_editor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        repository = App.get(context).getNoteRepository();
        int noteId = getArguments().getInt(NOTE_ID_KEY, -1);
        note = repository.findNote(noteId);
        initView(view);
    }

    private void initView(View view) {
        headerEditText = view.findViewById(R.id.header_edit_text);
        contentEditText = view.findViewById(R.id.content_edit_text);
        if (note != null) {
            headerEditText.setText(note.getHeader());
            contentEditText.setText(note.getContent());
        }
    }


    private void updateNote() {
        note.setHeader(headerEditText.getText().toString());
        note.setContent(contentEditText.getText().toString());
        repository.updateNote(note);
    }
}
