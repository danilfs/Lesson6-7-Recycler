package com.example.lesson6_lists.domain;

import java.util.List;

public interface NoteRepo {

    List<NoteEntity> getNotes();

    NoteEntity findNote(int noteId);

    NoteEntity createNote();

    boolean updateNote(NoteEntity note);

    boolean removeNote(int noteId);

}