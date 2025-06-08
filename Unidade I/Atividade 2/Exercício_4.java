// Exercício 4: Verificação de parênteses balanceados com pilha
import java.util.Scanner;
import java.util.Stack;

public class Exercício_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a expressão: ");
        String expressao = scanner.nextLine();
        Stack<Character> pilha = new Stack<>();

        boolean balanceado = true;
        for (char c : expressao.toCharArray()) {
            if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                if (pilha.isEmpty()) {
                    balanceado = false;
                    break;
                }
                pilha.pop();
            }
        }

        if (balanceado && pilha.isEmpty()) {
            System.out.println("Expressão balanceada.");
        } else {
            System.out.println("Expressão não balanceada.");
        }

        scanner.close();
    }
}