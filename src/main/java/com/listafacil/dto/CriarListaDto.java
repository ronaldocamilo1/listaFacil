package com.listafacil.dto;

public class CriarListaDto {
    private final String nome;
    private final String descricao;

    public CriarListaDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
}
