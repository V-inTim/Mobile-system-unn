package com.example.labwork_6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labwork_6.adapters.RectangleAdapter;
import com.example.labwork_6.models.RectangleModel;

import java.util.ArrayList;

public class RecCounterActivity extends AppCompatActivity {
    private ListView listView;
    private RectangleAdapter adapter;
    private ArrayList<RectangleModel> rectangleList;
    static int counter =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_counter_activity);

        listView = findViewById(R.id.listView);
        rectangleList = new ArrayList<>();
        adapter = new RectangleAdapter(this, rectangleList);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectangleList.add(new RectangleModel("#F57834",
                        "#000000",
                        Integer.toString(counter)));
                counter+=1;
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rectangleList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }


}
