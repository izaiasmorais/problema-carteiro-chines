import java.util.ArrayList;

class Vertice {
    int id;
    int grau = 0;
    ArrayList<Aresta> arestas = new ArrayList<>();


    public Vertice(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getGrau() {
        return grau;
    }

    public void diminuirGrau() {
        grau--;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

}