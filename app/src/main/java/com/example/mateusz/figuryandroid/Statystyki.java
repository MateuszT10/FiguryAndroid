package com.example.mateusz.figuryandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Program;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mateusz on 2016-12-15.
 */
public class Statystyki extends Activity implements OnClickListener {
    private Button wyjdz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.statystyki);
            ArrayList<String> tablica = (ArrayList<String>) getIntent().getSerializableExtra("tablica");

            GridView gridview = (GridView) findViewById(R.id.gridstatystyki);
            gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cellstat,tablica));

            wyjdz = (Button)findViewById(R.id.wroc);
            wyjdz.setOnClickListener(this);

    }

    public void onClick(View v) {
        startActivity(new Intent(Statystyki.this,MainActivity.class));
    }

}


