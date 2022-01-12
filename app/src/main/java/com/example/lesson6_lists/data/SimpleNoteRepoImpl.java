package com.example.lesson6_lists.data;

import com.example.lesson6_lists.domain.NoteEntity;
import com.example.lesson6_lists.domain.NoteRepo;

import java.util.ArrayList;
import java.util.List;

public class SimpleNoteRepoImpl implements NoteRepo {

    private static int currentId = 0;
    private final List<NoteEntity> notes = new ArrayList<>(sampleNoteList());

    @Override
    public List<NoteEntity> getNotes() {
        return notes;
    }

    @Override
    public NoteEntity createNote() {
        NoteEntity note = new NoteEntity(++currentId);
        notes.add(note);
        return note;
    }

    @Override
    public boolean updateNote(NoteEntity note) {
        return true;
    }

    @Override
    public NoteEntity findNote(int noteId) {
        for (NoteEntity note : notes) {
            if (note.getId() == noteId) {
                return note;
            }
        }
        return null;
    }

    @Override
    public boolean removeNote(int noteId) {
        NoteEntity note = findNote(noteId);
        if (note != null) {
            notes.remove(note);
            return true;
        } else {
            return false;
        }
    }

    private static List<NoteEntity> sampleNoteList() {
        List<NoteEntity> list = new ArrayList<>();

        list.add(new NoteEntity(++currentId, "Вещи", "Вещи"));
        list.add(new NoteEntity(++currentId, "настроить комп", "123"));
        return list;
    }

}