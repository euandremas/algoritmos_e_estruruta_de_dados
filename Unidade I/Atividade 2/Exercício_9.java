// Exercício 9: Mesclar dois HashMaps
import java.util.HashMap;
import java.util.Map;

public class Exercício_9 {
    public static void main(String[] args) {
        Map<String, Integer> estoque1 = new HashMap<>();
        Map<String, Integer> estoque2 = new HashMap<>();

        estoque1.put("Mouse", 10);
        estoque1.put("Teclado", 5);
        estoque2.put("Mouse", 4);
        estoque2.put("Monitor", 3);

        for (Map.Entry<String, Integer> entry : estoque2.entrySet()) {
            estoque1.put(entry.getKey(), estoque1.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println("Estoque mesclado:");
        for (Map.Entry<String, Integer> entry : estoque1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
