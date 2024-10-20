/*
 *@author:<Leonardo Lima 1110482423021>
 */
package com.example.aula02_exercicio02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private Button btncCalc;
    private TextView tvRes;


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

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMaior.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etBaseMenor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btncCalc = findViewById(R.id.btncCalc);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btncCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        int baseMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int baseMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int altura = Integer.parseInt(etAltura.getText().toString());
        int area = (baseMaior + baseMenor) * altura /2;
        String res = getString(R.string.resultado) + area;
        tvRes.setText(res);
    }
}