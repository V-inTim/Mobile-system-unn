package com.example.labwork_6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DBNoteActivity extends AppCompatActivity {
    EditText editTextNote;
    Button buttonSave;
    ListView listViewNotes;
    ArrayAdapter<String> adapter;
    ArrayList<String> notes;
    DBHelper dbHelper;
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        editTextNote = findViewById(R.id.editTextNote);
        buttonSave = findViewById(R.id.buttonSave);
        listViewNotes = findViewById(R.id.listViewNotes);
        notes = new ArrayList<>();
        dbHelper = new DBHelper(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes);
        listViewNotes.setAdapter(adapter);
        refreshNotes();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editTextNote.getText().toString();
                if (!note.isEmpty()) {
                    dbHelper.addNote(note);
                    editTextNote.setText("");
                    refreshNotes();
                }
            }
        });

        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String note = adapter.getItem(position);
                dbHelper.deleteNote(note);
                refreshNotes();
            }
        });
    }


    private void refreshNotes() {
        notes.clear();
        notes.addAll(dbHelper.getAllNotes());
        adapter.notifyDataSetChanged();
    }
}
