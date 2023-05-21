package com.example.ac2;

public class Agenda {

    private String id;
    private String dataInicio;
    private String dataFim;
    private String idProfessor;
    private String curso;

    private String resumo;

    public Agenda() {
    }

    public Agenda(String id, String dataInicio, String dataFim, String idProfessor, String curso, String resumo) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idProfessor = idProfessor;
        this.curso = curso;
        this.resumo = resumo;
    }

    public String getId(){return  id;}

    public void setId(){this.id = id;}

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

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.curso = resumo;
    }


}