package com.example.a2trimestre.retoClase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a2trimestre.R;

public class Primo extends AppCompatActivity {

    TextView seVe;
    EditText primoMenor, primoMayor;
    Button pulsa;
    LiveData<Integer> datoObservable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primo);

        seVe = findViewById(R.id.seVe);
        primoMenor = findViewById(R.id.PrimoMenor);
        primoMayor = findViewById(R.id.PrimoMayor);
        pulsa = findViewById(R.id.bt);

        PrimoViewModel vm = new ViewModelProvider(this).get(PrimoViewModel.class);

        pulsa.setOnClickListener((v)->{
            int numeroMenor=Integer.parseInt(primoMenor.getText().toString());
            int numeroMayor=Integer.parseInt(primoMayor.getText().toString());
            vm.nuevoPrimo(numeroMenor,numeroMayor);
        });


        datoObservable = vm.getPrimo();
        datoObservable.observe(this, (dato) -> {
            seVe.setText(dato.getNumeroDePrimos());
        });



    }
}