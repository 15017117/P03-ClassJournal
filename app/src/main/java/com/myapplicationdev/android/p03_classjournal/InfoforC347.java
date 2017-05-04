package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoforC347 extends AppCompatActivity {
    ListView lvMenu;
    ArrayAdapter aa;
    ArrayList<Weeks> week ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infofor_c347);

        lvMenu = (ListView)this.findViewById(R.id.lvMenu);
        Intent i = getIntent();


        week = new ArrayList<Weeks>();
        week.add(new Weeks("week 1","B"));
        week.add(new Weeks("week 2","C"));
        week.add(new Weeks("week 3","A"));
        aa = new WeeksAdapter(this,R.layout.row,week);
        lvMenu.setAdapter(aa);


    }
}
