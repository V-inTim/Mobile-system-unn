package com.example.labwork_6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.labwork_6.R;

public class PrefActivity extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;
    private Button saveButton;

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String KEY_TEXT = "text";
    private static final String KEY_CHECKBOX = "checkbox";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref_activity);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
        saveButton = findViewById(R.id.saveButton);

        loadPreferences();

        saveButton.setOnClickListener(v -> savePreferences());
    }

    private void loadPreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String text = settings.getString(KEY_TEXT, "");
        boolean isChecked = settings.getBoolean(KEY_CHECKBOX, false);

        editText.setText(text);
        checkBox.setChecked(isChecked);
    }

    private void savePreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString(KEY_TEXT, editText.getText().toString());
        editor.putBoolean(KEY_CHECKBOX, checkBox.isChecked());

        editor.apply();
    }
}