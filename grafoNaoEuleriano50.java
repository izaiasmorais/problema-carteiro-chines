import java.util.Random;

public class grafoNaoEuleriano50 {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        ResolverCarteiroChines resolver = new ResolverCarteiroChines();
        Random random = new Random();

        // Adiciona 50 vértices ao grafo
        for (int i = 1; i <= 50; i++) {
            grafo.adicionarVertice(i);
        }

        // Adiciona arestas aleatórias de forma a criar um grafo não euleriano
        for (int i = 1; i <= 50; i++) {
            int destino = (i % 50) + 1;  // Garante uma aresta para o próximo vértice
            int peso = random.nextInt(10) + 1;  // Peso aleatório entre 1 e 10
            grafo.adicionarAresta(i, destino, peso);
        }

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
