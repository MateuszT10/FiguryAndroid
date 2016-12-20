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


public class ZmianaFigur extends Activity implements OnClickListener {
    private EditText edit;
    private TextView tekst;
    private Button ok;
    private ArrayList<String> minmax;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zmianafigur);

        edit = (EditText)findViewById(R.id.max);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.minText);
        minmax = (ArrayList<String>) getIntent().getSerializableExtra("minmax"); //odbior ustawionej wartosci min max

    }
    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.zmianafigur);

        edit = (EditText)findViewById(R.id.max);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.minText);
    }
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.zmianafigur);
        edit = (EditText)findViewById(R.id.max);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.minText);
    }

    public void onClick(View v) {
        tekst.setText(edit.getText().toString());
        ArrayList<String> przekaz = new ArrayList<String>(2);
        przekaz.add(edit.getText().toString());
        przekaz.add(minmax.get(0));
        przekaz.add(minmax.get(1));

        if((Integer.parseInt(przekaz.get(0)) > 30) ||(Integer.parseInt(przekaz.get(0)) < 1)){
           Toast(1);
        }
        else {
            Toast();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("dane", przekaz);
            startActivity(intent);
        }
    }
    private void Toast(){
        Context context = getApplicationContext();
        CharSequence text = String.format("Liczba figur to " + edit.getText().toString());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void Toast(int i){
        Context context = getApplicationContext();
        CharSequence text = String.format("Liczba większa od 0 i mniejsza od 30 !!! ");
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}