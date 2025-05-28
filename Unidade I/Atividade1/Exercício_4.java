import java.util.ArrayList;
import java.util.Scanner;

public class Exercício_4 {

    // Organizando uma Lista de Espera Dinâmica

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaEspera = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n==== Lista de Espera ====");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Remover cliente");
            System.out.println("3. Exibir lista de espera");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente a adicionar: ");
                    String nomeAdicionar = scanner.nextLine();
                    listaEspera.add(nomeAdicionar);
                    System.out.println(nomeAdicionar + " foi adicionado à lista.");
                    break;
                case 2:
                    System.out.print("Nome do cliente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    if (listaEspera.remove(nomeRemover)) {
                        System.out.println(nomeRemover + " foi removido da lista.");
                    } else {
                        System.out.println("Cliente não encontrado na lista.");
                    }
                    break;
                case 3:
                    System.out.println("\nClientes na lista de espera:");
                    if (listaEspera.isEmpty()) {
                        System.out.println("Nenhum cliente aguardando.");
                    } else {
                        for (int i = 0; i < listaEspera.size(); i++) {
                            System.out.println((i + 1) + ". " + listaEspera.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
