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

    public Grafo criaGrafoKN(Grafo grafo) {
        Grafo KN = new Grafo();
    
        Map<Integer, List<Aresta>> adjacencia = grafo.getAdjacencia();
    
        // Criar uma lista para armazenar os vértices com grau ímpar
        ArrayList<Integer> vertices = new ArrayList<>();
    
        for (int vertice : adjacencia.keySet()) {
            if (grafo.getGrau(vertice) % 2 != 0) {
                vertices.add(vertice);
            }
        }
        System.out.println("Vertices com grau ímpar: " + vertices);
    
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = i + 1; j < vertices.size(); j++) {
                int vertice1 = vertices.get(i);
                int vertice2 = vertices.get(j);
                int peso = dijkstra(grafo, vertice1, vertice2);
                KN.adicionarAresta(vertice1, vertice2, peso);
            }
        }

        return KN;
    }

    @SuppressWarnings("rawtypes")
    public List getCaminhoMinimo(Grafo grafo, int verticeInicial, int verticeFinal) {
        Map<Integer, Integer> distancias = dijkstra(grafo, verticeInicial);
        int distancia = distancias.get(verticeFinal);
        List<Integer> caminho = new ArrayList<>();
        caminho.add(verticeFinal);

        while (verticeFinal != verticeInicial) {
            for (Aresta aresta : grafo.getArestas(verticeFinal)) {
                int verticeAdjacente = aresta.getVerticeDestino();
                int distanciaAdjacente = distancias.get(verticeAdjacente);
                if (distanciaAdjacente + aresta.getPeso() == distancia) {
                    caminho.add(verticeAdjacente);
                    distancia = distanciaAdjacente;
                    verticeFinal = verticeAdjacente;
                    break;
                }
            }
        }

        Collections.reverse(caminho);
        return caminho;
    }

    public Grafo duplicaArestasDoCaminhoGrafo(Grafo grafo, List<Integer> caminho) {
        Grafo grafoComCaminhoDuplicado = grafo;

        for (int i = 0; i < caminho.size() - 1; i++) {
            int vertice1 = caminho.get(i);
            int vertice2 = caminho.get(i + 1);
            int peso = dijkstra(grafo, vertice1, vertice2);
            grafoComCaminhoDuplicado.adicionarAresta(vertice1, vertice2, peso);
        }

        return grafoComCaminhoDuplicado;
    }

    public Grafo umEmparelhamentoHeuristico(Grafo grafo, Grafo grafoKN){

        Grafo hipergrafoG = grafo;
        
       if(grafoKN.getAdjacencia().size() % 2 != 0){
            for(int i = 0;i<grafoKN.getAdjacencia().size() - 1 ;i+=2){
                @SuppressWarnings("unchecked")
                List<Integer> caminho = getCaminhoMinimo(grafo, i, i+1);
                duplicaArestasDoCaminhoGrafo(hipergrafoG, caminho);
            }

       }else{
            for(int i = 0;i<grafoKN.getAdjacencia().size();i+=2){
                @SuppressWarnings("unchecked")
                List<Integer> caminho = getCaminhoMinimo(grafo, i, i+1);
                duplicaArestasDoCaminhoGrafo(hipergrafoG, caminho);
            }
        }
        return hipergrafoG;
    }
}