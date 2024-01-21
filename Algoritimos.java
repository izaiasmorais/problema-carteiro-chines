import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Algoritimos{

    public int AlgoritmoDijkstra(Grafo grafo, Vertice inicio, Vertice destino) {
        Map<Vertice, Integer> distanciaMinima = new HashMap<>();
        PriorityQueue<Vertice> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distanciaMinima::get));

        // Inicialização
        for (Vertice vertice : grafo.getVertices()) {
            distanciaMinima.put(vertice, Integer.MAX_VALUE);
            filaPrioridade.add(vertice);
        }
        distanciaMinima.put(inicio, 0);

        // Execução do algoritmo
        while (!filaPrioridade.isEmpty()) {
            Vertice atual = filaPrioridade.poll();
            for (Aresta aresta : atual.getArestas()) {
                int novaDistancia = distanciaMinima.get(atual) + aresta.peso;
                if (novaDistancia < distanciaMinima.get(aresta.destino)) {
                    distanciaMinima.put(aresta.destino, novaDistancia);
                    filaPrioridade.remove(aresta.destino);
                    filaPrioridade.add(aresta.destino);
                }
            }
        }

        return distanciaMinima.get(destino);
    }

    public List<Vertice> Fleury(Grafo grafo) {
        List<Vertice> caminhoEuleriano = new ArrayList<>();

        // Verifica se o grafo é euleriano
        if (!verificarGrafoEuleriano(grafo)) {
            System.out.println("O grafo não é euleriano.");
            return null;
        }

        // Encontra um vértice de grau ímpar (ou usa o primeiro vértice)
        Vertice verticeInicio = encontrarVerticeInicio(grafo);

        if (verticeInicio == null) {
            System.out.println("Não foi possível encontrar um vértice de grau ímpar.");
            return null;
        }

        // Executa o algoritmo Fleury
        FleuryRecursivo(grafo, verticeInicio, caminhoEuleriano);

        return caminhoEuleriano;
    }

    private void FleuryRecursivo(Grafo grafo, Vertice atual, List<Vertice> caminhoEuleriano) {
        while (!atual.getArestas().isEmpty()) {
            Aresta aresta = atual.getArestas().get(0);

            // Remove a aresta do grafo
            atual.getArestas().remove(aresta);
            aresta.destino.getArestas().remove(aresta);

            // Adiciona o destino ao caminho
            caminhoEuleriano.add(atual);
            caminhoEuleriano.add(aresta.destino);

            // Atualiza o vértice atual
            atual = aresta.destino;
        }
    }

    private boolean verificarGrafoEuleriano(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0) {
                return false; // O grafo não é euleriano
            }
        }
        return true; // O grafo é euleriano
    }

    private Vertice encontrarVerticeInicio(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0) {
                return vertice; // Encontrou um vértice de grau ímpar
            }
        }
        // Se não houver vértices de grau ímpar, retorna o primeiro vértice
        return grafo.getVertices().get(0);
    }
}