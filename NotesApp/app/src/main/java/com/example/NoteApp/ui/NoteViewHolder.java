package com.example.NoteApp.ui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.NoteApp.R;
import com.example.NoteApp.domain.NoteEntity;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    interface Callbacks {
        void onNoteSelected(int noteId, int position);

        boolean onNoteRemove(int noteId, int position);
    }

    private final Callbacks callbacks;
    private final View circleView = itemView.findViewById(R.id.circle_view);
    private final TextView headerTextView = itemView.findViewById(R.id.header_text_view);
    private final TextView contentTextView = itemView.findViewById(R.id.content_text_view);

    public NoteViewHolder(@NonNull View itemView, Callbacks callbacks) {
        super(itemView);
        this.callbacks = callbacks;
    }

    public void bind(NoteEntity note, int position) {
        headerTextView.setText(note.getHeader());
        contentTextView.setText(note.getContent());

        if (callbacks != null) {
            itemView.setOnClickListener(view -> callbacks.onNoteSelected(note.getId(), position));
            itemView.setOnLongClickListener(view -> callbacks.onNoteRemove(note.getId(), position));
        }
    }
}
