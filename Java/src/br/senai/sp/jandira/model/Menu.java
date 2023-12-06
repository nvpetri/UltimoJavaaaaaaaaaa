package br.senai.sp.jandira.model;

import br.senai.sp.jandira.controller.ClienteController;
import br.senai.sp.jandira.controller.EstoqueController;

import java.util.Scanner;
import java.util.List;

public class Menu {
    public static void exibirMenu(EstoqueController estoqueController, ClienteController clienteController) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Consultar Produtos");
            System.out.println("4. Consultar Cliente por CPF");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção desejada: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                executarOpcao(opcao, estoqueController, clienteController);
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
                opcao = -1;
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    private static void executarOpcao(int opcao, EstoqueController estoqueController, ClienteController clienteController) {
        switch (opcao) {
            case 1:
                estoqueController.cadastrarNovoProduto();
                break;
            case 2:
                clienteController.cadastrarNovoCliente();
                break;
            case 3:
                System.out.print("Digite o termo de pesquisa: ");
                String termoPesquisa = new Scanner(System.in).nextLine();
                List<Produto> produtosEncontrados = estoqueController.consultarProdutos(termoPesquisa);
                exibirProdutos(produtosEncontrados);
                break;
            case 4:
                System.out.print("Digite o CPF do cliente: ");
                String cpfCliente = new Scanner(System.in).nextLine();
                Cliente clienteEncontrado = clienteController.consultarClientePorCPF(cpfCliente);
                exibirCliente(clienteEncontrado);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void exibirProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("\n===== Produtos Encontrados =====");
            for (Produto produto : produtos) {
                produto.exibirDetalhes();
                System.out.println("-------------------------------");
            }
        }
    }

    private static void exibirCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println("\n===== Cliente Encontrado =====");
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
        }
    }
}
