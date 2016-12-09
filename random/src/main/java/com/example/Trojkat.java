package com.example;


/**
 * Created by Mateusz on 2016-11-09.
 */

public class Trojkat extends Figura {
        public Trojkat(){

        }
        public Trojkat(float wysokosc){ // Konstruktor
            this.wysokosc = wysokosc;
            obliczPole(this.wysokosc);
        }
        void obliczPole(float wysokosc){
            pole = (wysokosc * wysokosc) / (float)Math.sqrt(3);
        }
        public void wyswietl(){ //Wyswietlanie obiektu
            System.out.format("Trojkat o polu %.3f i wysokosci %.3f",pole,wysokosc);
        }
        public String sWyswietl(){
            return  String.format("Trojkat   o polu %.3f i wysokosci  %.3f",pole,wysokosc);
        }
        public String getCecha(){
            return String.format("wysokosc\n%.3f",this.wysokosc);
        }
}
