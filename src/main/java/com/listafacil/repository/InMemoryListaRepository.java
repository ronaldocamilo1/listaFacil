package com.listafacil.repository;

import com.listafacil.model.ListaCompra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryListaRepository implements ListaRepository {
    private final Map<Integer, ListaCompra> storage = new HashMap<>();

    @Override
    public ListaCompra salvar(ListaCompra lista) {
        storage.put(lista.getId(), lista);
        return lista;
    }

    @Override
    public ListaCompra buscarPorId(int id) {
        return storage.get(id);
    }

    @Override
    public List<ListaCompra> listarTodos() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deletar(int id) {
        storage.remove(id);
    }
}
