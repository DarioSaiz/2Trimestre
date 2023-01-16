package com.example.a2trimestre.retoClase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrimoViewModel extends ViewModel {
    MutableLiveData<Integer> datoObservable;
    PrimoModel datos = new PrimoModel();

    public LiveData<Integer> getPrimo(){
        if (datoObservable==null){
            datoObservable = new MutableLiveData<Integer>();
            datoObservable.setValue(0);
            // generarAleatorio()
        }
        return datoObservable;
    }

    public void nuevoPrimo(int numMin, int numMax){
        //actividad asincrona
        //run no acepta parametro
        new Thread(()->{
            //Peticion a servidor remoto
            datos.calcularNumPrimos(numMin, numMax);
            //Que se entere todo el mundo que ha llegado
            datoObservable.postValue(datos.getNumeroDePrimos());
        }).start();
    }
}
