public class main {

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
    }
}
        