public class ExemploTesteDesenmpenho {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        ResolverCarteiroChines resolver = new ResolverCarteiroChines();

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


        long inicio = System.currentTimeMillis();
        resolver.AlgResolverCarteiroChines(grafo);
        long fim = System.currentTimeMillis();
        long tempoTotal = fim - inicio;
        System.out.println("Tempo de execução: " + tempoTotal + " milissegundos");
    }
}
