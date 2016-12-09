package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com.example


/**
 * Created by Mateusz on 2016-11-11.
 */

public class Program {
   // Integer NFigur = 10; // liczba figur
    public Float sumaKwadratow = new Float(0); //suma pol kwadratow
    public Float sumaTrojkatow = new Float(0); // suma pol trojkatow
    public Float sumaKol = new Float(0); // suma pol kol

    public List<Figura> figury = new ArrayList<Figura>(); //Array List obiektow klasy Figura
    public List<String> jakaFigura = new ArrayList<String>(); // Array List obiektow jaka figura
    public List<String> polaFigur = new ArrayList<String>(); // Array List obiektow polaFigur
    public List<String> cechaFigur = new ArrayList<String>(); // Array List obiektow cechaFigur
//.....................................................................//

    public static void main(String[] args) {
        Program program = new Program(); // nowy obiekt klasy program

        program.addFigura(); // generowanie wartosci i figur
        program.wyswietlanie(5); // wyswietlanie figur w konsoli
    }

    public void  addFigura() {

        List<Integer> tablicaFigur = new ArrayList<Integer>();
        Random generator = new Random(); //obiekt klasy Random
            Integer nowaFigura = generator.nextInt(3);
            tablicaFigur.add(nowaFigura);// losujemy figure
            //0 to kwadrat, 1 to trojkat, 2 to kolo

        switch (nowaFigura) {
            case 0:
                figury.add(new Kwadrat(generator.nextFloat())); // tworzenie kwadratu
                sumaKwadratow += figury.get(i).getPole(); //sumowanie pol kwadratow
                jakaFigura.add("Kwadrat");
                polaFigur.add(String.format("%.3f",figury.get(i).pole));
                cechaFigur.add(String.format("przekatna\n%.3f",figury.get(i).przekatna));
                break;
            case 1:
                figury.add(new Trojkat(generator.nextFloat())); //tworzenie trojkata
                sumaTrojkatow += figury.get(i).getPole(); //sumowanie pol trojkatow
                jakaFigura.add("Trojkat");
                polaFigur.add(String.format("%.3f",figury.get(i).pole));
                cechaFigur.add(String.format("wysokosc\n%.3f",figury.get(i).wysokosc));
                break;
            case 2:
                figury.add(new Kolo(generator.nextFloat())); // tworzenie kola
                sumaKol += figury.get(i).getPole(); // sumowanie pol kol
                jakaFigura.add("Kolo");
                polaFigur.add(String.format("%.3f",figury.get(i).pole));
                cechaFigur.add(String.format("srednica\n%.3f",figury.get(i).srednica));
                break;
            default:
                break;
        }
    }


    private void wyswietlanie(Integer NFigur) { // wyswietlanie w konsoli
        for (int i = 0; i < NFigur; i++) {
            System.out.println(jakaFigura.get(i));
            System.out.println(polaFigur.get(i));
            System.out.println(cechaFigur.get(i));
        }
    }
}



