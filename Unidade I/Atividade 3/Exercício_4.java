// Exercício 4: Busca Binária

import java.util.Scanner;

public class Exercício_4 {
    public static int buscaBinaria(int[] array, int valor) {
        int inicio = 0, fim = array.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio] == valor) return meio;
            else if (array[meio] < valor) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        System.out.println("Digite 5 números ordenados:");
        for (int i = 0; i < 5; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Qual número deseja buscar? ");
        var valor = scanner.nextInt();
        int resultado = buscaBinaria(array, valor);
        System.out.println("Resultado: " + resultado);

        scanner.close();
    }
}