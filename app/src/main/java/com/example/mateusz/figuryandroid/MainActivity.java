package com.example.mateusz.figuryandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.Figura;
import com.example.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    Program program = new Program(); //obiekt klasy program na ktorym przechowujemy tablice figur
    Integer NFigur=20;
    ArrayList<String> zmianafigur; //odbior danych do zmiany liczby generowanych figur
    int position; //kliknieta pozycja na gridview
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

    public void odbiorDanychMinMax() {
        minmax = (ArrayList<String>) getIntent().getSerializableExtra("minmax");
        if(minmax != null) {
            min = Float.parseFloat(minmax.get(0));
            max= Float.parseFloat(minmax.get(1));
            NFigur= Integer.parseInt(minmax.get(2));
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
        String NFigurString = NFigur.toString();
        Intent intent = new Intent(getApplicationContext(), ZmianaMinMax.class);
        intent.putExtra("NFigur", NFigurString);
        startActivity(intent);

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
        ArrayList<String> przekaz = new ArrayList<String>(3);
        przekaz.add(min.toString()); //przekaz wartosc min do aktywnosci
        przekaz.add(max.toString()); //przekaz wartosc max do aktywnosci

        Intent intent = new Intent(getApplicationContext(), ZmianaFigur.class);
        intent.putExtra("minmax", przekaz);
        startActivity(intent);
    }

    public void setNFigur(EditText editText) { // ustawia ilosc figur do generacji
        NFigur = Integer.parseInt(editText.getText().toString());
        utworzNFigur(NFigur,program);
    }

    private void statystyki() {
        ArrayList<String> tablica = new ArrayList<String>();
        tablica.add(String.format(Integer.toString(program.liczbaKwadratow())));
        tablica.add(String.format(Integer.toString(program.liczbaTrojkatow())));
        tablica.add(String.format(Integer.toString(program.liczbaKol())));

        tablica.add(String.format("%.3f",(program.sumaPrzekatnychKwadratow())));
        tablica.add(String.format("%.3f",(program.sumaWysokosciTrojkatow())));
        tablica.add(String.format("%.3f",(program.sumaSrednicyKol())));

        tablica.add(String.format("%.3f",(program.sumaPolKwadratow())));
        tablica.add(String.format("%.3f",(program.sumaPolTrojkatow())));
        tablica.add(String.format("%.3f",(program.sumaPolKol())));


        Intent intent = new Intent(this, Statystyki.class);
        intent.putExtra("tablica", tablica);
        startActivity(intent);
    }

    private List<String> tablicaStringow(List<Figura> tempFigury){ //zwraca tablice stringow do wyswietlania w gridzie
        List<String> tablicaStringow = new ArrayList<String>();
        for(int i=0; i< program.tablicaFigur.size(); i++){
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
        registerForContextMenu(gridview); //dla menu kontekstowego
        gridview.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,tablicaStringow(program.tablicaFigur)));
    }
    public void odbiorDanychZmienFigure(){
        zmianafigur = (ArrayList<String>) getIntent().getSerializableExtra("dane");
        if(zmianafigur != null) {
            NFigur = Integer.parseInt(zmianafigur.get(0));
            min = Float.parseFloat(zmianafigur.get(1));
            max = Float.parseFloat(zmianafigur.get(2));
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, v.getId(), 0, "Duplikuj");
        menu.add(0, v.getId(), 0, "Dodaj losową figurę");
        menu.add(0, v.getId(), 0, "Usuń wszystkie figury");

        GridView gv = (GridView) v;
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        position = info.position; //kliknieta pozycja
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Duplikuj"){duplikujWierszGrida(item.getItemId());}
        else if(item.getTitle()=="Dodaj losową figurę"){dodajLosowa(item.getItemId());}
        else if(item.getTitle()=="Usuń wszystkie figury"){usunWszystkie(item.getItemId());}
        else {return false;}
        return true;
    }

    public void dodajLosowa(int id){
        Toast.makeText(this, "Dodaj losową figurę", Toast.LENGTH_SHORT).show();

        program.addFigura(min,max);
        grid();
    }
    public void usunWszystkie(int id){
        Toast.makeText(this, "Usuń wszystkie figury", Toast.LENGTH_SHORT).show();

        program.tablicaFigur.clear();
        grid();
    }
    private void duplikujWierszGrida(int id) {
        Toast.makeText(this, "Duplikuj", Toast.LENGTH_SHORT).show();

        int wiersz = position/3; // zwraca wartosc wiersza
        program.tablicaFigur.add(program.tablicaFigur.get(wiersz));
        grid();
    }

}


