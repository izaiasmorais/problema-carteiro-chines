public class TestesdeDesempenho {
    
    public static void main() {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();



        Grafo grafoEuleriano = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano, "Grafo Euleriano");

        Grafo grafoNaoEuleriano = CriarGrafoNaoEulerianoExemplo();
        testes.Testador(grafoNaoEuleriano, "Grafo Nao Euleriano");

        Grafo grafoBipartido = CriarGrafoBipartidoExemplo();
        testes.Testador(grafoBipartido, "Grafo Bipartido");
        
        // Outros testes ?
    }



    public void Testador(Grafo exGrafo, String TipodoGrafo){
        Algoritmos algoritmos = new Algoritmos();
        Grafo grafo = exGrafo;

        // Teste de desempenho para o algoritmo de Dijkstra
        long tempoInicialDijkstra = System.currentTimeMillis();
        algoritmos.dijkstra(grafo, 1);
        long tempoFinalDijkstra = System.currentTimeMillis();
        System.out.println("Tempo de execução médio do algoritmo de Dijkstra em " + TipodoGrafo + " é(são): " + (tempoFinalDijkstra - tempoInicialDijkstra) + " milissegundos");
        }


    // Métodos para criar grafos de exemplo
    private static Grafo CriarGrafoEulerianoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }
    private static Grafo CriarGrafoNaoEulerianoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }
    private static Grafo CriarGrafoBipartidoExemplo() {
        Grafo grafo = new Grafo();

        return grafo;
    }

    
}


