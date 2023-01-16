package com.example.a2trimestre.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AleatorioViewModel extends ViewModel {

    MutableLiveData<Integer> datoObservable;
    EjemploModelAleatorio datos;

    public LiveData<Integer> getDatoAleatorio(){
        if (datoObservable==null){
            datoObservable = new MutableLiveData<Integer>();
            datos = new EjemploModelAleatorio();
            // generarAleatorio()
        }
        return datoObservable;
    }

    public void nuevoAleatorio(){
        //actividad asincrona
        //run no acepta parametro
        new Thread(()->{
            //Peticion a servidor remoto
            datos.generarAleatorio();
            //Que se entere todo el mundo que ha llegado
            datoObservable.postValue(datos.getAleatorio());
        }).start();
    }
}
