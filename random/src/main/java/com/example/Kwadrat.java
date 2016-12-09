package com.example;

/**
 * Created by Mateusz on 2016-11-09.
 */

  public  class Kwadrat extends Figura {

        public Kwadrat(){

        }
        public Kwadrat(float przekatna){ //Konstruktor
            this.przekatna = przekatna;
            obliczPole(this.przekatna);
        }
        void obliczPole(float przekatna){
            pole = (przekatna * przekatna) / 2;
        }
        public void wyswietl(){ //Wyswietlanie obiektu
            System.out.format("Kwadrat o polu %.3f i przekatnej %.3f",pole,przekatna);
        }
        public String sWyswietl(){
            return  String.format("Kwadrat o polu %.3f i przekatnej %.3f",pole,przekatna);
        }
        public String getCecha(){
            return String.format("przekatna\n%.3f",this.przekatna);
        }
  }
