import java.util.Scanner;

public class ArraysMatrizes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ARRAYS

        int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // Exemplo de uso do array numeros: imprimir todos os elementos
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
        int[] numeros2 = new int[5]; // Declaração de um array com 5 elementos

        numeros2[0] = 18; // Atribuindo valores aos elementos do array
        numeros2[1] = 12;
        numeros2[2] = 185;
        numeros2[3] = 14000;
        numeros2[4] = 365;
        // numeros2[5] = 20; // Isso causará um erro de ArrayIndexOutOfBoundsException,
        // pois o array tem apenas 5 elementos

        System.out.println(numeros2[0]); // Acessando o primeiro elemento do array

        // MATRIZES
        // Declaração de uma matriz 3x3
        int[][] matriz = { { 1, 2, 3 }, // linha 0
                { 4, 5, 6 }, // linha 1
                { 7, 8, 9 } }; // linha 2

        int[][] matriz2 = new int[3][3]; // Declaração de uma matriz 3x3 vazia

        System.out.println(matriz[2][0]); // Acessando linha 2, coluna 0 da matriz
        System.out.println(matriz2[1][1]); // Acessando linha 1, coluna 1 da matriz

        System.out.print("Digite um número: ");
        numeros[0] = Integer.parseInt(scanner.nextLine()); // Lendo um número do usuário e atribuindo ao primeiro
        System.out.println(numeros[0]); // elemento do array numeros
    }
}
