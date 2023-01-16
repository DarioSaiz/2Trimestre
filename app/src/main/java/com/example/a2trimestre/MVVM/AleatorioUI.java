package com.example.a2trimestre.MVVM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.a2trimestre.R;

public class AleatorioUI extends AppCompatActivity {

    Button button;
    TextView tx;
    LiveData<Integer> datoObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalive_ejemplo);

        button = findViewById(R.id.btn);
        tx = findViewById(R.id.tx);

        AleatorioViewModel vm = new ViewModelProvider(this).get(AleatorioViewModel.class);
        datoObservable = vm.getDatoAleatorio();
        datoObservable.observe(this, (dato) -> {
            tx.setText(dato.toString());
        });

        button.setOnClickListener((v)->{
            tx.setText("...");
            vm.nuevoAleatorio();
        });
    }
}