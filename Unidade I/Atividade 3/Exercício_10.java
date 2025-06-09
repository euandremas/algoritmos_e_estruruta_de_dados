// Exercício 10: Ordenação Topológica

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class Exercício_10 {
    public static void ordenacaoTopologica(Map<String, List<String>> grafo) {
        Set<String> visitado = new HashSet<>();
        Stack<String> pilha = new Stack<>();

        for (String vertice : grafo.keySet()) {
            if (!visitado.contains(vertice)) {
                dfsTopo(grafo, vertice, visitado, pilha);
            }
        }

        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    private static void dfsTopo(Map<String, List<String>> grafo, String v, Set<String> visitado, Stack<String> pilha) {
        visitado.add(v);
        for (String vizinho : grafo.get(v)) {
            if (!visitado.contains(vizinho)) {
                dfsTopo(grafo, vizinho, visitado, pilha);
            }
        }
        pilha.push(v);
    }
}

