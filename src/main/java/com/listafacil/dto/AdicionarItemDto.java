package com.listafacil.dto;

public class AdicionarItemDto {
    private final String nomeProduto;
    private final double precoUnitario;
    private final int quantidade;

    public AdicionarItemDto(String nomeProduto, double precoUnitario, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() { return nomeProduto; }
    public double getPrecoUnitario() { return precoUnitario; }
    public int getQuantidade() { return quantidade; }
}