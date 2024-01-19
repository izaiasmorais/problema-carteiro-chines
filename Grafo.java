import java.util.ArrayList;
import java.util.List;

class Grafo {
    private List<Aresta> arestas;

    public Grafo() {
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(Vertice inicio, Vertice destino, int peso) {
        Aresta aresta = new Aresta(inicio, destino, peso);
        arestas.add(aresta);
    }
}