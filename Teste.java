public class Teste {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice a = new Vertice(0);
        Vertice b = new Vertice(1);
        Vertice c = new Vertice(2);
        Vertice d = new Vertice(3);
        Vertice e = new Vertice(4);
        Vertice f = new Vertice(5);

        grafo.adicionarAresta(a, b, 2);
        grafo.adicionarAresta(b, c, 1);
        grafo.adicionarAresta(b, f, 4);
        grafo.adicionarAresta(c, d, 3);
        grafo.adicionarAresta(d, e, 1);
        grafo.adicionarAresta(d, f, 6);
        grafo.adicionarAresta(e, f, 2);

        Algoritimos algoritmo = new Algoritimos();

        System.out.println("Distancia minima vertice v1 ao v6: " + algoritmo.AlgoritmoDijkstra(grafo, a, f));

        Vertice v1 = new Vertice(1);
        Vertice v2 = new Vertice(2);
        Vertice v3 = new Vertice(3);
        Vertice v4 = new Vertice(4);
        Vertice v5 = new Vertice(5);

        Grafo grafo2 = new Grafo();

        grafo2.adicionarAresta(v1, v2, 1);
        grafo2.adicionarAresta(v2, v3, 1);
        grafo2.adicionarAresta(v3, v4, 1);
        grafo2.adicionarAresta(v4, v5, 1);
        grafo2.adicionarAresta(v5, v1, 1);

        System.out.println("Distancia minima vertice v1 ao v5: " + algoritmo.AlgoritmoDijkstra(grafo2, v1, v5));

        System.out.println("Ciclo eueleriano " + algoritmo.Fleury(grafo2));

    }
}
