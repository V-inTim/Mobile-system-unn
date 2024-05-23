package com.example.labwork_6.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.labwork_6.R;
import com.example.labwork_6.models.CurrencyItem;

import java.util.ArrayList;

public class CurrencyItemAdapter extends ArrayAdapter<CurrencyItem> {
    private ArrayList<CurrencyItem> items;
    public CurrencyItemAdapter(@NonNull Context context, int resource, ArrayList<CurrencyItem> items) {
        super(context, resource, items);
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Получаем данные для этого пункта
        CurrencyItem item = getItem(position);

        // Проверяем, используется ли
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.xml.list_rec_object, parent, false);
        }

        // Находим TextView и устанавливаем цвета
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(item.getName() + ": " + item.getValue());

        return convertView;
    }
}
