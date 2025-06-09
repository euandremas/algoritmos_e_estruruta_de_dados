// Exercício 7: DFS em Grafos

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;

public class Exercício_7 {
    public static void dfs(Map<String, List<String>> grafo, String inicio, Set<String> visitados) {
        visitados.add(inicio);
        System.out.println(inicio);

        for (String vizinho : grafo.get(inicio)) {
            if (!visitados.contains(vizinho)) {
                dfs(grafo, vizinho, visitados);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> mapa = new HashMap<>();
        mapa.put("Casa", Arrays.asList("Padaria", "Escola"));
        mapa.put("Padaria", Arrays.asList("Mercado"));
        mapa.put("Escola", new ArrayList<>());
        mapa.put("Mercado", new ArrayList<>());

        Set<String> visitados = new HashSet<>();
        dfs(mapa, "Casa", visitados);
    }
}
