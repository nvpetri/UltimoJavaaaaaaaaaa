package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueModel {
    private Connection connection;

    public EstoqueModel(Connection connection) {
        this.connection = connection;
    }

    public void adicionarProduto(Produto produto) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO produtos (codigo, nome, quantidade_estoque, preco_unitario, fornecedor, marca) " +
                        "VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQuantidadeEstoque());
            preparedStatement.setDouble(4, produto.getPrecoUnitario());
            preparedStatement.setString(5, produto.getFornecedor());

            if (produto instanceof ProdutoEletronico) {
                preparedStatement.setString(6, ((ProdutoEletronico) produto).getMarca());
            } else {
                preparedStatement.setString(6, null);
            }

            preparedStatement.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> pesquisarProdutos(String termoPesquisa) {
        List<Produto> resultado = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM produtos WHERE nome LIKE ?")) {

            preparedStatement.setString(1, "%" + termoPesquisa + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                int quantidadeEstoque = resultSet.getInt("quantidade_estoque");
                double precoUnitario = resultSet.getDouble("preco_unitario");
                String fornecedor = resultSet.getString("fornecedor");
                String marca = resultSet.getString("marca");

                if (marca != null) {
                    ProdutoEletronico produtoEletronico = new ProdutoEletronico(codigo, nome, quantidadeEstoque,
                            precoUnitario, fornecedor, marca);
                    resultado.add(produtoEletronico);
                } else {
                    Produto produto = new Produto(codigo, nome, quantidadeEstoque, precoUnitario, fornecedor);
                    resultado.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
