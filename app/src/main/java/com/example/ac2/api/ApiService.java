package com.example.ac2.api;

import com.example.ac2.Agenda;
import com.example.ac2.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("/professores")
    Call<Void> cadastrarUsuario(
            @Field("id") String id,
            @Field("nome") String nome,
            @Field("rg") String rg,
            @Field("cpf") String cpf,
            @Field("endereco") String endereco
    );

    @FormUrlEncoded
    @POST("/agenda")
    Call<Void> cadastrarAgenda(
            @Field("id") String id,
            @Field("dataInicio") String dataInicio,
            @Field("dataFim") String dataFim,
            @Field("idProfessor") String idProfessor,
            @Field("curso") String curso
    );

    @GET("/agenda")
    Call<List<Agenda>> obterAgendas();

    @GET("professores/{id}")
    Call<Professor> obterProfessor(@Path("id") String id);
}