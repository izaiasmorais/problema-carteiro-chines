public class Teste3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        Grafo grafo = new Grafo();
        grafo.adicionarAresta(a, b, 2);
        grafo.adicionarAresta(b, c, 1);
        grafo.adicionarAresta(c, d, 3);
        grafo.adicionarAresta(d, e, 1);
        grafo.adicionarAresta(e, f, 2);
        grafo.adicionarAresta(f, d, 6);
        grafo.adicionarAresta(f, b, 4);

        ResolverCarteiroChines resolver = new ResolverCarteiroChines();
        resolver.AlgResolverCarteiroChines(grafo);

        int a1 = 1;
        int b1 = 2;
        int c1 = 3;
        int d1 = 4;

        Grafo grafo1 = new Grafo();
        grafo1.adicionarAresta(a1, b1, 2);
        grafo1.adicionarAresta(b1, c1, 1);
        grafo1.adicionarAresta(c1, d1, 3);
        grafo1.adicionarAresta(d1, a1, 1);
        
        resolver.AlgResolverCarteiroChines(grafo1);


    }
}
