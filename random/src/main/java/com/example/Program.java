package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import com.example


/**
 * Created by Mateusz on 2016-11-11.
 */

public class Program {
    Float sumaKwadratow = new Float(0); //suma pol kwadratow
    Float sumaTrojkatow = new Float(0); // suma pol trojkatow
    Float sumaKol = new Float(0); // suma pol kol

    Integer N = 15; // liczba figur
    //Figura[] figury = new Figura[N]; //tablica N figur
    List<Figura> figury = new ArrayList<Figura>(); //Array list obiektow klasy Figura
    public static String[] sFigury = new String[15];
    public static String[] jakaFigura = new String[15];
    public static String[] polaFigur = new String[15];
    public static String[] cechaFigur = new String[15];
//.....................................................................//

    public static void main(String[] args) {
        Program program = new Program(); // nowy obiekt klasy program

        program.generator(); // generowanie wartosci i figur
        program.wyswietlanie(); // wyswietlanie figur
    }

    void  generator() {

        List<Integer> tablicaFigur = new ArrayList<Integer>();
        Random generator = new Random(); //obiekt klasy Random

        for (int i = 0; i < N ; i++) {
            tablicaFigur.add(generator.nextInt(3));// losujemy figury
            //0 to kwadrat, 1 to trojkat, 2 to kolo
        }

        for (int i = 0; i < N; i++) {
            switch (tablicaFigur.get(i)) {
                case 0:
                    figury.add(new Kwadrat(generator.nextFloat())); // tworzenie kwadratu
                   // sumaKwadratow += figury.get(figury.getPole()); //sumowanie pol kwadratow
                    jakaFigura[i] = "Kwadrat";
                 //   polaFigur[i] = String.format("%.3f",figury[i].pole);
                  // cechaFigur[i] = String.format("przekatna\n%.3f",figury[i].przekatna);
                    break;
                case 1:
                 //   figury[i] = new Trojkat(generator.nextFloat()); //tworzenie trojkata
                 //   sumaTrojkatow += figury[i].getPole(); //sumowanie pol trojkatow
                    jakaFigura[i] = "Trojkat";
                 //   polaFigur[i] = String.format("%.3f",figury[i].pole);
                  //  cechaFigur[i] = String.format("wysokosc\n%.3f",figury[i].wysokosc);
                    break;
                case 2:
                 //   figury[i] = new Kolo(generator.nextFloat()); // tworzenie kola
                 //   sumaKol += figury[i].getPole(); // sumowanie pol kol
                    jakaFigura[i] = "Kolo";
                //    polaFigur[i] = String.format("%.3f",figury[i].pole);
                 //   cechaFigur[i] = String.format("srednica\n%.3f",figury[i].srednica);
                    break;
                default:
                    break;
            }
           /* sFigury[i] = figury[i].sWyswietl();
            sFigury[15] = String.format("Suma pol kwadratow jest rowna %.3f",sumaKwadratow);
            sFigury[16] = String.format("Suma pol trojkatow jest rowna %.3f",sumaTrojkatow);
            sFigury[17] = String.format("Suma pol kol jest rowna %.3f\n",sumaKol);*/


        }
    }

    void wyswietlanie() {
        for (int i = 0; i < N; i++) {
           //System.out.println(sFigury[i]);
            System.out.println(jakaFigura[i]);
            System.out.println(polaFigur[i]);
            System.out.println(cechaFigur[i]);
        }
    }
    public  void  setN(Integer liczba){
        N = liczba;
    }
}



