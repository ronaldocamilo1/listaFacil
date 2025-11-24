package com.listafacil.service;

import com.listafacil.dto.AdicionarItemDto;
import com.listafacil.dto.CriarListaDto;
import com.listafacil.exception.NotFoundException;
import com.listafacil.model.Item;
import com.listafacil.model.ListaCompra;
import com.listafacil.repository.InMemoryListaRepository;
import com.listafacil.repository.ListaRepository;
import com.listafacil.util.IdGenerator;

import java.util.List;

public class ListaService {
    private final ListaRepository repository = new InMemoryListaRepository();

    public ListaCompra criarLista(CriarListaDto dto) {
        int id = IdGenerator.nextId();
        ListaCompra lista = new ListaCompra(id, dto.getNome(), dto.getDescricao());
        return repository.salvar(lista);
    }

    public List<ListaCompra> getTodas() {
        return repository.listarTodos();
    }

    public ListaCompra getPorId(int id) {
        ListaCompra l = repository.buscarPorId(id);
        if (l == null) throw new NotFoundException("Lista não encontrada: " + id);
        return l;
    }

    public Item adicionarItem(int idLista, AdicionarItemDto dto) {
        ListaCompra l = getPorId(idLista);
        int idItem = IdGenerator.nextId();
        Item item = new Item(idItem, dto.getNomeProduto(), dto.getPrecoUnitario(), dto.getQuantidade());
        l.adicionarItem(item);
        repository.salvar(l);
        return item;
    }

    public void removerItem(int idLista, int idItem) {
        ListaCompra l = getPorId(idLista);
        Item it = l.buscarItem(idItem);
        if (it == null) throw new NotFoundException("Item não encontrado: " + idItem);
        l.removerItem(idItem);
        repository.salvar(l);
    }

    public void alternarComprado(int idLista, int idItem) {
        ListaCompra l = getPorId(idLista);
        Item it = l.buscarItem(idItem);
        if (it == null) throw new NotFoundException("Item não encontrado: " + idItem);
        it.setComprado(!it.isComprado());
        repository.salvar(l);.
    }
}
