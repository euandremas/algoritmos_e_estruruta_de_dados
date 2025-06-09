// Exercício 5: Inversão de lista com pilha
import java.util.ArrayList;
import java.util.Stack;

public class Exercício_5 {
    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<>();
        produtos.add("Notebook");
        produtos.add("Mouse");
        produtos.add("Teclado");
        produtos.add("Monitor");

        Stack<String> pilha = new Stack<>();
        for (String produto : produtos) {
            pilha.push(produto);
        }

        System.out.println("Produtos em ordem inversa:");
        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }
}