package com.example;

/**
 * Created by Mateusz on 2016-11-09.
 */

public class Kolo extends Figura {
        public Kolo(){

        }
        public Kolo(float srednica){ // Konstruktor
            this.srednica = srednica;
            obliczPole(srednica);
        }
        void obliczPole(float srednica){
            pole = (float)Math.PI * (srednica * srednica) / 4;
        }
        public String getCechaString(){
            return String.format("srednica\n%.3f",this.srednica);
        }
        public String getFiguraString(){return String.format("Kolo");
        }
         public float getCecha(){return this.srednica;}

}
