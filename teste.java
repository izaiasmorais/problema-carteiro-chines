public class teste {
    public static void main(String[] args) {
        Algoritmos algoritmos = new Algoritmos();
        Grafo grafo = new Grafo();

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        grafo.adicionarAresta(a, b, 1);
        grafo.adicionarAresta(d, c, 4);
        grafo.adicionarAresta(a, d, 1);

        System.out.println("É CONEXO? " + algoritmos.ehConexo(grafo));

        ResolverCarteiroChines algResolveCarteiroChines = new ResolverCarteiroChines();

        algResolveCarteiroChines.AlgResolverCarteiroChines(grafo);

    }
}
