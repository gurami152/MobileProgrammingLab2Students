package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null || !savedInstanceState.containsKey("list")){
            students = new ArrayList<Student>();
        }
        else {
            students = savedInstanceState.getParcelableArrayList("list");
        }
        ListView listItem = (ListView) findViewById(R.id.listItems);
        ItemAdapter adapter = new ItemAdapter(this, students);
        listItem.setAdapter(adapter);

        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                intent.putExtra("index",position);
                intent.putExtra("item", students.get(position));
                startActivityForResult(intent,0);
            }
        });

        View fab = (View)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int index = data.getIntExtra("index", -1 );
            Student student = (Student) data.getParcelableExtra("item");
            if(index != -1){
                students.set(index, student);
            }
            else{
                students.add(student);
                ListView listView = (ListView) findViewById(R.id.listItems);
                ItemAdapter adapter = new ItemAdapter(this, students);
                listView.setAdapter(adapter);adapter.notifyDataSetChanged();
            }
        }
        else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list", students);
    }
}