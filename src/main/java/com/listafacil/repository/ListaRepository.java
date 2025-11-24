package com.listafacil.repository;

import com.listafacil.model.ListaCompra;
import java.util.List;

public interface ListaRepository {
    ListaCompra salvar(ListaCompra lista);
    ListaCompra buscarPorId(int id);
    List<ListaCompra> listarTodos();
    void deletar(int id);
}
