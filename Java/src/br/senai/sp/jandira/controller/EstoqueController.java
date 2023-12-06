package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.EstoqueModel;
import br.senai.sp.jandira.model.Produto;
import br.senai.sp.jandira.model.ProdutoEletronico;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EstoqueController {
    private EstoqueModel model;
    private Scanner scanner;

    public EstoqueController(EstoqueModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void cadastrarNovoProduto() {
        System.out.println("Informe o código do produto:");
        int codigo = scanner.nextInt();
        System.out.println("Informe o nome do produto:");
        String nome = scanner.next();
        System.out.println("Informe a quantidade do produto:");
        int quantidade = scanner.nextInt();
        System.out.println("Informe o preço unitário do produto:");
        double precoUnitario = scanner.nextDouble();
        System.out.println("Informe o fornecedor do produto:");
        String fornecedor = scanner.next();

        Produto produto;

        System.out.println("É um produto eletrônico? (S/N)");
        String resposta = scanner.next().toUpperCase();

        if ("S".equals(resposta)) {
            System.out.println("Informe a marca do produto eletrônico:");
            String marca = scanner.next();
            produto = new ProdutoEletronico(codigo, nome, quantidade, precoUnitario, fornecedor, marca);
        } else {
            produto = new Produto(codigo, nome, quantidade, precoUnitario, fornecedor);
        }

        model.adicionarProduto(produto);
    }

    public List<Produto> consultarProdutos(String termoPesquisa) {
        return model.pesquisarProdutos(termoPesquisa);
    }
}
