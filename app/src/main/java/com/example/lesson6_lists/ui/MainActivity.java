package com.example.lesson6_lists.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.ui.editor.EditorFragment;
import com.example.lesson6_lists.ui.list.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.Controller, EditorFragment.Controller {

    private static final String EDITOR_BACK_STACK_NAME = "editor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_fragment_container, ListFragment.getInstance())
                    .commit();
        }
    }

    private void clearEditorFragmentContainer() {
        getSupportFragmentManager()
                .popBackStackImmediate(EDITOR_BACK_STACK_NAME, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onNoteSelected(Note note) {
        clearEditorFragmentContainer();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.editor_fragment_container, EditorFragment.getInstance(note))
                .addToBackStack(EDITOR_BACK_STACK_NAME)
                .commit();
    }

    @Override
    public void onNoteDeleted(Note note) {
        EditorFragment editorFragment = (EditorFragment) getSupportFragmentManager().findFragmentById(R.id.editor_fragment_container);
        if (editorFragment != null && editorFragment.getNote().getId() == note.getId()) {
            clearEditorFragmentContainer();
        }
    }

    @Override
    public void onNoteChanged(Note note) {
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.list_fragment_container);
        if (listFragment != null) {
            listFragment.notifyNoteChanged(note);
        }
    }
}