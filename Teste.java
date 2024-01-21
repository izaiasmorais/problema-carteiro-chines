import java.util.Map;

public class teste {
    
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(3, 4, 3);
        grafo.adicionarAresta(4, 5, 1);
        grafo.adicionarAresta(5, 6, 2);
        grafo.adicionarAresta(6, 4, 6);
        grafo.adicionarAresta(6, 2, 4);


        grafo.imprimirGrafo();

        Algoritmos algoritmos = new Algoritmos(grafo);

        Map<Integer, Integer> distancias = algoritmos.dijkstra(1);

        for (int vertice : distancias.keySet()) {
            System.out.println("Distância do vértice 1 ao vértice " + vertice + ": " + distancias.get(vertice));
        }
        
    }

}
