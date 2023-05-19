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

public class cadastra_agenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_agenda);

        Button voltarAgenda = findViewById(R.id.voltarAgenda);
        voltarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastra_agenda.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCadastraAgenda = findViewById(R.id.btnCadastraAgenda);
        btnCadastraAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editDataInicio = findViewById(R.id.dataInicio);
                EditText editDataFim = findViewById(R.id.dataFim);
                EditText editIdProfessor = findViewById(R.id.idProfessor);
                EditText editCurso = findViewById(R.id.curso);

                String dataInicio = editDataInicio.getText().toString();
                String dataFim = editDataFim.getText().toString();
                String idProfessor = editIdProfessor.getText().toString();
                String curso = editCurso.getText().toString();

                cadastrarAgenda(dataInicio, dataFim, idProfessor, curso);
            }
        });
    }

    private void cadastrarAgenda(String dataInicio, String dataFim, String idProfessor, String curso) {
        String url = "https://6306b2db3a2114bac7536404.mockapi.io/api/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Void> call = apiService.cadastrarAgenda("",dataInicio, dataFim, idProfessor, curso);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(cadastra_agenda.this, "Deu certo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(cadastra_agenda.this, "Deu erro", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(cadastra_agenda.this, "Deu erro", Toast.LENGTH_SHORT).show();
            }
        });
    }
}