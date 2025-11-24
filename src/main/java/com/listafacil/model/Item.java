package com.listafacil.model;

public class Item {
    private final int id;
    private final String produtoNome;
    private final double precoUnitario;
    private int quantidade;
    private boolean comprado = false;

    public Item(int id, String produtoNome, double precoUnitario, int quantidade) {
        this.id = id;
        this.produtoNome = produtoNome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getProdutoNome() { return produtoNome; }
    public double getPrecoUnitario() { return precoUnitario; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public boolean isComprado() { return comprado; }
    public void setComprado(boolean comprado) { this.comprado = comprado; }
}

