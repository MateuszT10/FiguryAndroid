package com.example.mateusz.figuryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.Figura;
import com.example.Program;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Program program = new Program(); //obiekt klasy program na ktorym przechowujemy tablice figur
    Integer NFigur=7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        utworzNFigur(NFigur, program); // tworzenie figur
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // metoda odpowiedzialna za wyswietlanie menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.statystyki:
                statystyki();
                return true;
            case R.id.zmien_liczbe_generowanych_figur:
                zmienLiczbeGenerowanychFigur();
                return true;
            case R.id.sortuj_po_nazwie:
                sortujPoNazwie();
                return true;
            case R.id.sortuj_po_polu:
                sortujPoPolu();
                return true;
            case R.id.sortuj_po_cesze:
                sortujPoCesze();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sortujPoCesze() {
        program.sortujPoCesze();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));
    }

    private void sortujPoPolu() {
        program.sortujPoPolu();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));
    }

    private void sortujPoNazwie() {
        program.sortujpoNazwie();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));
    }

    private void zmienLiczbeGenerowanychFigur() {
        startActivity(new Intent(MainActivity.this,Pop.class));
    }

    public void setNFigur(EditText editText) { // ustawia ilosc figur do generacji
        NFigur = Integer.parseInt(editText.getText().toString());
    }

    private void statystyki() {
    }

    private List<String> tablicaStringow(List<Figura> tempFigury){ //zwraca tablice stringow do wyswietlania w gridzie
        List<String> tablicaStringow = new ArrayList<String>();
        for(int i=0; i< NFigur; i++){
            tablicaStringow.add(tempFigury.get(i).getFiguraString());
            tablicaStringow.add(tempFigury.get(i).getPoleString());
            tablicaStringow.add(tempFigury.get(i).getCechaString());
        }
        return tablicaStringow;
    }
    private void utworzNFigur(int N,Program temp){ // tworzy N Figur z zakresem wartosci cech od 0 do 1
        for(int i =0; i< N; i++)  temp.addFigura((float)0.0,(float)1.0);
    }
    private void utworzNFigur(int N,Program temp,float min,float max){ // tworzy N Figur z zakresem wartosci cech od min do max
        for(int i =0; i< N; i++) temp.addFigura(min , max);
    }

}
