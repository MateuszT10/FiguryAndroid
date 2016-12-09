package com.example;

public abstract class Figura {
        float pole;
        float przekatna;
        float srednica;
        float wysokosc;

        public Figura(){

        }
        public void wyswietl() {

        }

        public float getPole() {
                return pole;
        }

        public String getCecha(){
                return String.format("Sialalal");
        }

        public String sWyswietl() {
                return "Klasa Figura";
        }
}