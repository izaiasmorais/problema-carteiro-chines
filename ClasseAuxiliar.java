public class ClasseAuxiliar {

    public boolean todosVerticesPar(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getGrau() % 2 != 0 && vertice.getGrau() != 0) {
                return false;
            }
        }
        return true;
    }
    
}
