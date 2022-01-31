package com.example.lesson6_lists.ui.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lesson6_lists.R;
import com.example.lesson6_lists.domain.Note;


public class NoteViewHolder extends RecyclerView.ViewHolder {

    interface Callbacks {
        void onBindItem(Note note, int position);
        void onClickItem(Note note);
        boolean onLongClickItem(Note note, View item);
    }

    private final Callbacks callbacks;
    private final TextView headerTextView = itemView.findViewById(R.id.header_text_view);
    private final TextView contentTextView = itemView.findViewById(R.id.content_text_view);

    public NoteViewHolder(@NonNull View itemView, Callbacks callbacks) {
        super(itemView);
        this.callbacks = callbacks;
    }

    public void bind(Note note, int position) {
        headerTextView.setText(note.getHeader());
        contentTextView.setText(note.getContent());

        if (callbacks != null) {
            callbacks.onBindItem(note, position);
            itemView.setOnClickListener(view -> callbacks.onClickItem(note));
            itemView.setOnLongClickListener(view -> callbacks.onLongClickItem(note, itemView));
        }
    }
}
