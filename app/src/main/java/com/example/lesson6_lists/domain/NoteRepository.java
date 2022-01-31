package com.example.lesson6_lists.domain;

import java.util.List;

public interface NoteRepository {

    List<Note> getNotes();

    Note findNote(int noteId);

    Note createNote();

    boolean updateNote(Note note);

    boolean removeNote(int noteId);

}
