 // Exercício 9: Cadastro de clientes com classe Pessoa

import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    String endereco;

    Pessoa(String nome, int idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String toString() {
        return nome + ", " + idade + " anos, " + endereco;
    }
}

public class Exercício_9 {
    public static void main(String[] args) {
        ArrayList<Pessoa> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite nome, idade e endereço:");
            String nome = scanner.nextLine();
            int idade = Integer.parseInt(scanner.nextLine());
            String endereco = scanner.nextLine();
            clientes.add(new Pessoa(nome, idade, endereco));
        }

        System.out.println("Clientes cadastrados:");
        for (Pessoa p : clientes) {
            System.out.println(p);
        }
    }
}