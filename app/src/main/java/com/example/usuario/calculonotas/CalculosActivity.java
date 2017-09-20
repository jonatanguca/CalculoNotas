package com.example.usuario.calculonotas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);
        Intent intent = this.getIntent();
        ArrayList<Double> notas = (ArrayList<Double>) intent.getSerializableExtra("notas");
        TextView tvAprobados = (TextView) findViewById(R.id.tvAprobados);
        TextView tvMedia = (TextView) findViewById(R.id.tvMedia);
        tvAprobados.setText("Aprobados: " + aprobados(notas));
        tvMedia.setText("Media: " + media(notas));
    }

    private Double media(ArrayList<Double> notas) {
        double result = 0;
        for (Double n : notas) {
            result += n;
        }
        return result / notas.size();
    }

    private int aprobados(ArrayList<Double> notas) {
        int total = 0;
        for (Double n : notas) {
            if (n >= 5) {
                total++;
            }
        }
        return total;
    }

    public void volver(View v) {
        AlertDialog.Builder cuadro = new AlertDialog.Builder(this);
        cuadro.setMessage("¿Quieres volver a introducir notas?");
        //el escuchador del botón de afirmación se define como una clase anónima
        cuadro.setPositiveButton(R.string.vale, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                CalculosActivity.this.finish();
            }
        });
        cuadro.setNegativeButton(R.string.daigual, null);
        cuadro.show();
    }
}
