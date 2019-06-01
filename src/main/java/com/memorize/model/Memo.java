package com.memorize.model;

import java.util.Date;

public class Memo {
    private Date data;
    private String titulo;
    private String autor;
    private String assunto;
    private String conteudo;
    private String cor;
    
    public Memo() {
    }
    
    public Memo(Date data, String titulo, String autor, String assunto, String conteudo, String cor) {
        this.data = data;
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.conteudo = conteudo;
        this.cor = cor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}