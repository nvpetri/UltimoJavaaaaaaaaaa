package br.senai.sp.jandira;

import br.senai.sp.jandira.model.*;
import br.senai.sp.jandira.controller.ClienteController;
import br.senai.sp.jandira.controller.EstoqueController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        try (Connection connection = conexaoMySQL.conectar()) {
            EstoqueModel estoqueModel = new EstoqueModel(connection);
            ClienteModel clienteModel = new ClienteModel(connection);

            EstoqueController estoqueController = new EstoqueController(estoqueModel, new Scanner(System.in));
            ClienteController clienteController = new ClienteController(clienteModel, new Scanner(System.in));

            Menu.exibirMenu(estoqueController, clienteController);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
