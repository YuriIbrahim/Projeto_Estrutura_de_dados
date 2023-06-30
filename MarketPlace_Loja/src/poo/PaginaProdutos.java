package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

public class PaginaProdutos {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Guitarra", 2000.0));
        produtos.add(new Produto("Baixo", 1500.0));
        produtos.add(new Produto("Bateria", 3000.0));
        produtos.add(new Produto("Microfone", 500.0));
        produtos.add(new Produto("Amplificador", 2500.0));

        System.out.println("Selecione a forma de filtragem dos preços:");
        System.out.println("1. Do maior para o menor preço");
        System.out.println("2. Do menor para o maior preço");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Produtos - Maior para o Menor Preço:");
                Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco).reversed());
                break;
            case 2:
                System.out.println("Produtos - Menor para o Maior Preço:");
                Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco));
                break;
            default:
                System.out.println("Opção inválida. Exibindo produtos em ordem padrão:");
                break;
        }

        exibirProdutos(produtos);
    }

    public static void exibirProdutos(List<Produto> produtos) {
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + " | Preço: " + produto.getPreco());
        }
    }
}