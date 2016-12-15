package com.example.mateusz.figuryandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.view.View.OnClickListener;



/**
 * Created by Mateusz on 2016-12-15.
 */
public class Statystyki extends Activity implements OnClickListener {
    private EditText edit;

    private Button pobierz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyki);

    }
    public void onClick(View v) {
        MainActivity temp = new MainActivity();
        temp.setNFigur(edit);
    }
}

