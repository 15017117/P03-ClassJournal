package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017117 on 4/5/2017.
 */

public class WeeksAdapter extends ArrayAdapter<Weeks> {
    private ArrayList<Weeks> week;
    private Context context;
    private TextView tvWeeks;
    private TextView tvGrades;
    public WeeksAdapter(Context context, int resource, ArrayList<Weeks> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        week = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeeks = (TextView) rowView.findViewById(R.id.textViewWeeks);
        tvGrades = (TextView) rowView.findViewById(R.id.textViewGrade);

        Weeks currentWeek = week.get(position);
        // Set the TextView to show the food

        tvWeeks.setText(currentWeek.getWeek());
        tvGrades.setText(currentWeek.getGrade());
        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }


}