package com.example.lesson6_lists.domain;

import java.util.List;
import java.util.UUID;

public interface NoteRepository {

    List<Note> getNotes();

    Note findNote(int noteId);

    Note createNote();

    boolean updateNote(Note note);

    boolean removeNote(UUID noteId);

}
