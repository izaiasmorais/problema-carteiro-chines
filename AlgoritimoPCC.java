public class AlgoritimoPCC {

    public boolean todosVerticesPar(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public int getCicloEuleriano(Grafo grafo) {
        if (!todosVerticesPar(grafo)) {
            return 0;
        }
        int ciclo = 0;
        for (Aresta aresta : grafo.getArestas()) {
            ciclo += aresta.getPeso();
        }
        return ciclo;
    }

    public void printaArestasCicloEuleriano(Grafo grafo) {
        if (!todosVerticesPar(grafo)) {
            System.out.println("Não existe ciclo euleriano");
            return;
        }
        System.out.println("Ciclo euleriano:");
        for (Aresta aresta : grafo.getArestas()) {
            System.out.println(aresta.inicio.getId() + " -> " + aresta.destino.getId());
        }
    }
    
}
