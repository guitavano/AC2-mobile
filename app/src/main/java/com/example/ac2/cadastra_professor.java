package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ac2.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class cadastra_professor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_professor);

        Button voltarProfessor = findViewById(R.id.voltarProfessor);
        voltarProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastra_professor.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNome = findViewById(R.id.editNome);
                EditText editRG = findViewById(R.id.editRG);
                EditText editCPF = findViewById(R.id.editCPF);
                EditText editEndereco = findViewById(R.id.editEndereco);

                String nome = editNome.getText().toString();
                String rg = editRG.getText().toString();
                String cpf = editCPF.getText().toString();
                String endereco = editEndereco.getText().toString();

                cadastrarProfessor(nome, rg, cpf, endereco);
            }
        });

    }

    private void cadastrarProfessor(String nome, String rg, String cpf, String endereco) {
        String url = "https://6306b2db3a2114bac7536404.mockapi.io/api/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Void> call = apiService.cadastrarUsuario("",nome, rg, cpf, endereco);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(cadastra_professor.this, "Deu certo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(cadastra_professor.this, "Deu certo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(cadastra_professor.this, "Deu erro", Toast.LENGTH_SHORT).show();
            }
        });
    }
}