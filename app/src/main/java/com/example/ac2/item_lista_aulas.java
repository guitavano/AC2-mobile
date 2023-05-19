package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ac2.api.ApiService;
import com.example.ac2.Agenda;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class item_lista_aulas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_lista_aulas);

        Button voltarLista = findViewById(R.id.voltarLista);
        voltarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(item_lista_aulas.this, MainActivity.class);
                startActivity(intent);
            }
        });

        preencherTabela();

    }

    private void preencherTabela() {
        String url = "https://6306b2db3a2114bac7536404.mockapi.io/api/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url) // Substitua pelo seu endpoint base
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Agenda>> call = apiService.obterAgendas();
        call.enqueue(new Callback<List<Agenda>>() {
            @Override
            public void onResponse(Call<List<Agenda>> call, Response<List<Agenda>> response) {
                if (response.isSuccessful()) {
                    List<Agenda> agendas = response.body();
                    // Preencher a tabela com os dados da lista de agendas
                    for (Agenda agenda : agendas) {
                        adicionarLinhaNaTabela(agenda);
                    }
                } else {
                    // Lógica de tratamento de resposta com erro
                }
            }

            @Override
            public void onFailure(Call<List<Agenda>> call, Throwable t) {
                Log.e("API", "Erro na resposta da API: " + t.getMessage());
            }
        });
    }


    private void adicionarLinhaNaTabela(Agenda agenda) {
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Criar uma nova linha
        TableRow tableRow = new TableRow(this);

        // Configurar layout dos campos
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 30, 30, 30);

        // Criar TextViews para cada campo da agenda
        TextView textViewDataInicio = new TextView(this);
        textViewDataInicio.setLayoutParams(layoutParams);
        textViewDataInicio.setText(agenda.getDataInicio());

        TextView textViewDataFim = new TextView(this);
        textViewDataFim.setLayoutParams(layoutParams);
        textViewDataFim.setText(agenda.getDataFim());

        TextView textViewIdProfessor = new TextView(this);
        textViewIdProfessor.setLayoutParams(layoutParams);


        String url = "https://6306b2db3a2114bac7536404.mockapi.io/api/v1/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url) // Substitua pelo seu endpoint base
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Professor> call = apiService.obterProfessor(agenda.getIdProfessor());
        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if (response.isSuccessful()) {
                    Professor prof = response.body();
                    textViewIdProfessor.setText(prof.getNome());
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Log.e("API", "Erro na resposta da API: " + t.getMessage());
            }
        });

        TextView textViewCurso = new TextView(this);
        textViewCurso.setLayoutParams(layoutParams);
        textViewCurso.setText(agenda.getCurso());

        // Adicionar os TextViews à linha
        tableRow.addView(textViewDataInicio);
        tableRow.addView(textViewDataFim);
        tableRow.addView(textViewIdProfessor);
        tableRow.addView(textViewCurso);

        // Adicionar a linha à tabela
        tableLayout.addView(tableRow);
    }

}