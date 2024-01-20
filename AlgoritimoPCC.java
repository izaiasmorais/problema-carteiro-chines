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

    public void AlgoritimoHierholzer(Grafo grafo){

        if (!todosVerticesPar(grafo)) {
            System.out.println("Não existe ciclo euleriano");
            return;
        }

        int pesodociclo = getCicloEuleriano(grafo);

        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() > 0) {
                System.out.println("Ciclo euleriano:");
                System.out.print(vertice.getId() + " -> ");
                Vertice atual = vertice;
                while (atual.getGrau() > 0) {
                    Aresta aresta = atual.getArestas().get(0);
                    System.out.print(aresta.destino.getId());
                    atual = aresta.destino;
                    grafo.removerAresta(aresta);
                    if(atual.getArestas().size() != 0){
                        System.out.print(" -> ");
                    }

                }
            }
        }
        System.out.println("\nPeso do ciclo = " + pesodociclo +"\n");
    }
    

    public void printaArestasSort(Grafo grafo){
        grafo.getVertices().forEach((vertice) -> {
            vertice.getArestas().sort((aresta1, aresta2) -> {
                return aresta1.destino.getId() - aresta2.destino.getId();
            });
        });

        for (Aresta aresta : grafo.getArestas()) {
            System.out.println(aresta.inicio.getId() + " -> " + aresta.destino.getId());
        }
    }

}
