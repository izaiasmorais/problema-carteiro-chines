

public class TestesdeDesempenho {
    
    public static void main(String[] args) {
        
        TestesdeDesempenho testes = new TestesdeDesempenho();

        Grafo grafoEuleriano30 = CriarGrafoEulerianoExemplo();
        testes.Testador(grafoEuleriano30, "Grafo Euleriano (30 vertices)");

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
        System.out.println( "\nTempo médio de execução do algoritmo do em " + TipodoGrafo + " é(são): " + mediaTempos + " milissegundos");

    }
        

   // pegar exemplos pré-montados
    private static Grafo CriarGrafoEulerianoExemplo() {       
        Grafo grafo = new Grafo();
        for (int i = 1; i <= 29; i++) {
            grafo.adicionarAresta(i, i + 1, 1);
        }
        grafo.adicionarAresta(30, 1, 1);

        return grafo;
    }

    private static Grafo CriarGrafoNaoEulerianoExemplo30() {
            Grafo grafo = new Grafo();
            
            for (int i = 1; i <= 29; i++) {
                grafo.adicionarAresta(i, i + 1, 1);
            }

            grafo.adicionarAresta(1, 3, 1);

        return grafo;
    }

        
    
    private static Grafo CriarGrafoNaoEulerianoExemplo50() {
        Grafo grafo = new Grafo();

        for (int i = 1; i <= 49; i++) {
            grafo.adicionarAresta(i, i + 1, 1);
        }
    
        grafo.adicionarAresta(3, 10, 0);
        
        return grafo;
    }

    private static Grafo CriarGrafoNaoEulerianoExemplo100(){
        Grafo grafo = new Grafo();
        
        for (int i = 1; i <= 99; i++) {
            grafo.adicionarAresta(i, i + 1, 1);
        }

        grafo.adicionarAresta(3, 10, 1);


        return grafo;
    }
}


