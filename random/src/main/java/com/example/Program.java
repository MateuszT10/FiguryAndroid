package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com.example


/**
 * Created by Mateusz on 2016-11-11.
 */

public class Program {

    public Float sumaKwadratow = new Float(0); //suma pol kwadratow
    public Float sumaTrojkatow = new Float(0); // suma pol trojkatow
    public Float sumaKol = new Float(0); // suma pol kol

    public List<Figura> figury = new ArrayList<Figura>(); //Array List obiektow klasy Figura
//.....................................................................//

    public static void main(String[] args) {
        Program program = new Program(); // nowy obiekt klasy program
        for(int i=0; i<10; i++){
            program.addFigura(); // dodawanie nowej figury
        }
        program.wyswietlanie(); // wyswietlanie figur w konsoli
    }

    public void  addFigura() {

        Random generator = new Random(); //obiekt klasy Random
            Integer nowaFigura = generator.nextInt(3);
            //0 to kwadrat, 1 to trojkat, 2 to kolo

        switch (nowaFigura) {
            case 0:
                figury.add(new Kwadrat(generator.nextFloat())); // tworzenie kwadratu
                sumaKwadratow += figury.get(figury.size()-1).getPole(); //sumowanie pol kwadratow
                break;
            case 1:
                figury.add(new Trojkat(generator.nextFloat())); //tworzenie trojkata
                sumaTrojkatow += figury.get(figury.size()-1).getPole(); //sumowanie pol trojkatow
                break;
            case 2:
                figury.add(new Kolo(generator.nextFloat())); // tworzenie kola
                sumaKol += figury.get(figury.size()-1).getPole(); // sumowanie pol kol
                break;
            default:
                break;
        }
    }


    private void wyswietlanie() { // wyswietlanie w konsoli
        for(int i = 0; i < figury.size();i++){
            System.out.println(figury.get(i).jakaFiguraString());
            System.out.println(figury.get(i).getCechaString());
            System.out.println(figury.get(i).getPoleString());
        }
        System.out.println("Suma kol " + sumaKol);
        System.out.println("Suma kwadratow " + sumaKwadratow);
        System.out.println("Suma trojkatow " + sumaTrojkatow);
        System.out.println("Ilosc figur " + figury.size());
    }
}



