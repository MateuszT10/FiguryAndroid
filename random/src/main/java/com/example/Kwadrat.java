package com.example;

/**
 * Created by Mateusz on 2016-11-09.
 */

  public  class Kwadrat extends Figura {

        public Kwadrat(){

        }
        public Kwadrat(float przekatna){ //Konstruktor
            this.przekatna = przekatna;
            obliczPole(przekatna);
        }
        void obliczPole(float przekatna){
            pole = (przekatna * przekatna) / 2;
        }

        public String getCechaString(){
            return String.format("przekatna\n%.3f",this.przekatna);
        }
        public String jakaFiguraString(){
            return String.format("Kwadrat");
        }
  }
