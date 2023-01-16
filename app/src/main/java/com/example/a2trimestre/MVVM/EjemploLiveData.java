package com.example.a2trimestre.MVVM;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.a2trimestre.R;

public class EjemploLiveData extends AppCompatActivity {
    //Este ejemplo no tiene que ver con los otros

    private static final double MAX_VAUE = 100;
    Button button;
    TextView tx;
    MutableLiveData<Integer> datoObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalive_ejemplo);

        button = findViewById(R.id.btn);
        tx = findViewById(R.id.tx);
        datoObservable = new MutableLiveData<Integer>(0);

        datoObservable.observe(this, dato -> {
            tx.setText(dato.toString());
        });

        button.setOnClickListener(view -> {
            datoObservable.postValue(new Integer((int)(Math.random()*MAX_VAUE)));
        });

    }
}
