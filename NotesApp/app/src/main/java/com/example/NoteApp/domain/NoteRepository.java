package com.example.NoteApp.domain;

import java.util.List;

public interface NoteRepository {

    List<NoteEntity> getNotes();

    NoteEntity findNote(int noteId);

    NoteEntity createNote();

    boolean updateNote(NoteEntity note);

    boolean removeNote(int noteId);

}
