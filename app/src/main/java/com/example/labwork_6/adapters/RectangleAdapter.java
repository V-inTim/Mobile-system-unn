package com.example.labwork_6.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.labwork_6.R;
import com.example.labwork_6.models.RectangleModel;

import java.util.ArrayList;

public class RectangleAdapter extends ArrayAdapter<RectangleModel> {
    public RectangleAdapter(Context context, ArrayList<RectangleModel> rectangles) {
        super(context, 0, rectangles);
    }


    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Получаем данные для этого пункта
        RectangleModel rectangleModel = getItem(position);

        // Проверяем, используется ли
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.xml.list_rec_object, parent, false);
        }

        // Находим TextView и устанавливаем цвета
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setBackgroundColor(Color.parseColor(rectangleModel.getRectangleColor()));
        textView.setTextColor(Color.parseColor(rectangleModel.getTextColor()));
        textView.setText(rectangleModel.getText());

        return convertView;
    }
}

