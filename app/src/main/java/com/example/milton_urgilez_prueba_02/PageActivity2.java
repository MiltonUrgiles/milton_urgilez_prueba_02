package com.example.milton_urgilez_prueba_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PageActivity2 extends AppCompatActivity {

    private String inNombres;
    private EditText nombres;
    private EditText apellidos;
    private EditText dividendo;
    private EditText divisor;
    private EditText numero;
    private Button buttonCerra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombres = findViewById(R.id.editTextNombres);
        apellidos = findViewById(R.id.editTextApellidos);
        dividendo = findViewById(R.id.editTextDividendo);
        divisor= findViewById(R.id.editTextDivisor);
        numero = findViewById(R.id.editTextNumero);
        buttonCerra=findViewById(R.id.buttonCerrar);

        Intent intent = getIntent();
        if (intent != null) {
            nombres.setText(intent.getStringExtra("nombres"));
            inNombres=intent.getStringExtra("nombres");

            apellidos.setText(intent.getStringExtra("apellidos"));
            dividendo.setText(intent.getStringExtra("dividendo"));
            divisor.setText(intent.getStringExtra("divisor"));
            numero.setText(intent.getStringExtra("numero"));
        }
        if(inNombres!=null)
            buttonCerra.setEnabled(true);
    }


    public void Siguiente(View view) {
        Intent intent = new Intent(this, PageActivity3.class);
        intent.putExtra("nombres", nombres.getText().toString());
        intent.putExtra("apellidos", apellidos.getText().toString());
        startActivity(intent);
    }

    public void cerrar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nombres",nombres.getText().toString());
        intent.putExtra("apellidos",apellidos.getText().toString());
        intent.putExtra("dividendo",dividendo.getText().toString());
        intent.putExtra("divisor",divisor.getText().toString());
        intent.putExtra("numero",numero.getText().toString());
        startActivity(intent);
    }
}