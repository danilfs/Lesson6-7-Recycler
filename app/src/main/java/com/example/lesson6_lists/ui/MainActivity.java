package com.example.lesson6_lists.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lesson6_lists.R;
import com.example.lesson6_lists.data.SimpleNoteRepoImpl;
import com.example.lesson6_lists.domain.NoteRepo;

public class MainActivity extends AppCompatActivity {
    private NoteRepo noteRepo = new SimpleNoteRepoImpl();

    private NoteAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.activity_main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setData(noteRepo.getNotes());
    }
}