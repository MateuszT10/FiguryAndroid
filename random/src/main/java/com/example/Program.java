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
        for(int i=0; i<5; i++){
            program.addFigura((float )4.0, (float)7.0); // dodawanie nowej figury
        }
        program.wyswietlanie(); // wyswietlanie figur w konsoli
    }
    private float generujCeche(){// metoda generujaca
        Random generator = new Random(); //obiekt klasy Random
        return generator.nextFloat();
    }
    private Integer generujFigure(){// metoda generujaca
        Random generator = new Random(); //obiekt klasy Random
        return generator.nextInt(3);
    }
    public void addFigura(float min,float max) {
            Integer nowaFigura = generujFigure();
            //0 to kwadrat, 1 to trojkat, 2 to kolo

        switch (nowaFigura) {
            case 0:
                figury.add(new Kwadrat(minMax(min,max,generujCeche()))); // tworzenie kwadratu
                break;
            case 1:
                figury.add(new Trojkat(minMax(min,max,generujCeche()))); //tworzenie trojkata
                break;
            case 2:
                figury.add(new Kolo(minMax(min,max,generujCeche()))); // tworzenie kola
                break;
            default:
                break;
        }
    }
    public Float minMax(float min, float max, float random){ // zwraca liczbe randomowa z przedzialu min max
        return (max-min) * random + min;
    }
    public void deleteFigura(int index){ // kasujemy figure o danym indeksie
        figury.remove(index);
    }
    public Float sumaPolKwadratow(){ // zwraca sume pol Kwadratow
        float sumaKwadratow = 0;
        for(int i=0; i< figury.size();i++)
            if(figury.get(i).jakaFiguraString().equals("Kwadrat"))
             sumaKwadratow += figury.get(figury.size()-1).getPole(); //sumowanie pol kwadratow
        return sumaKwadratow;
    }
    public Float sumaPolTrojkatow(){ // zwraca sume pol Trojkatow
        float sumaTrojkatow = 0;
            for(int i=0; i< figury.size();i++)
                if(figury.get(i).jakaFiguraString().equals("Trojkat"))
                    sumaTrojkatow += figury.get(figury.size()-1).getPole(); //sumowanie pol trojkatow
        return sumaTrojkatow;
    }
    public Float sumaPolKol(){ // zwraca sume pol Kol
        float sumaKol = 0;
        for(int i=0; i< figury.size();i++)
            if(figury.get(i).jakaFiguraString().equals("Kolo"))
                sumaKol += figury.get(figury.size()-1).getPole(); // sumowanie pol kol
        return sumaKol;
    }
    public Float sumaPrzekatnychKwadratow(){ // zwraca sume pol Kwadratow
        float sumaKwadratow = 0;
        for(int i=0; i< figury.size();i++)
            if(figury.get(i).jakaFiguraString().equals("Kwadrat"))
                sumaKwadratow += figury.get(figury.size()-1).getCecha(); //sumowanie pol kwadratow
        return sumaKwadratow;
    }
    public Float sumaWysokosciTrojkatow(){ // zwraca sume pol Trojkatow
        float sumaTrojkatow = 0;
        for(int i=0; i< figury.size();i++)
            if(figury.get(i).jakaFiguraString().equals("Trojkat"))
                sumaTrojkatow += figury.get(figury.size()-1).getCecha(); //sumowanie pol trojkatow
        return sumaTrojkatow;
    }
    public Float sumaSrednicyKol(){ // zwraca sume pol Kol
        float sumaKol = 0;
        for(int i=0; i< figury.size();i++)
            if(figury.get(i).jakaFiguraString().equals("Kolo"))
                sumaKol += figury.get(figury.size()-1).getCecha(); // sumowanie pol kol
        return sumaKol;
    }
    public int liczbaKwadratow(){ // zwraca liczbe kwadratow...
        int temp = 0;
        for(int i=0;i<figury.size();i++){
            if(figury.get(i).jakaFiguraString().equals("Kwadrat")) {
                temp++;
            }
        }
        return temp;
    }
    public int liczbaTrojkatow() { // zwraca liczbe kwadratow...
        int temp = 0;
        for (int i = 0; i < figury.size(); i++) {
            if (figury.get(i).jakaFiguraString().equals("Trojkat"))
                temp++;
        }
        return temp;
    }
    public int liczbaKol(){ // zwraca liczbe kwadratow...
        int temp = 0;
        for(int i=0;i<figury.size();i++){
            if(figury.get(i).jakaFiguraString().equals("Kolo"))
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
        System.out.println("Suma kol " + sumaPolKol());
        System.out.println("Suma kwadratow " + sumaPolKwadratow());
        System.out.println("Suma trojkatow " + sumaPolTrojkatow());
        System.out.println("Suma srednic kol " + sumaSrednicyKol());
        System.out.println("Suma przekatnych kwadratow " + sumaPrzekatnychKwadratow());
        System.out.println("Suma wysokosci trojkatow " + sumaWysokosciTrojkatow());
        System.out.println("Liczba kol " + liczbaKol());
        System.out.println("Liczba kwadratow " + liczbaKwadratow());
        System.out.println("Liczba trojkatow " + liczbaTrojkatow());
        System.out.println("Liczba figur " + figury.size());
    }
}



