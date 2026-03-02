package com.testando.POA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Fala que é uma entidade do DB
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;

    public Produto(){} //É obrigatório usar constructor vazio pelo JPA

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() { return id;}

    public String getNome() { return nome;}

    public void setNome(String nome) { this.nome = nome;}

    public Double getPreco() { return preco;}

    public void setPreco(Double preco) {this.preco = preco; }
}
