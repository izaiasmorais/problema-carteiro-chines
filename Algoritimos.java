import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

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

    public List<Vertice> AlgoritmoHierholzer(Grafo grafo) {
        List<Vertice> cicloEuleriano = new ArrayList<>();

        // Verifica se o grafo possui um ciclo euleriano
        if (!verificarCicloEuleriano(grafo)) {
            System.out.println("O grafo não possui um ciclo euleriano.");
            return cicloEuleriano;
        }

        // Encontra um vértice com grau ímpar (se existir) ou escolhe o primeiro vértice
        Vertice inicio = encontrarVerticeInicio(grafo);

        // Executa o algoritmo de Hierholzer
        Stack<Vertice> pilha = new Stack<>();
        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.peek();

            if (atual.getGrau() == 0) {
                // Se o vértice não tem mais arestas, adiciona ao ciclo
                cicloEuleriano.add(atual);
                pilha.pop();
            } else {
                // Caso contrário, escolhe uma aresta, remove e adiciona o próximo vértice na pilha
                Aresta aresta = atual.getArestas().get(0);
                Vertice proximo = aresta.destino;
                atual.diminuirGrau();
                aresta.destino.diminuirGrau();
                pilha.push(proximo);
            }
        }

        return cicloEuleriano;
    }

    private boolean verificarCicloEuleriano(Grafo grafo) {
        // Verifica se cada vértice tem um grau par
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private Vertice encontrarVerticeInicio(Grafo grafo) {
        // Encontra um vértice com grau ímpar (se existir) ou escolhe o primeiro vértice
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0) {
                return vertice;
            }
        }
        return grafo.getVertices().get(0);
    }


}
