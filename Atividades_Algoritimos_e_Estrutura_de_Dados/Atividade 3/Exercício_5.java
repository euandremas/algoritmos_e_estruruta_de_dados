// Exercício 5: Representação de Grafos

import java.util.*;

public class Exercício_5 {
    Map<String, List<String>> adjacencias = new HashMap<>();

    void adicionarVertice(String v) {
        adjacencias.putIfAbsent(v, new ArrayList<>());
    }

    void adicionarAresta(String origem, String destino) {
        adjacencias.get(origem).add(destino);
    }

    void mostrarGrafo() {
        for (var entrada : adjacencias.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        Exercício_5 grafo = new Exercício_5();
        grafo.adicionarVertice("Centro");
        grafo.adicionarVertice("Shopping");
        grafo.adicionarAresta("Centro", "Shopping");
        grafo.mostrarGrafo();
    }
}