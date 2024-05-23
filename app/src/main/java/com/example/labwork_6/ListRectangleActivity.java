package com.example.labwork_6;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.labwork_6.adapters.RectangleAdapter;
import com.example.labwork_6.models.RectangleModel;

import java.util.ArrayList;

public class ListRectangleActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_rectangle_activity);

            // Создаем список моделей
            ArrayList<RectangleModel> arrayOfRectangles = new ArrayList<>();
            arrayOfRectangles.add(new RectangleModel("#FF0000", "#FFFFFF", "Красный")); // Красный с белым текстом
            arrayOfRectangles.add(new RectangleModel("#00FF00", "#000000", "Зеленый")); // Зеленый с черным текстом

            RectangleAdapter adapter = new RectangleAdapter(this, arrayOfRectangles);

            ListView listView = (ListView) findViewById(R.id.list_view_id);
            listView.setAdapter(adapter);
        }

}
