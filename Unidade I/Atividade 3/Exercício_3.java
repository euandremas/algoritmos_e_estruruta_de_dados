// Exercício 3: Busca Linear

import java.util.Scanner;

public class Exercício_3 {
    public static int buscaLinear(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        System.out.println("Digite 5 números:");
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Qual número deseja buscar? ");
        int valor = scanner.nextInt();
        int resultado = buscaLinear(array, valor);
        System.out.println("Resultado: " + resultado);
        scanner.close();
        scanner.close();
    }
}