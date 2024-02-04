import java.util.ArrayList;
import java.util.Map;

public class ExemploFuncionamento {
    
    public static void main(String[] args) {
        Algoritmos algoritmos = new Algoritmos();
        Grafo grafo = new Grafo();

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;

        grafo.adicionarAresta(a, b, 1);
        grafo.adicionarAresta(b, c, 4);
        grafo.adicionarAresta(a, d, 1);
        grafo.adicionarAresta(d, e, 3);
        grafo.adicionarAresta(e, f, 1);
        grafo.adicionarAresta(f, c, 3);
        grafo.adicionarAresta(a, e, 2);
        grafo.adicionarAresta(b, f, 5);
        grafo.adicionarAresta(e, c, 1);

        grafo.imprimirGrafo();

        System.out.println("Grafo KN:");
        Grafo grafoKN = algoritmos.criaGrafoKN(grafo);
        grafoKN.imprimirGrafo();

        System.out.println("M*:");
        ArrayList<Integer> M = algoritmos.criaM(grafoKN);
        System.out.println(M);

        Map<Integer, Integer>distancias = algoritmos.dijkstra(grafo, 1);
        System.out.println("Distancias: " + distancias);

        System.out.println("Hipergrafo:");
        Grafo hipergrafo = algoritmos.criaHipergrafo(grafo, grafoKN, M);
        hipergrafo.imprimirGrafo();

        System.out.println("Quantidade de arestas: " + hipergrafo.quantidadeArestas());

        ArrayList<Integer> ciclo = algoritmos.getCicloEuleriano(hipergrafo, a);
        System.out.println("Ciclo Euleriano: ");
        for (int vertice : ciclo) {
            System.out.print(vertice + "->");
        }
    }

}
