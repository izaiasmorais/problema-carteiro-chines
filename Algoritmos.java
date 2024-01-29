import java.util.*;

class Algoritmos {

    public Map<Integer, Integer> dijkstra(Grafo grafo, int verticeInicial) {
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<NoDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(NoDistancia::getDistancia));

        for (int vertice : grafo.getVertices()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }

        distancias.put(verticeInicial, 0);
        filaPrioridade.add(new NoDistancia(verticeInicial, 0));

        while (!filaPrioridade.isEmpty()) {
            int verticeAtual = filaPrioridade.poll().getVertice();

            for (Aresta aresta : grafo.getArestas(verticeAtual)) {
                int verticeAdjacente = aresta.getVerticeDestino();
                int novaDistancia = distancias.get(verticeAtual) + aresta.getPeso();

                if (novaDistancia < distancias.get(verticeAdjacente)) {
                    distancias.put(verticeAdjacente, novaDistancia);
                    filaPrioridade.add(new NoDistancia(verticeAdjacente, novaDistancia));
                }
            }
        }

        return distancias;
    }

    private class NoDistancia {
        private int vertice;
        private int distancia;

        public NoDistancia(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }

        public int getVertice() {
            return vertice;
        }

        public int getDistancia() {
            return distancia;
        }
    }

    public int dijkstra(Grafo grafo, int verticeInicial, int verticeFinal) {
        Map<Integer, Integer> distancias = dijkstra(grafo, verticeInicial);
        return distancias.get(verticeFinal);
    }

    public void Hierholzer(Grafo grafo, int verticeInicial){
        int numeroDeArestas = grafo.quantidadeArestas();
        Map<Integer, List<Aresta>> adjacencia = grafo.getAdjacencia();

        int verticeAtual = verticeInicial;

        System.out.println("Ciclo Euleriano: ");

        while (numeroDeArestas > 0) {
            int verticeAdjacente = adjacencia.get(verticeAtual).get(0).getVerticeDestino();
            System.out.println(verticeAtual + " -> " + verticeAdjacente);
            adjacencia.get(verticeAtual).remove(0);
            adjacencia.get(verticeAdjacente).remove(0);
            verticeAtual = verticeAdjacente;
            numeroDeArestas--;
        }

    }
}

