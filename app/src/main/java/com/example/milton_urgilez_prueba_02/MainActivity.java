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

public class MainActivity extends AppCompatActivity {


    private EditText nombres;
    private EditText apellidos;
    private EditText dividendo;
    private EditText divisor;
    private EditText parteEntera;
    private EditText residuo;
    private EditText numeroInvertido;
    private Button siguiente;
    private Button mostrarResultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombres = findViewById(R.id.editTextNombres);
        apellidos = findViewById(R.id.editTextApellidos);
        dividendo = findViewById(R.id.editTextDividendo);
        divisor = findViewById(R.id.editTextDivisor);
        parteEntera = findViewById(R.id.editTextParteEntera);
        residuo = findViewById(R.id.editTextResiduo);


        Intent intent = getIntent();
        if (intent != null) {
            nombres.setText(intent.getStringExtra("nombres"));
            apellidos.setText(intent.getStringExtra("apellidos"));
            dividendo.setText(intent.getStringExtra("dividendo"));
            divisor.setText(intent.getStringExtra("divisor"));
            numero.setText(intent.getStringExtra("numero"));
            buttonCerra.setEnabled(true);
        }
    }

    public void Siguiente(View view){
        Intent intent = new Intent(this, PageActivity2.class);
        startActivity(intent);
    }
    public void MostrarResultados(View view){

    }
}