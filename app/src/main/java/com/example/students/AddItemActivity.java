package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputLayout;

public class AddItemActivity extends AppCompatActivity {

    private int index = 0;
    private Student student;
    private TextInputLayout item_title_name;
    private TextInputLayout item_title_class;
    private TextInputLayout item_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        index = intent.getIntExtra("index",-1);
        Log.d("asd", String.valueOf(index));
        if(index != -1){
            student = (Student) intent.getParcelableExtra("item");
            item_title_name = (TextInputLayout) findViewById(R.id.item_title_name);
            item_title_name.getEditText().setText(student.studentName);
            item_title_class = (TextInputLayout) findViewById(R.id.item_title_class);
            item_title_class.getEditText().setText(student.studentPhone);
            item_size = (TextInputLayout) findViewById(R.id.item_size);
            item_size.getEditText().setText(student.studentEmail);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itemMenu){
        if (itemMenu.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        if (itemMenu.getItemId() == R.id.action_save) {
            student = new Student();
            student.studentName = ((TextInputLayout)findViewById(R.id.item_title_name)).getEditText().getText().toString();
            student.studentPhone = ((TextInputLayout)findViewById(R.id.item_title_class)).getEditText().getText().toString();
            student.studentEmail = ((TextInputLayout)findViewById(R.id.item_size)).getEditText().getText().toString();
            Intent intent = new Intent();
            intent.putExtra("index", index);

            intent.putExtra("item", student);
            setResult(Activity.RESULT_OK,intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(itemMenu);
    }
}