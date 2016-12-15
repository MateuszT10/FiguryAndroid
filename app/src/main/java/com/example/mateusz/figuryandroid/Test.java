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


public class Test extends Activity implements OnClickListener {
    MainActivity mainklasa = new MainActivity();
    private EditText edit;
    private TextView tekst;
    private Button ok;
    private Button wyjdz;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
//        wyjdz = (Button)findViewById(R.id.wyjdz);
//        wyjdz.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);

    }
    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
//        wyjdz = (Button)findViewById(R.id.wyjdz);
//        wyjdz.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
//        wyjdz = (Button)findViewById(R.id.wyjdz);
//        wyjdz.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onPause() {
        super.onStart();
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
//        wyjdz = (Button)findViewById(R.id.wyjdz);
//        wyjdz.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onStop() {
        super.onStart();
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
//        wyjdz = (Button)findViewById(R.id.wyjdz);
//        wyjdz.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onDestroy() {
        super.onStart();
    }


    public void onClick(View v) {

        tekst.setText(edit.getText().toString());
//        mainklasa.setNFigur(edit); // przekazujemy wartosc do funkcji main activity
        String przekaz;
        przekaz=edit.getText().toString();
        Intent cel = new Intent(context, MainActivity.class);
        cel.putExtra("dane",przekaz);

        startActivity(cel);
        Toast();
        startActivity(new Intent(Test.this,MainActivity.class));
    }
    private void Toast(){
        Context context = getApplicationContext();
        CharSequence text = String.format("Liczba figur to " + edit.getText().toString());
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}