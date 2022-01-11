package com.example.lesson6_lists.data;

import com.example.lesson6_lists.domain.NoteEntity;
import com.example.lesson6_lists.domain.NoteRepo;

import java.util.ArrayList;
import java.util.List;

public class SimpleNoteRepoImpl implements NoteRepo {

    private final List<NoteEntity> notes = new ArrayList<>(notesList());

    @Override
    public List<NoteEntity> getNotes() {
        return notes;
    }

    private static List<NoteEntity> notesList() {
    List<NoteEntity> list = new ArrayList<>();
    list.add(new NoteEntity(0,"вещи", "вещи"));
    return list;
    }
}
