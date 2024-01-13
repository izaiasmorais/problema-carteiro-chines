public class Grafo {
    private int[][] matrizAdjacencia;

    // Construtor
    public Grafo(int numVertices) {
        this.matrizAdjacencia = new int[numVertices][numVertices];
    }

    // Método para atribuir uma matriz de adjacência diretamente
    public void atribuirMatriz(int[][] novaMatriz) {
        if (novaMatriz.length == matrizAdjacencia.length && novaMatriz[0].length == matrizAdjacencia[0].length) {
            for (int i = 0; i < novaMatriz.length; i++) {
                System.arraycopy(novaMatriz[i], 0, matrizAdjacencia[i], 0, novaMatriz[i].length);
            }
        } else {
            System.out.println("A nova matriz deve ter o mesmo tamanho que a matriz existente.");
        }
    }

    // Métodos para manipular a matriz, se necessário
    public void adicionarAresta(int verticeOrigem, int verticeDestino) {
        matrizAdjacencia[verticeOrigem][verticeDestino] = 1;
        matrizAdjacencia[verticeDestino][verticeOrigem] = 1;
    }

    // Outros métodos conforme necessário

    // Exemplo de método para exibir a matriz
    public void exibirMatriz() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método main para teste
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Criando um grafo com 5 vértices

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 0);

        grafo.exibirMatriz();
    }
}

