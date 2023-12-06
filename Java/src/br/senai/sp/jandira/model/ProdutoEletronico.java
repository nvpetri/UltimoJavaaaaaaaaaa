package br.senai.sp.jandira.model;

public class ProdutoEletronico extends Produto {
    private String marca;

    public ProdutoEletronico(int codigo, String nome, int quantidadeEstoque, double precoUnitario,
                             String fornecedor, String marca) {
        super(codigo, nome, quantidadeEstoque, precoUnitario, fornecedor);
        this.marca = marca;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Marca: " + marca);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}

