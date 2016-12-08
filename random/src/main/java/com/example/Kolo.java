package com.example;

/**
 * Created by Mateusz on 2016-11-09.
 */

public class Kolo extends Figura {
        public Kolo(){

        }
        public Kolo(float srednica){ // Konstruktor
            this.srednica = srednica;
            obliczPole(this.srednica);
        }
        void obliczPole(float srednica){
            pole = (float)Math.PI * (srednica * srednica) / 4;
        }
        public void wyswietl(){ //Wyswietlanie obiektu
            System.out.format("Kolo    o polu %.3f i srednicy  %.3f",pole,srednica);
        }
        public String sWyswietl(){
         return  String.format("Kolo        o polu %.3f i srednicy      %.3f",pole,srednica);
        }

}
