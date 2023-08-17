package com.myapplicationdev.databaserevision;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RetrieveActivityTextView extends AppCompatActivity {

    Button btnGetNotes;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_tv);

        btnGetNotes = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        btnGetNotes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(RetrieveActivityTextView.this);

                ArrayList<String> data = dbh.getNotesInStrings();
                dbh.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += (i+1) + ". " + data.get(i) + "\n";
                }
                tvResults.setText(txt);





            }
        });

    }
}