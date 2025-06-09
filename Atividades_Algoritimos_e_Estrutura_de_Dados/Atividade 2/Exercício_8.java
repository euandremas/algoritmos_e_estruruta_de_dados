// Exercício 8: Contagem de palavras com HashMap
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercício_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();
        String[] palavras = frase.toLowerCase().split(" ");

        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }

        System.out.println("Frequência das palavras:");
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}