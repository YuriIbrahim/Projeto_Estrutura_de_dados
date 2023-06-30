package poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import dao.ProdutoDAO;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class PaginaCadastroProduto {
    private Scanner scanner = new Scanner(System.in);
    private List<Produto> produtos = new ArrayList<>();

    public void exibirPaginaCadastroProduto() {
        System.out.println("===========================");
        System.out.println("Cadastro de Produto");
        System.out.println("===========================");

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Marca do produto: ");
        String marca = scanner.nextLine();

        System.out.print("Descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Categoria do produto: ");
        String categoria = scanner.nextLine();

        System.out.print("Quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Nome do produto: " + produto.getNome());
        System.out.println("Preço: R$" + produto.getPreco());
        System.out.println("Marca: " + marca);
        System.out.println("Descrição: " + descricao);
        System.out.println("Categoria: " + categoria);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public void exibirProdutosOrdenadosPorPreco() {
        Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco).reversed());

        System.out.println("\nProdutos em ordem decrescente de preço:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
        }
    }
}

public class CadastroProduto {
    public static void main(String[] args) {
        PaginaCadastroProduto paginaCadastroProduto = new PaginaCadastroProduto();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Deseja cadastrar um produto? (S/N)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("S")) {
                paginaCadastroProduto.exibirPaginaCadastroProduto();
            } else {
                break;
            }
        }

        paginaCadastroProduto.exibirProdutosOrdenadosPorPreco();
    }
}