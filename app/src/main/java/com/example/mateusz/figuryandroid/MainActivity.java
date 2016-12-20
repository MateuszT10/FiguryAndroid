package com.example.mateusz.figuryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;

import com.example.Figura;
import com.example.Program;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    Program program = new Program(); //obiekt klasy program na ktorym przechowujemy tablice figur
    Integer NFigur=20;
    String przekazanytekst; //odbior danych do zmiany liczby generowanych figur
    ArrayList<String> minmax;
    Float min = (float)0;
    Float max = (float)1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lista);
            odbiorDanychZmienFigure();
            odbiorDanychMinMax();
            utworzNFigur(NFigur,program,min,max); // tworzenie figur
            grid();
    }

    private void odbiorDanychMinMax() {
        minmax = (ArrayList<String>) getIntent().getSerializableExtra("minmax");
        if(minmax != null) {
            min = Float.parseFloat(minmax.get(0));
            max= Float.parseFloat(minmax.get(1));
        }
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
            case R.id.zmien_min_max:
                zmienMinMax();
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

    private void zmienMinMax() {
        startActivity(new Intent(MainActivity.this,ZmianaMinMax.class));

    }

    private void sortujPoCesze() {
        program.sortujPoCesze();
        grid();
    }

    private void sortujPoPolu() {
        program.sortujPoPolu();
        grid();
    }

    private void sortujPoNazwie() {
        program.sortujpoNazwie();
        grid();
    }

    private void zmienLiczbeGenerowanychFigur() {
        startActivity(new Intent(MainActivity.this,ZmianaFigur.class));
    }

    public void setNFigur(EditText editText) { // ustawia ilosc figur do generacji
        NFigur = Integer.parseInt(editText.getText().toString());
        utworzNFigur(NFigur,program);
    }

    private void statystyki() {
        ArrayList<String> tablica = new ArrayList<String>();
        tablica.add(String.format(Integer.toString(program.liczbaKwadratow())));
        tablica.add(String.format("%.3f",(program.sumaPolKwadratow())));
        tablica.add(String.format("%.3f",(program.sumaPrzekatnychKwadratow())));

        tablica.add(String.format(Integer.toString(program.liczbaKol())));
        tablica.add(String.format("%.3f",(program.sumaPolKol())));
        tablica.add(String.format("%.3f",(program.sumaSrednicyKol())));

        tablica.add(String.format(Integer.toString(program.liczbaTrojkatow())));
        tablica.add(String.format("%.3f",(program.sumaPolTrojkatow())));
        tablica.add(String.format("%.3f",(program.sumaWysokosciTrojkatow())));

        Intent intent = new Intent(this, Statystyki.class);
        intent.putExtra("tablica", tablica);
        startActivity(intent);
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
    public void grid(){ // wyswietlanie siatki z elementami
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));
    }
    public void odbiorDanychZmienFigure(){
        przekazanytekst = getIntent().getStringExtra("dane");
        if(przekazanytekst != null) NFigur = Integer.parseInt(przekazanytekst);
    }
}
