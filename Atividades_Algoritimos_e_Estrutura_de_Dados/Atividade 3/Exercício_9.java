// Exercício 9: Caminho mais curto em Grafo Ponderado

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

class Aresta {
    String destino;
    int peso;

    Aresta(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

public class Exercício_9 {
    public static Map<String, Integer> dijkstra(Map<String, List<Aresta>> grafo, String origem) {
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> fila = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String vertice : grafo.keySet()) dist.put(vertice, Integer.MAX_VALUE);
        dist.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            for (Aresta aresta : grafo.get(atual)) {
                int novaDist = dist.get(atual) + aresta.peso;
                if (novaDist < dist.get(aresta.destino)) {
                    dist.put(aresta.destino, novaDist);
                    fila.add(aresta.destino);
                }
            }
        }
        return dist;
    }
}
