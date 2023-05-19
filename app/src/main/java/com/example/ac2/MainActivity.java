package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbrirCadastroProfessor = findViewById(R.id.btnAbrirCadastroProfessor);
        btnAbrirCadastroProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cadastra_professor.class);
                startActivity(intent);
            }
        });

        Button btnPageAgenda = findViewById(R.id.btnPageAgenda);
        btnPageAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cadastra_agenda.class);
                startActivity(intent);
            }
        });

        Button btnPageLista = findViewById(R.id.btnPageLista);
        btnPageLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, item_lista_aulas.class);
                startActivity(intent);
            }
        });

    }
}