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

    private String inNombres;
    private String inApellidos;
    private String inDividendo;
    private String inDivisor;
    private String inNumero;


    private EditText nombres;
    private EditText apellidos;
    private EditText dividendo;
    private EditText divisor;
    private EditText parteEntera;
    private EditText editresiduo;
    private EditText editTextNumeroInvertido;
    private EditText numero;
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
        editresiduo = findViewById(R.id.editTextResiduo);
        mostrarResultados=findViewById((R.id.buttonMostrarResultados));
        editTextNumeroInvertido=findViewById(R.id.editTextNumeroInvertido);

        Intent intent = getIntent();
        if (intent != null) {
            inNombres= intent.getStringExtra("nombres");
            inApellidos= intent.getStringExtra("apellidos");
            inDividendo= intent.getStringExtra("dividendo");
            inDivisor= intent.getStringExtra("divisor");
            inNumero= intent.getStringExtra("numero");

        }
        if(inNombres!=null)
            mostrarResultados.setEnabled(true);

    }

    public void Siguiente(View view){
        Intent intent = new Intent(this, PageActivity2.class);
        startActivity(intent);
    }
    public void MostrarResultados(View view){
        nombres.setText(inNombres.toString());
        apellidos.setText(inApellidos.toString());
        dividendo.setText(inDividendo.toString());
        divisor.setText(inDivisor.toString());
        Division(view);
      //  Invertir();
    }

    public void Invertir() {

        String valor = numero.getText().toString();

        int valorNumerico = Integer.parseInt(valor);

        int numeroInvertido = 0;


        while (valorNumerico != 0) {

            int digito = valorNumerico % 10;


            numeroInvertido = numeroInvertido * 10 + digito;


            valorNumerico = valorNumerico / 10;
        }

        editTextNumeroInvertido.setText(String.valueOf(numeroInvertido));
    }


    public void Division(View view) {

        String divid = inDividendo;
        String divis = inDivisor;


        int a = Integer.parseInt(divid);
        int b = Integer.parseInt(divis);


        int numero = a / b;


        int residuo = a % b;


        parteEntera.setText(String.valueOf(numero));


        editresiduo.setText(String.valueOf(residuo));
    }

}