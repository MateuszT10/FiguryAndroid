package com.example;

public abstract class Figura {
        float pole;
        float przekatna;
        float srednica;
        float wysokosc;

        public Figura(){

        }

        public float getPole(){return pole;}

        public String getPoleString() {
                return String.format( "%.3f", pole);
        }

        public String getCechaString(){
                return String.format("Sialalal");
        }

        public String getFiguraString(){ return  String.format("Figura");
        }
        public float getCecha(){ return (float)0;}
}