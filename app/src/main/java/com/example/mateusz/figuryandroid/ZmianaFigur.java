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


public class ZmianaFigur extends Activity implements OnClickListener {
    private EditText edit;
    private TextView tekst;
    private Button ok;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zmianafigur);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.zmianafigur);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.zmianafigur);
        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }

    public void onClick(View v) {
        tekst.setText(edit.getText().toString());
        String przekaz=edit.getText().toString();
        if((Integer.parseInt(przekaz) > 30) ||(Integer.parseInt(przekaz) < 1)){
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