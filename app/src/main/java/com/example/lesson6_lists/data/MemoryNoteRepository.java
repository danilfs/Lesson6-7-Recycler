package com.example.lesson6_lists.data;

import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.domain.NoteRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryNoteRepository implements NoteRepository {

    private static int currentId = 0;
    private final List<Note> notes = new ArrayList<>(sampleNoteList());

    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public Note createNote() {
        Note note = new Note(++currentId);
        notes.add(note);
        return note;
    }

    @Override
    public boolean updateNote(Note note) {
        return true; 
    }

    @Override
    public Note findNote(int noteId) {
        int index = indexOf(noteId);
        if (index == -1) {
            return null;
        }
        return notes.get(index);
    }

    @Override
    public boolean removeNote(int noteId) {
        int index = indexOf(noteId);
        if (index == -1) {
            return false;
        }
        notes.remove(index);
        return true;
    }

    private int indexOf(int noteId) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == noteId) {
                return i;
            }
        }
        return -1;
    }

    private static List<Note> sampleNoteList() {
        List<Note> list = new ArrayList<>();

        list.add(new Note(++currentId, "Вещи", "Вещи"));
        list.add(new Note(++currentId, "настроить комп", "123"));
        return list;
    }

}
