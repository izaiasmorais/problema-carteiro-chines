public class Aresta {
    private int verticeDestino;
    private int peso;

    public Aresta(int verticeDestino, int peso) {
        this.verticeDestino = verticeDestino;
        this.peso = peso;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public int getPeso() {
        return peso;
    }
}
