package com.example.a2trimestre.retoClase;

public class PrimoModel {
    private static final double MAX_TIME = 1000 ;
    private static final double MAX_NUMERO = 100;
    private int count;

    public PrimoModel(){
        count=0;
    }

    public void calcularNumPrimos(int numMin, int numMax){
        int count=0;
        //Tarda en pedir la informacion
        esperarAleatorio();
        for (int i = numMin; i <= numMax; i++)
            if (isPrime (i))  count++;;
    }

    public static boolean isPrime (int n) {

        // 0, 1 negative numbers are not prime
        if (n < 2)
            return false;

        // checking the number of divisors b/w 1 and the number n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        // if reached here then must be true
        return true;
    }

    public int getNumeroDePrimos(){
        return count;
    }

    private void esperarAleatorio(){
        try {
            Thread.sleep((long) (Math.random()*MAX_TIME));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
