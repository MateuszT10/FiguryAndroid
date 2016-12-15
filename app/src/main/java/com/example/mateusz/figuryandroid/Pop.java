package com.example.mateusz.figuryandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.app.Activity;

import android.os.Bundle;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

/**
 * Created by Mateusz on 2016-12-15.
 */
public class Pop extends Activity implements OnClickListener {
    private EditText edit;

    private Button pobierz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .6), (int) (height * .4));

        //-------------Powyzej ustawiane jest wyswietlanie layoutu-------------------------------//

    }

    protected  void onResume() {
        super.onResume();
        edit = (EditText) findViewById(R.id.edittextilefigur);
        pobierz = (Button) findViewById(R.id.button);
        pobierz.setOnClickListener(this);
    }
    public void onClick(View v) {
        MainActivity temp = new MainActivity();
        temp.setNFigur(edit);
    }
}



//        final EditText liczba = (EditText) findViewById(R.id.ilefigur);
//        liczba.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                boolean handled = false;
//                MainActivity object = new MainActivity();
//                if (actionId == EditorInfo.IME_ACTION_SEND) {
//                    object.setNFigur(liczba);
//                    handled = true;
//                }
//                return handled;
//            }
//        });
//    }
//
//}
