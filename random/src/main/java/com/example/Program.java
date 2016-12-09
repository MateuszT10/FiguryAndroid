package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com.example


/**
 * Created by Mateusz on 2016-11-11.
 */

public class Program {

    public List<Figura> figury = new ArrayList<Figura>(); //Array List obiektow klasy Figura
//.....................................................................//

    public static void main(String[] args) { // testowanie
        Program program = new Program(); // nowy obiekt klasy program
        for(int i=0; i<10; i++){
            program.addFigura(); // dodawanie nowej figury
        }
        program.wyswietlanie(); // wyswietlanie figur w konsoli
    }

    public void addFigura() {

        Random generator = new Random(); //obiekt klasy Random
            Integer nowaFigura = generator.nextInt(3);
            //0 to kwadrat, 1 to trojkat, 2 to kolo

        switch (nowaFigura) {
            case 0:
                figury.add(new Kwadrat(MinMax((float)3,(float)5,generator.nextFloat()))); // tworzenie kwadratu
                break;
            case 1:
                figury.add(new Trojkat(MinMax((float)3,(float)5,generator.nextFloat()))); //tworzenie trojkata
                break;
            case 2:
                figury.add(new Kolo(MinMax((float)3,(float)5,generator.nextFloat()))); // tworzenie kola
                break;
            default:
                break;
        }
    }
    public Float MinMax(float min, float max, float random){ // zwraca liczbe randomowa z przedzialu min max
        return (max-min) * random + min;
    }
    public void deleteFigura(int index){ // kasujemy figure o danym indeksie
        figury.remove(index);
    }
    public Float sumaKwadratow(){ // zwraca sume pol Kwadratow
        float sumaKwadratow = 0;
        for(int i=0; i< figury.size();i++)
             sumaKwadratow += figury.get(figury.size()-1).getPole(); //sumowanie pol kwadratow
        return sumaKwadratow;
    }
    public Float sumaTrojkatow(){ // zwraca sume pol Trojkatow
        float sumaTrojkatow = 0;
        for(int i=0; i< figury.size();i++)
             sumaTrojkatow += figury.get(figury.size()-1).getPole(); //sumowanie pol trojkatow
        return sumaTrojkatow;
    }
    public Float sumaKol(){ // zwraca sume pol Kol
        float sumaKol = 0;
        for(int i=0; i< figury.size();i++)
             sumaKol += figury.get(figury.size()-1).getPole(); // sumowanie pol kol
        return sumaKol;
    }
    public int liczbaKwadratow(){ // zwraca liczbe kwadratow...
        int temp = 0;
        for(int i=0;i<figury.size();i++){
            if(figury.get(i).jakaFiguraString() == "Kwadrat")
                temp++;
        }
        return temp;
    }


    private void wyswietlanie() { // wyswietlanie w konsoli
        for(int i = 0; i < figury.size();i++){
            System.out.println(figury.get(i).jakaFiguraString());
            System.out.println(figury.get(i).getCechaString());
            System.out.println(figury.get(i).getPoleString());
        }
        System.out.println("Suma kol " + sumaKol());
        System.out.println("Suma kwadratow " + sumaKwadratow());
        System.out.println("Suma trojkatow " + sumaTrojkatow());
        System.out.println("Ilosc figur " + figury.size());
    }
}



