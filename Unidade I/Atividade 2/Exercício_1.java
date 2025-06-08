// Exercício 1: Inversão de Lista sem métodos prontos
import java.util.ArrayList;
import java.util.Scanner;

public class Exercício_1 {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 5 tarefas:");
        for (int i = 0; i < 5; i++) {
            tarefas.add(scanner.nextLine());
        }

        System.out.println("Tarefas em ordem inversa:");
        for (int i = tarefas.size() - 1; i >= 0; i--) {
            System.out.println(tarefas.get(i));
        }

        scanner.close();
    }
}