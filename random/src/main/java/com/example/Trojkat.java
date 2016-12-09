package com.example;


/**
 * Created by Mateusz on 2016-11-09.
 */

public class Trojkat extends Figura {
        public Trojkat(){

        }
        public Trojkat(float wysokosc){ // Konstruktor
            this.wysokosc = wysokosc;
            obliczPole(wysokosc);
        }
        void obliczPole(float wysokosc){
            pole = (wysokosc * wysokosc) / (float)Math.sqrt(3);
        }

        public String getCechaString(){
            return String.format("wysokosc\n%.3f",this.wysokosc);
        }
        public String jakaFiguraString(){
            return String.format("Trojkat");
        }
}
