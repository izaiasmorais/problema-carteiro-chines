public class grafoNaoEuleriano15 {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        ResolverCarteiroChines resolver = new ResolverCarteiroChines();

        // Adiciona 15 vértices ao grafo
        for (int i = 1; i <= 15; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona arestas de forma a criar um grafo não euleriano
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 2);
        grafo.adicionarAresta(3, 4, 4);
        grafo.adicionarAresta(4, 5, 5);
        grafo.adicionarAresta(5, 1, 5);
        grafo.adicionarAresta(1, 6, 1);
        grafo.adicionarAresta(6, 7, 7);
        grafo.adicionarAresta(7, 8, 22);
        grafo.adicionarAresta(8, 9, 1);
        grafo.adicionarAresta(9, 1, 1);
        grafo.adicionarAresta(10, 11, 3);
        grafo.adicionarAresta(11, 12, 6);
        grafo.adicionarAresta(12, 13, 2);
        grafo.adicionarAresta(13, 14, 8);
        grafo.adicionarAresta(14, 15, 4);
        grafo.adicionarAresta(15, 10, 3);

        // Exibe o grafo
        grafo.imprimirGrafo();

        // Resolve o Problema do Carteiro Chinês
        long inicio = System.currentTimeMillis();
        resolver.AlgResolverCarteiroChines(grafo);
        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;
        System.out.println("Tempo de execução: " + tempoTotal + " milissegundos");
    }
}
