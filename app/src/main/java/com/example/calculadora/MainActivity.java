package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_sumar;
    EditText edt_num1, edt_num2;
    Button btn_ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_sumar = findViewById(R.id.btn_sumar);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);



        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = edt_num1.getText().toString();
                String text2 = edt_num2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(MainActivity.this, "Estan vacios", Toast.LENGTH_LONG).show();
                } else {
                    int num1 = Integer.parseInt(text1);
                    int num2 = Integer.parseInt(text2);
                    int suma = num1 + num2;
                    Toast.makeText(MainActivity.this, "el resultado es:" + suma, Toast.LENGTH_LONG).show();
                }}
        });
        btn_ir = (Button) findViewById(R.id.btn_ir);
        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, calculadoraCompleta.class);
                startActivity(i);
            }
        });
    }
}