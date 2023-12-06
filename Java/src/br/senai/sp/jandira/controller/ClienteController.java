package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Cliente;
import br.senai.sp.jandira.model.ClienteModel;

import java.util.Scanner;

public class ClienteController {
    private ClienteModel clienteModel;
    private Scanner scanner;

    public ClienteController(ClienteModel clienteModel, Scanner scanner) {
        this.clienteModel = clienteModel;
        this.scanner = scanner;
    }

    public void cadastrarNovoCliente() {
        System.out.println("Informe o CPF do cliente:");
        String cpf = scanner.next();
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.next();
        System.out.println("Informe o endereço do cliente:");
        String endereco = scanner.next();

        Cliente cliente = new Cliente(cpf, nome, endereco);
        clienteModel.adicionarCliente(cliente);
    }

    public Cliente consultarClientePorCPF(String cpf) {
        return clienteModel.buscarClientePorCPF(cpf);
    }

}
