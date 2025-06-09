// Exercício 6: BFS em Grafos

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class Exercício_6 {
    public static void bfs(Map<String, List<String>> grafo, String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> fila = new LinkedList<>();
        fila.add(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            System.out.println(atual);

            for (String vizinho : grafo.get(atual)) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    fila.add(vizinho);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> mapa = new HashMap<>();
        mapa.put("Casa", Arrays.asList("Padaria", "Escola"));
        mapa.put("Padaria", Arrays.asList("Mercado"));
        mapa.put("Escola", new ArrayList<>());
        mapa.put("Mercado", new ArrayList<>());

        bfs(mapa, "Casa");
    }
}

