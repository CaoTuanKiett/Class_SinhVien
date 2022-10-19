package com.example.androistudio_listview;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    TextView textViewTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Todo todo = (Todo) getIntent().getSerializableExtra("todo");
        Toast.makeText(this, todo.getDescription(), Toast.LENGTH_SHORT).show();
        textViewTitle = findViewById(R.id.textView7);
        textViewTitle.setText(todo.getTitle());
    }
}