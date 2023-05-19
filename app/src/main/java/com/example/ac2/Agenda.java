package com.example.ac2;

public class Agenda {

    private String dataInicio;
    private String dataFim;
    private String idProfessor;
    private String curso;

    public Agenda() {
    }

    public Agenda(String dataInicio, String dataFim, String idProfessor, String curso) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idProfessor = idProfessor;
        this.curso = curso;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}