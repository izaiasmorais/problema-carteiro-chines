import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;

public class AlgoritimoPCC {

    public boolean todosVerticesPar(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0 && vertice.getGrau() != 0) {
                return false;
            }
        }
        return true;
    }

    public int getCicloEuleriano(Grafo grafo) {
        if (!todosVerticesPar(grafo)) {
            return 0;
        }
        int ciclo = 0;
        for (Aresta aresta : grafo.getArestas()) {
            ciclo += aresta.getPeso();
        }
        return ciclo;
    }

    public void AlgoritmoHierholzer(Grafo grafo) {
        List<Vertice> circuito = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();
        Map<Vertice, List<Aresta>> arestasNaoVisitadas = new HashMap<>();
    
        // Inicialização
        for (Vertice v : grafo.getVertices()) {
            arestasNaoVisitadas.put(v, new ArrayList<>(v.arestas));
        }
    
        // Encontre um vértice com grau ímpar para iniciar (ou qualquer vértice se todos tiverem grau par)
        Vertice inicio = null;
        for (Vertice v : grafo.getVertices()) {
            if (v.grau % 2 != 0) {
                inicio = v;
                break;
            }
        }
    
        if (inicio == null) {
            inicio = grafo.getVertices().get(0);
        }
    
        pilha.push(inicio);
    
        while (!pilha.isEmpty()) {
            Vertice atual = pilha.peek();
    
            if (!arestasNaoVisitadas.get(atual).isEmpty()) {
                Vertice proximo = arestasNaoVisitadas.get(atual).get(0).destino;
                arestasNaoVisitadas.get(atual).remove(0);
                pilha.push(proximo);
            } else {
                circuito.add(atual);
                pilha.pop();
            }
        }
    
        // O circuito agora contém o ciclo Euleriano
        Collections.reverse(circuito);
    
        // Imprime o circuito Euleriano
        System.out.println("Circuito Euleriano: " + circuito.stream().map(Vertice::toString).collect(Collectors.joining(" -> ")));
    }
    

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
}
