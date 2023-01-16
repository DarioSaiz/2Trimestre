package com.example.a2trimestre.MVVM;

public class EjemploModelAleatorio {
    private static final double MAX_TIME = 1000 ;
    private static final double MAX_NUMERO = 100;
    private int n;

    public EjemploModelAleatorio(){
        n=0;
    }

    public void generarAleatorio(){
        //Tarda en pedir la informacion
        esperarAleatorio();
        n = (int)(Math.random()*MAX_NUMERO);
    }

    public int getAleatorio(){
        return n;
    }

    private void esperarAleatorio(){
        try {
            Thread.sleep((long) (Math.random()*MAX_TIME));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
