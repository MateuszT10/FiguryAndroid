package com.example.mateusz.figuryandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.Figura;
import com.example.Program;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Integer N = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Program program = new Program(); //obiekt klasy program
        utworzNFigur(7, program); // tworzenie figur
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
    }

    private void sortujPoPolu() {
    }

    private void sortujPoNazwie() {
    }

    private void zmienLiczbeGenerowanychFigur() {
    }

    private void statystyki() {
    }

    private List<String> tablicaStringow(List<Figura> tempFigury){ //zwraca tablice stringow do wyswietlania w gridzie
        List<String> tablicaStringow = new ArrayList<String>();
        for(int i=0; i<tempFigury.size(); i++){
            tablicaStringow.add(tempFigury.get(i).getFiguraString());
            tablicaStringow.add(tempFigury.get(i).getCechaString());
            tablicaStringow.add(tempFigury.get(i).getPoleString());
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
