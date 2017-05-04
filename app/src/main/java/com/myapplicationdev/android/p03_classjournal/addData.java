package com.myapplicationdev.android.p03_classjournal;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.myapplicationdev.android.p03_classjournal.R.id.lvMenu;

public class addData extends AppCompatActivity {

    RadioGroup rg;
    Button btnSubmit;
    TextView tvWeeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        Intent i = getIntent();
        final int weekNo = i.getIntExtra("weekNo", 1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        getSupportActionBar().setTitle("Add Data for Week " + weekNo);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);
        tvWeeks = (TextView)findViewById(R.id.textViewWeeks);

        tvWeeks.setText("Week " + weekNo);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();



                if (selectedButtonId == R.id.radioButtonA) {
                    Intent i = new Intent();
                    i.putExtra("grade", "A");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);
                } else if (selectedButtonId == R.id.radioButtonB) {
                    Intent i = new Intent();
                    i.putExtra("grade", "B");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButtonC) {
                    Intent i = new Intent();
                    i.putExtra("grade", "C");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButtonD) {
                    Intent i = new Intent();
                    i.putExtra("grade", "D");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButtonE) {
                    Intent i = new Intent();
                    i.putExtra("grade", "E");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);

                } else if (selectedButtonId == R.id.radioButtonF) {
                    Intent i = new Intent();
                    i.putExtra("grade", "F");
                    // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                    setResult(RESULT_OK, i);
                }

                finish();
            }
        });


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
