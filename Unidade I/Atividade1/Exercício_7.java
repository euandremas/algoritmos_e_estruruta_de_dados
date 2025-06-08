// Exercício 7: Jogo da Velha básico

import java.util.Scanner;

public class Exercício_7 {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        char jogadorAtual = 'X';
        int jogadas = 0;

        while (true) {
            System.out.println("Tabuleiro:");
            for (char[] linha : tabuleiro) {
                for (char c : linha) {
                    System.out.print((c == '\u0000' ? '-' : c) + " ");
                }
                System.out.println();
            }

            System.out.println("Jogador " + jogadorAtual + " - linha e coluna (0-2):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (tabuleiro[linha][coluna] == '\u0000') {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;
            } else {
                System.out.println("Posição ocupada. Tente de novo.");
                continue;
            }

            // Verifica vitória
            if (verificaVitoria(tabuleiro, jogadorAtual)) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            if (jogadas == 9) {
                System.out.println("Empate!");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    public static boolean verificaVitoria(char[][] t, char j) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0] == j && t[i][1] == j && t[i][2] == j) return true;
            if (t[0][i] == j && t[1][i] == j && t[2][i] == j) return true;
        }
        return (t[0][0] == j && t[1][1] == j && t[2][2] == j) || (t[0][2] == j && t[1][1] == j && t[2][0] == j);
    }

}