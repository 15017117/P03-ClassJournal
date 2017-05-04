package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button btnEmail = (Button) findViewById(R.id.buttonEmail);
        Intent i = getIntent();


        week = new ArrayList<Weeks>();
        week.add(new Weeks("week 1","B"));
        week.add(new Weeks("week 2","C"));
        week.add(new Weeks("week 3","A"));
        aa = new WeeksAdapter(this,R.layout.row,week);
        lvMenu.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                String weekSentence = "";
                for (int i=0; i < week.size(); i++) {
                    Weeks currentWeek = week.get(i);
                    weekSentence += "Week "+ currentWeek.getWeek() + ": DG: "+ currentWeek.getGrade() + "\n";
                    email.putExtra(Intent.EXTRA_TEXT, weekSentence);
                }

                email.setType("message/rcf822");
                startActivity(Intent.createChooser(email, "Choose an Email Client: "));


            }
        });




    }
}
