package com.example.usuario.calculonotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Double> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notas = new ArrayList<>();
    }

    public void guardar(View v) {
        EditText edtNota = (EditText) findViewById(R.id.notas);
        notas.add(Double.parseDouble(edtNota.getText().toString()));
        //borra el contenido del campo nota
        edtNota.setText("");
        //pasa el foco a dicho control
        edtNota.requestFocus();
    }

    public void calculos(View v) {
        Intent intent = new Intent(this, CalculosActivity.class);
        intent.putExtra("notas", notas);
        this.startActivity(intent);
    }

}
