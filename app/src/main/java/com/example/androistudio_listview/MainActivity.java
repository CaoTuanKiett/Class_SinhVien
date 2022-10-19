package com.example.androistudio_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewTodos ;
    TextView textViewTitle , textViewDescription ;
    ArrayList<Todo> arrTodo;
    Adapter adapter;
    int indexTodo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTodos = findViewById(R.id.listTodo);
        textViewTitle = findViewById(R.id.editTextTextPersonName2);
        textViewDescription = findViewById(R.id.editTextTextPersonName3);
        arrTodo = new ArrayList<>();
        adapter = new Adapter(this , R.layout.item,arrTodo);
        listViewTodos.setAdapter(adapter);
        listViewTodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                indexTodo = i ;
                textViewTitle.setText(arrTodo.get(i).getTitle());
                textViewDescription.setText(arrTodo.get(i).getDescription());
            }
        });

    }

    public void resertValue(){
        textViewTitle.setText("");
        textViewDescription.setText("");
    }

    public void addTodo(View view){
        Todo newTodo = new Todo(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrTodo.add(newTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void updateTodo(View view){
        Todo newTodo = new Todo(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrTodo.set(indexTodo,newTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void deleteTodo(View view){
        arrTodo.remove(indexTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }
}