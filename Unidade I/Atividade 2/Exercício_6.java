// Exercício 6: Fila de espera em uma clínica
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercício_6 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Adicionar paciente\n2 - Atender paciente\n3 - Exibir fila\n0 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do paciente: ");
                    fila.add(scanner.nextLine());
                }
                case 2 -> {
                    if (!fila.isEmpty()) {
                        System.out.println("Atendendo: " + fila.poll());
                    } else {
                        System.out.println("Fila vazia.");
                    }
                }
                case 3 -> System.out.println("Fila de espera: " + fila);
            }
        } while (opcao != 0);

        scanner.close();
    }
}