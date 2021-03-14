package com.example.students;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> students;
    public ItemAdapter(Context context, ArrayList<Student> students){
        this.context = context;this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_layout_item,parent,false);
        }
        Student currentStudent = (Student) getItem(position);
        TextView textViewItemName = (TextView)convertView.findViewById(R.id.item_name);
        textViewItemName.setText(currentStudent.studentName);
        TextView textViewItemClassification = (TextView)convertView.findViewById(R.id.item_group);
        textViewItemClassification.setText(currentStudent.studentPhone);
        return convertView;
    }
}
