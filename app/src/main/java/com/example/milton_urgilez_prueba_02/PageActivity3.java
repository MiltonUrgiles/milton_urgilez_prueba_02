package com.example.milton_urgilez_prueba_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PageActivity3 extends AppCompatActivity {


    private EditText nombres;
    private EditText apellidos;
    private EditText dividendo;
    private EditText divisor;
    private EditText numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page3);
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

        Bundle bundle = this.getIntent().getExtras();
        nombres.setText(bundle.getString("nombres"));
        apellidos.setText(bundle.getString("apellidos"));

    }

    public void cerrar(View view) {
        Intent intent = new Intent(this, PageActivity2.class);
        intent.putExtra("nombres",nombres.getText().toString());
        intent.putExtra("apellidos",apellidos.getText().toString());
        intent.putExtra("dividendo",dividendo.getText().toString());
        intent.putExtra("divisor",divisor.getText().toString());
        intent.putExtra("numero",numero.getText().toString());
        startActivity(intent);
    }
}