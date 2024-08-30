package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class calculadoraCompleta extends AppCompatActivity {

    Button button_calcular;
    EditText num1, num2;
    Spinner operaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora_completa);

        button_calcular = findViewById(R.id.button_calculate);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        operaciones = findViewById(R.id.spinnerOperations);

        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = num1.getText().toString();
                String text2 = num2.getText().toString();
                if (text1.isEmpty() || text2.isEmpty()) {
                    Toast.makeText(calculadoraCompleta.this, "Por favor, ingrese datos en ambos campos", Toast.LENGTH_LONG).show();
                } else {
                    double numero1 = Double.parseDouble(text1);
                    double numero2 = Double.parseDouble(text2);
                    String operation = operaciones.getSelectedItem().toString();
                    double resultado = 0;
                    switch (operation) {
                        case "Suma":
                            resultado = numero1 + numero2;
                            break;
                        case "Resta":
                            resultado = numero1 - numero2;
                            break;
                        case "Multiplicación":
                            resultado = numero1 * numero2;
                            break;
                        case "División":
                            if (numero2 != 0) {
                                resultado = numero1 / numero2;
                            } else {
                                Toast.makeText(calculadoraCompleta.this, "Error: División por cero", Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;
                    }
                    Toast.makeText(calculadoraCompleta.this, "El resultado de la operación es: " + resultado, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}