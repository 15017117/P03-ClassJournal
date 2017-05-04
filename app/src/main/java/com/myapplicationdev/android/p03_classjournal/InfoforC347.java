package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoforC347 extends AppCompatActivity {
    ListView lvMenu;
    ArrayAdapter aa;
    ArrayList<Weeks> week ;

    int requestCodeForAddData = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infofor_c347);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        getSupportActionBar().setTitle("Info for C347");

        lvMenu = (ListView)this.findViewById(R.id.lvMenu);
        Button btnEmail = (Button) findViewById(R.id.buttonEmail);
        Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        Button info = (Button) findViewById(R.id.buttonInfo);
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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoforC347.this, addData.class);
                i.putExtra("weekNo", (week.size()+1));
                startActivityForResult(i, requestCodeForAddData);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                // If it is activity started by clicking 				//  Superman, create corresponding String
                if (requestCode == requestCodeForAddData) {
                    week.add(new Weeks("Week " + (week.size()+1), grade));
                    aa = new WeeksAdapter(this,R.layout.row,week);
                    lvMenu.setAdapter(aa);
                }

            }
        }


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
