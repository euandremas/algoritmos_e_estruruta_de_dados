// Exercício 10: Sistema de estoque com classe Produto
import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    int quantidade;

    Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String toString() {
        return nome + ": " + quantidade + " unidades";
    }
}

public class Exercício_10 {
    public static void main(String[] args) {
        ArrayList<Produto> estoque = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Adicionar\n2 - Remover\n3 - Atualizar\n4 - Listar\n0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    estoque.add(new Produto(nome, qtd));
                }
                case 2 -> {
                    System.out.print("Nome do produto a remover: ");
                    String nome = scanner.nextLine();
                    estoque.removeIf(p -> p.nome.equalsIgnoreCase(nome));
                }
                case 3 -> {
                    System.out.print("Nome do produto a atualizar: ");
                    String nome = scanner.nextLine();
                    for (Produto p : estoque) {
                        if (p.nome.equalsIgnoreCase(nome)) {
                            System.out.print("Nova quantidade: ");
                            p.quantidade = scanner.nextInt();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Estoque atual:");
                    for (Produto p : estoque) {
                        System.out.println(p);
                    }
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}