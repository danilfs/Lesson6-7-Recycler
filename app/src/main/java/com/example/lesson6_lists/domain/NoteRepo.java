package com.example.lesson6_lists.domain;

import java.util.List;

public interface NoteRepo {
    List<NoteEntity> getNotes();
}
