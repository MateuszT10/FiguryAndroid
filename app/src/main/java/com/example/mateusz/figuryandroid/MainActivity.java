package com.example.mateusz.figuryandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;

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
        program.setN(N); // przekazujemy ilosc generowanych figur
        String[] ala = {"Ala","ma","kota"};
        program.main(ala); //wywolanie main z modulu java


//        String[] stringi= new String[45]; // lista wszystkich figur wraz z cechami i polami
//                                          // zaadaptowana do wyswietlania w grid
//
//        for(int i = 0; i< 45; i++ ){
//            int nWiersz = i % 3;
//            int nKolumna = i / 3;
//                switch(nWiersz) {
//                    case 0:
//                        stringi[i] = program.jakaFigura.get();
//                        break;
//                    case 1:
//                        stringi[i] = program.polaFigur[nKolumna];
//                        break;
//                    case 2:
//                        stringi[i] = program.cechaFigur[nKolumna];
//                        break;
//                    default:
//                        break;
//                }
//        }
//        List<String> values=new ArrayList<String>(Arrays.asList(stringi));
//
//
//        GridView myGrid=(GridView)findViewById(R.id.grid);
//
//        myGrid.setAdapter(new ArrayAdapter<String>(this,R.layout.cell,values));

    }
}
