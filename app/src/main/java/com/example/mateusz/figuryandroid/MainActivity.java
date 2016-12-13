package com.example.mateusz.figuryandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.Figura;
import com.example.Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Integer N = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        Program program = new Program(); //obiekt klasy program
        utworzNFigur(7, program); // tworzenie figur
        tablicaStringow(program.tablicaFigur); // tablica stringow do wyswietlania w gridzie
        GridView gridview = (GridView) findViewById(R.id.gridview);

    }
    private List<String> tablicaStringow(List<Figura> tempFigury){ //zwraca tablice stringow do wyswietlania w gridzie
        List<String> tablicaStringow = new ArrayList<String>();
        for(int i=0; i<tempFigury.size();i++){
            tablicaStringow.add(tempFigury.get(i).getFiguraString());
            tablicaStringow.add(tempFigury.get(i).getCechaString());
            tablicaStringow.add(tempFigury.get(i).getPoleString());
        }
        return tablicaStringow;
    }
    private void utworzNFigur(int N,Program temp){ // tworzy N Figur z zakresem wartosci cech od 0 do 1
        for(int i =0; i<2;i++)  temp.addFigura((float)0.0,(float)1.0);
    }
    private void utworzNFigur(int N,Program temp,float min,float max){ // tworzy N Figur z zakresem wartosci cech od min do max
        for(int i =0; i<2;i++) temp.addFigura(min , max);
    }

}
