package com.example.myapplication5.Calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication5.R;

public class Calculator extends AppCompatActivity {

    private int resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        setTitle("Rechner");

        Button button = findViewById(R.id.calculate);
        EditText et1 = findViewById(R.id.number1);
        EditText et2 = findViewById(R.id.number2);

        this.resultFragment = R.id.resultFragment;

        button.setOnClickListener(evt -> {
            String ergebnis = "";
            try {
                ergebnis = Integer.toString(Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString()));
            } catch (Exception e) {
                ergebnis = getString(R.string.wrongInput);
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(this.resultFragment, calculatorResultFragment.newInstance(ergebnis));
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }
}
