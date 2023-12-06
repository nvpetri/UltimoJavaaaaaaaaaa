package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private String servidor, banco, usuario, senha;
    public Connection conexao;

    public ConexaoMySQL(){
        this.servidor = "localhost";
        this.banco = "db_ativ";
        this.usuario = "root";
        this.senha = "bcd127";
    }

    public Connection conectar() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco,
                    this.usuario, this.senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
