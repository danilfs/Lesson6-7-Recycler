package com.example.lesson6_lists.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private final NoteViewHolder.Callbacks callbacks;
    private List<Note> notes;

    public NoteAdapter(NoteViewHolder.Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView, callbacks);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(notes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}