   // Exercício 8: Item mais frequente da lista
   
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercício_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> frequencia = new HashMap<>();
        System.out.println("Digite os códigos dos pedidos (0 para encerrar):");

        while (true) {
            int codigo = scanner.nextInt();
            if (codigo == 0) break;
            frequencia.put(codigo, frequencia.getOrDefault(codigo, 0) + 1);
        }

        int maisFrequente = -1, maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maisFrequente = entry.getKey();
            }
        }

        System.out.println("Item mais pedido: " + maisFrequente + " (" + maxFreq + " vezes)");
        scanner.close();
    }
}