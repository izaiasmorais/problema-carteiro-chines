import java.util.ArrayList;
import java.util.List;

class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo() {
        this.arestas = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public void adicionarAresta(Vertice inicio, Vertice destino, int peso) {
        Aresta aresta = new Aresta(inicio, destino, peso);
        arestas.add(aresta);
        if (!vertices.contains(inicio)) {
            vertices.add(inicio);
        }
        if (!vertices.contains(destino)) {
            vertices.add(destino);
        }
    }

    public List<Vertice> getVertices() {
        return vertices;
    }
}