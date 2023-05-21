package com.example.ac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ac2.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class resumo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        Button btnSalvarResumo = findViewById(R.id.btnSalvarResumo);
        btnSalvarResumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Resumo = findViewById(R.id.resumo);

                String resumo = Resumo.getText().toString();


                inserirResumo(resumo);
            }
        });
    }

    private void inserirResumo(String resumo) {
        Log.d("teste", "entrou no método");
        String url = "https://64682b7a60c8cb9a2ca45564.mockapi.io/v2/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Void> call = apiService.inserirResumo("",resumo);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("teste", resumo);
                if (response.isSuccessful()) {
                    Toast.makeText(resumo.this, "Deu certo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(resumo.this, "Deu erro1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(resumo.this, "Deu erro", Toast.LENGTH_SHORT).show();
            }
        });
    }
}