import java.util.List;
import java.util.Map;

public class Teste {
    
    public static void main(String[] args) {
        Algoritmos algoritmos = new Algoritmos();
        Grafo grafo = new Grafo();

        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(2, 3, 99);
        grafo.adicionarAresta(3, 4, 3);
        grafo.adicionarAresta(4, 5, 1);
        grafo.adicionarAresta(5, 6, 2);
        grafo.adicionarAresta(6, 4, 6);
        grafo.adicionarAresta(6, 2, 4);


        grafo.imprimirGrafo();


        Map<Integer, Integer> distancias = algoritmos.dijkstra(grafo, 1);

        for (int vertice : distancias.keySet()) {
            System.out.println("Distância do vértice 1 ao vértice " + vertice + ": " + distancias.get(vertice));
        }

        Grafo grafo2 = new Grafo();

        grafo2.adicionarAresta(1, 2, 2);
        grafo2.adicionarAresta(2, 3, 77);
        grafo2.adicionarAresta(3, 4, 1);
        grafo2.adicionarAresta(4, 1, 25);

        System.out.println("Distancia do v1 para o v3 = " + algoritmos.dijkstra(grafo2, 3, 1));

        grafo2.imprimirGrafo();

        algoritmos.Hierholzer(grafo2, 1);
    }

}
