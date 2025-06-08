// Exercício 7: Ordem de chegada e saída
import java.util.LinkedList;
import java.util.Queue;

public class Exercício_7 {
    public static void main(String[] args) {
        Queue<String> clientes = new LinkedList<>();
        clientes.add("João");
        clientes.add("Maria");
        clientes.add("Carlos");
        clientes.add("Ana");

        System.out.println("Ordem de atendimento:");
        while (!clientes.isEmpty()) {
            System.out.println(clientes.poll());
        }
    }
}
