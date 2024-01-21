import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Algoritimos {

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
