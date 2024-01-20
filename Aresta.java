class Aresta {
    Vertice inicio;
    Vertice destino;
    int peso;

    public Aresta(Vertice inicio, Vertice destino, int peso) {
        this.inicio = inicio;
        this.destino = destino;
        this.peso = peso;
        inicio.grau++;
        destino.grau++;
    }

    public int getPeso() {
        return peso;
    }
}