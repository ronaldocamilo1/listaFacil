package com.listafacil.controller;

import com.listafacil.dto.AdicionarItemDto;
import com.listafacil.dto.CriarListaDto;
import com.listafacil.exception.NotFoundException;
import com.listafacil.model.Item;
import com.listafacil.model.ListaCompra;
import com.listafacil.service.ListaService;

import java.util.List;
import java.util.Scanner;

public class ConsoleController {
    private final Scanner scanner = new Scanner(System.in);
    private final ListaService listaService = new ListaService();

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1" -> criarLista();
                    case "2" -> listarListas();
                    case "3" -> adicionarItem();
                    case "4" -> removerItem();
                    case "5" -> alternarComprado();
                    case "6" -> mostrarDetalhes();
                    case "7" -> gerarResumo();
                    case "0" -> running = false;
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada numérica inválida. Tente novamente.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("Encerrando ListaFácil. Até mais!");
    }

    private void showMenu() {
        System.out.println("\n=== ListaFácil ===");
        System.out.println("1 - Criar nova lista");
        System.out.println("2 - Listar todas as listas");
        System.out.println("3 - Adicionar item a uma lista");
        System.out.println("4 - Remover item de uma lista");
        System.out.println("5 - Marcar item como comprado/desmarcar");
        System.out.println("6 - Mostrar detalhes de uma lista");
        System.out.println("7 - Gerar resumo (relatório simples)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void criarLista() {
        System.out.print("Nome da lista: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Descrição (opcional): ");
        String desc = scanner.nextLine().trim();
        CriarListaDto dto = new CriarListaDto(nome, desc);
        ListaCompra lista = listaService.criarLista(dto);
        System.out.println("Lista criada. ID: " + lista.getId());
    }

    private void listarListas() {
        List<ListaCompra> listas = listaService.getTodas();
        if (listas.isEmpty()) {
            System.out.println("Nenhuma lista cadastrada.");
            return;
        }
        System.out.println("Listas:");
        for (ListaCompra l : listas) {
            System.out.printf("ID: %d | Nome: %s | Itens: %d | Total: R$ %.2f%n",
                    l.getId(), l.getNome(), l.getItens().size(), l.calcularTotal());
        }
    }

    private void adicionarItem() {
        System.out.print("ID da lista: ");
        int idLista = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Preço (ex: 4.50): ");
        double preco = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine().trim());
        AdicionarItemDto dto = new AdicionarItemDto(nome, preco, qtd);
        Item item = listaService.adicionarItem(idLista, dto);
        System.out.println("Item adicionado. ID do Item: " + item.getId());
    }

    private void removerItem() {
        System.out.print("ID da lista: ");
        int idLista = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("ID do item: ");
        int idItem = Integer.parseInt(scanner.nextLine().trim());
        listaService.removerItem(idLista, idItem);
        System.out.println("Item removido com sucesso.");
    }

    private void alternarComprado() {
        System.out.print("ID da lista: ");
        int idLista = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("ID do item: ");
        int idItem = Integer.parseInt(scanner.nextLine().trim());
        listaService.alternarComprado(idLista, idItem);
        System.out.println("Operação concluída.");
    }

  
}
