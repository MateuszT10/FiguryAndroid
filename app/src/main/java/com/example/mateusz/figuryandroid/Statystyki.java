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
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.statystyki);
            ArrayList<String> tablica = (ArrayList<String>) getIntent().getSerializableExtra("tablica");

        t=new TextView(this);

        t=(TextView)findViewById(R.id.ileKwadratow);
        t.setText("1");

        t=(TextView)findViewById(R.id.ileTrojkatow);
        t.setText("2");

        t=(TextView)findViewById(R.id.ileKol);
        t.setText("3");

        t=(TextView)findViewById(R.id.sumaPolKwadratow);
        t.setText("4");

        t=(TextView)findViewById(R.id.sumaPolTrojkatow);
        t.setText("5");

        t=(TextView)findViewById(R.id.sumaPolKol);
        t.setText("6");

        t=(TextView)findViewById(R.id.sumaCechKwadratow);
        t.setText("7");

        t=(TextView)findViewById(R.id.sumaCechTrojkatow);
        t.setText("8");

        t=(TextView)findViewById(R.id.sumaCechKol);
        t.setText("9");

            wyjdz = (Button)findViewById(R.id.wrocStatystyki);
            wyjdz.setOnClickListener(this);

    }

    public void onClick(View v) {
        startActivity(new Intent(Statystyki.this,MainActivity.class));
    }

}


