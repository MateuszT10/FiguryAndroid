package com.example.mateusz.figuryandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ZmianaMinMax extends Activity implements OnClickListener {
    private EditText min;
    private EditText max;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zmianaminmax);
        min = (EditText) findViewById(R.id.min);
        max = (EditText) findViewById(R.id.max);
        button = (Button) findViewById(R.id.wroczminmax);
        button.setOnClickListener(this);
    }


    public void onClick(View V) {
        ArrayList<String> przekaz = new ArrayList<String>(2);
        przekaz.add(min.getText().toString());
        przekaz.add(max.getText().toString());
            if(Integer.parseInt(min.getText().toString()) > 100) {
                Toast(1);
            }
            else if(Integer.parseInt(max.getText().toString()) > 100) {
                Toast(2);
            }
            else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Toast();
                intent.putExtra("minmax", przekaz);
                startActivity(intent);
            }
    }
    private void Toast(){
        Context context = getApplicationContext();
        CharSequence text = String.format("Zakres cech od " + min.getText().toString() + " do " + max.getText().toString());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void Toast(int i){
        Context context = getApplicationContext();
        CharSequence text;
        if(i == 1)  text = String.format("Wartosc cechy minimalnej wieksza od 100 !!! ");
        else if (i == 2)  text = String.format("Wartosc cechy minimalnej wieksza od 100 !!! ");
        else text = String.format("Niemozliwy warunek");

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

