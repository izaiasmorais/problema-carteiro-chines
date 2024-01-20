import java.util.ArrayList;
import java.util.Iterator;
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
        inicio.arestas.add(aresta);
    }

    public void removerVertice(Vertice vertice) {
        Iterator<Aresta> iterator = arestas.iterator();
        while (iterator.hasNext()) {
            Aresta aresta = iterator.next();
            if (aresta.inicio.equals(vertice) || aresta.destino.equals(vertice)) {
                aresta.inicio.diminuirGrau();
                aresta.destino.diminuirGrau();
                iterator.remove();
            }
        }
        vertices.remove(vertice);
    }

    public void removerAresta(Aresta aresta) {
        arestas.remove(aresta);
        aresta.inicio.arestas.remove(aresta);
        aresta.inicio.diminuirGrau();
        aresta.destino.arestas.remove(aresta);
        aresta.destino.diminuirGrau();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }
}