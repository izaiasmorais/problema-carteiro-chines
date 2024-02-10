

public class TestesdeDesempenho {
    
    public static void main(String[] args) {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();

        Grafo grafoEuleriano30 = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano30, "Grafo Euleriano 30");

        Grafo grafoNaoEuleriano30 = CriarGrafoNaoEulerianoExemplo30();
        testes.Testador(grafoNaoEuleriano30, "Grafo Nao Euleriano(30 vertices)");

        Grafo grafoNaoEuleriano50 = CriarGrafoNaoEulerianoExemplo50();
        testes.Testador(grafoNaoEuleriano50, "Grafo Nao Euleriano(50 vertices)");

        Grafo grafoNaoEuleriano100 = CriarGrafoNaoEulerianoExemplo100();
        testes.Testador(grafoNaoEuleriano100, "Grafo Nao Euleriano(100 vertices)");
    }



    public void Testador(Grafo exGrafo, String TipodoGrafo){

        ResolverCarteiroChines ResolverCarteiroChines = new ResolverCarteiroChines();
        Grafo grafo = exGrafo;
        System.out.println("\nTeste de Desempenho para " + TipodoGrafo + ":\n");
        long somaTempos = 0;
        int numeroExecucoes = 1;
       // grafo.imprimirGrafo();
        for (int i = 0; i < numeroExecucoes; i++) {    // laço de desempenho
            //Grafo Grafo  = clones.get(i);
  

            long tempoInicial = System.currentTimeMillis();
            ResolverCarteiroChines.AlgResolverCarteiroChines(grafo); 
            long tempoFinal = System.currentTimeMillis();
            long tempoExecucao = tempoFinal - tempoInicial;

            somaTempos += tempoExecucao;  //somatório
        }


        // calcula e exibe a média
        long mediaTempos = somaTempos / numeroExecucoes;
        System.out.println( "\nTempo médio de execução do algoritmo do em " + TipodoGrafo + " é(são): " + mediaTempos + " nanosegundos");

    }
        

   // pegar exemplos pré-montados
    private static Grafo CriarGrafoEulerianoExemplo() {       
        Grafo grafo = new Grafo();
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(3, 4, 1);
        grafo.adicionarAresta(4, 5, 1);
        grafo.adicionarAresta(5, 6, 1);
        grafo.adicionarAresta(6, 7, 1);
        grafo.adicionarAresta(7, 8, 1);
        grafo.adicionarAresta(8, 9, 1);
        grafo.adicionarAresta(9, 10, 1);
        grafo.adicionarAresta(10, 11, 1);
        grafo.adicionarAresta(11, 12, 1);
        grafo.adicionarAresta(12, 13, 1);
        grafo.adicionarAresta(13, 14, 1);
        grafo.adicionarAresta(14, 15, 1);
        grafo.adicionarAresta(15, 16, 1);
        grafo.adicionarAresta(16, 17, 1);
        grafo.adicionarAresta(17, 18, 1);
        grafo.adicionarAresta(18, 19, 1);
        grafo.adicionarAresta(19, 20, 1);
        grafo.adicionarAresta(20, 21, 1);
        grafo.adicionarAresta(21, 22, 1);
        grafo.adicionarAresta(22, 23, 1);
        grafo.adicionarAresta(23, 24, 1);
        grafo.adicionarAresta(24, 25, 1);
        grafo.adicionarAresta(25, 26, 1);
        grafo.adicionarAresta(26, 27, 1);
        grafo.adicionarAresta(27, 28, 1);
        grafo.adicionarAresta(28, 29, 1);
        grafo.adicionarAresta(29, 30, 1);
        
        grafo.adicionarAresta(30, 1, 1);

        return grafo;
    }

    private static Grafo CriarGrafoNaoEulerianoExemplo30() {
            Grafo grafo = new Grafo();
            
            grafo.adicionarAresta(1, 2, 1);
            grafo.adicionarAresta(2, 3, 1);
            grafo.adicionarAresta(3, 4, 1);
            grafo.adicionarAresta(4, 5, 1);
            grafo.adicionarAresta(5, 6, 1);
            grafo.adicionarAresta(6, 7, 1);
            grafo.adicionarAresta(7, 8, 1);
            grafo.adicionarAresta(8, 9, 1);
            grafo.adicionarAresta(9, 10, 1);
            grafo.adicionarAresta(10, 11, 1);
            grafo.adicionarAresta(11, 12, 1);
            grafo.adicionarAresta(12, 13, 1);
            grafo.adicionarAresta(13, 14, 1);
            grafo.adicionarAresta(14, 15, 1);
            grafo.adicionarAresta(15, 16, 1);
            grafo.adicionarAresta(16, 17, 1);
            grafo.adicionarAresta(17, 18, 1);
            grafo.adicionarAresta(18, 19, 1);
            grafo.adicionarAresta(19, 20, 1);
            grafo.adicionarAresta(20, 21, 1);
            grafo.adicionarAresta(21, 22, 1);
            grafo.adicionarAresta(22, 23, 1);
            grafo.adicionarAresta(23, 24, 1);
            grafo.adicionarAresta(24, 25, 1);
            grafo.adicionarAresta(25, 26, 1);
            grafo.adicionarAresta(26, 27, 1);
            grafo.adicionarAresta(27, 28, 1);
            grafo.adicionarAresta(28, 29, 1);
            grafo.adicionarAresta(29, 30, 1);

            grafo.adicionarAresta(1, 3, 1);

        return grafo;
    }

        
    
    private static Grafo CriarGrafoNaoEulerianoExemplo50() {
        Grafo grafo = new Grafo();

        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(1, 3, 1);
        grafo.adicionarAresta(1, 4, 1);
        grafo.adicionarAresta(2, 3, 1);
        grafo.adicionarAresta(2, 4, 1);
        grafo.adicionarAresta(3, 4, 1);
        grafo.adicionarAresta(4, 5, 1);
        grafo.adicionarAresta(5, 6, 1);
        grafo.adicionarAresta(5, 7, 1);
        grafo.adicionarAresta(6, 7, 1);
        grafo.adicionarAresta(7, 8, 1);
        grafo.adicionarAresta(8, 9, 1);
        grafo.adicionarAresta(9, 10, 1);
        grafo.adicionarAresta(10, 11, 1);
        grafo.adicionarAresta(11, 12, 1);
        grafo.adicionarAresta(12, 13, 1);
        grafo.adicionarAresta(13, 14, 1);
        grafo.adicionarAresta(14, 15, 1);
        grafo.adicionarAresta(15, 16, 1);
        grafo.adicionarAresta(16, 17, 1);
        grafo.adicionarAresta(17, 18, 1);
        grafo.adicionarAresta(18, 19, 1);
        grafo.adicionarAresta(19, 20, 1);
        grafo.adicionarAresta(20, 21, 1);
        grafo.adicionarAresta(21, 22, 1);
        grafo.adicionarAresta(22, 23, 1);
        grafo.adicionarAresta(23, 24, 1);
        grafo.adicionarAresta(24, 25, 1);
        grafo.adicionarAresta(25, 26, 1);
        grafo.adicionarAresta(26, 27, 1);
        grafo.adicionarAresta(27, 28, 1);
        grafo.adicionarAresta(28, 29, 1);
        grafo.adicionarAresta(29, 30, 1);
        grafo.adicionarAresta(30, 31, 1);
        grafo.adicionarAresta(31, 32, 1);
        grafo.adicionarAresta(32, 33, 1);
        grafo.adicionarAresta(33, 34, 1);
        grafo.adicionarAresta(34, 35, 1);
        grafo.adicionarAresta(35, 36, 1);
        grafo.adicionarAresta(36, 37, 1);
        grafo.adicionarAresta(37, 38, 1);
        grafo.adicionarAresta(38, 39, 1);
        grafo.adicionarAresta(39, 40, 1);
        grafo.adicionarAresta(40, 41, 1);
        grafo.adicionarAresta(41, 42, 1);
        grafo.adicionarAresta(42, 43, 1);
        grafo.adicionarAresta(43, 44, 1);
        grafo.adicionarAresta(44, 45, 1);
        grafo.adicionarAresta(45, 46, 1);
        grafo.adicionarAresta(46, 47, 1);
        grafo.adicionarAresta(47, 48, 1);
        grafo.adicionarAresta(48, 49, 1);
        grafo.adicionarAresta(49, 50, 1);
    
        grafo.adicionarAresta(3, 10, 0);
        
        return grafo;
    }

    private static Grafo CriarGrafoNaoEulerianoExemplo100(){
        Grafo grafo = new Grafo();
        
        for (int i = 1; i <= 99; i++) {
            grafo.adicionarAresta(i, i + 1, 1);
        }
        grafo.adicionarAresta(100, 1, 1);
    
        grafo.adicionarAresta(1, 3, 1);
        grafo.adicionarAresta(3, 5, 1);
        grafo.adicionarAresta(5, 7, 1);
        grafo.adicionarAresta(7, 9, 1);

        return grafo;
    }
}


