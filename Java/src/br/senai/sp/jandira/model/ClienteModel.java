package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteModel {
    private Connection connection;

    public ClienteModel(Connection connection) {
        this.connection = connection;
    }

    public void adicionarCliente(Cliente cliente) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO clientes (cpf, nome, endereco) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setString(3, cliente.getEndereco());

            preparedStatement.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarClientePorCPF(String cpf) {
        Cliente cliente = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM clientes WHERE cpf = ?")) {

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");

                cliente = new Cliente(cpf, nome, endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}
