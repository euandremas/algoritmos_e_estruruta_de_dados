// Verificador de Características de Um Produto

import java.util.Scanner;

public class Exercício_2 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código do produto: ");
        int codigoProduto = scanner.nextInt();

        // Verificando se o código do produto é par ou ímpar
        System.out.println("==== Verificador de Características de Um Produto ====");
        if (codigoProduto % 2 == 0) {
            System.out.println("O código do produto " + codigoProduto + " é PAR.");
        } else {
            System.out.println("O código do produto " + codigoProduto + " é ÍMPAR.");
        }

        scanner.close();

    }
}