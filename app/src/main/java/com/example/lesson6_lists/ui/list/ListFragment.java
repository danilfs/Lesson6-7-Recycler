package com.example.lesson6_lists.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson6_lists.App;
import com.example.lesson6_lists.R;

import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.domain.NoteRepository;

import java.util.HashMap;
import java.util.Map;

public class ListFragment extends Fragment implements NoteViewHolder.Callbacks {

    private NoteRepository repository;
    private NoteAdapter adapter;
    private Context context;
    private Controller controller;
    private final Map<Integer, Integer> notePositionInRecycler = new HashMap<>();



    public interface Controller {
        void onNoteSelected(Note note);
    }

    public static ListFragment getInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof Controller) {
            controller = (Controller) context;
        } else {
            throw new IllegalStateException("Activity must implement ListFragment.Controller");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository = App.get(context).getNoteRepository();
        initView(view);
    }

    private void initView(View view) {
        initRecycler(view);
        view.findViewById(R.id.add_note_button).setOnClickListener(this::onClickAddNoteButton);
    }

    private void initRecycler(View view) {
        RecyclerView noteRecyclerView = view.findViewById(R.id.note_recycler_view);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new NoteAdapter(repository.getNotes(), this);
        noteRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBindItem(Note note, int position) {
        notePositionInRecycler.put(note.getId(), position);
    }

    @Override
    public void onClickItem(Note note) {
        controller.onNoteSelected(note);
    }

    @Override
    public boolean onLongClickItem(Note note) {
        if (repository.removeNote(note.getId())) {
            int position = positionOf(note);
            adapter.notifyItemRemoved(position);
            adapter.notifyItemRangeChanged(position, adapter.getItemCount() - position);
            return true;
        }
        return false;
    }

    private void onClickAddNoteButton(View view) {
        Note note = repository.createNote();
        controller.onNoteSelected(note);
    }

    private int positionOf(Note note) {
        Integer position = notePositionInRecycler.get(note.getId());
        return (position != null) ? position : adapter.getItemCount();
    }

    public void notifyNoteChanged(Note note) {
        int position = positionOf(note);
        adapter.notifyItemChanged(position);
    }

}
