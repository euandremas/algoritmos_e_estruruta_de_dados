// Contagem de Clientes em um Estabelecimento

public class Exercício_3 {

        public static void main(String[] args) {
        int numeroDeClientes = 10; // Número de clientes no estabelecimento

        // Exibindo a contagem de clientes de 1 a 10

        System.out.println("==== Contagem de Clientes ====");
        for (int i = 1; i <= numeroDeClientes; i++) {
            System.out.println("Cliente " + i);
            if (i % 10 == 0) {
                System.out.println("Total de clientes ao final da hora: " + numeroDeClientes);

            }
        }

    }
}