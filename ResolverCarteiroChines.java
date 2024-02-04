import java.util.ArrayList;

public class ResolverCarteiroChines {

    public void AlgResolverCarteiroChines(Grafo grafo){
        Algoritmos algoritmos = new Algoritmos();

        if(algoritmos.verificaGrafoEuleriano(grafo)){
            System.out.println("Grafo Euleriano");
            ArrayList<Integer> ciclo = algoritmos.getCicloEuleriano(grafo, 1);
            int peso = algoritmos.getPeso();
            System.out.println("Ciclo Euleriano: ");
            for(int i = 0; i < ciclo.size(); i++){
                if(i == ciclo.size()-1){
                    System.out.print(ciclo.get(i));
                    break;
                }
                System.out.print(ciclo.get(i) + "->");
            }
            System.out.println("\nPeso do ciclo: " + peso);
        }else{
            Grafo grafoKN = algoritmos.criaGrafoKN(grafo);
            ArrayList<Integer> M = algoritmos.criaM(grafoKN);
            Grafo hipergrafo = algoritmos.criaHipergrafo(grafo, grafoKN, M);
            hipergrafo.imprimirGrafo();
            ArrayList<Integer> ciclo = algoritmos.getCicloEuleriano(hipergrafo, 1);
            int peso = algoritmos.getPeso();

            for(int i = 0; i < ciclo.size(); i++){
                if(i == ciclo.size()-1){
                    System.out.print(ciclo.get(i));
                    break;
                }
                System.out.print(ciclo.get(i) + "->");
            }

            System.out.println("\nPeso do ciclo: " + peso);
        }

        

    }
    
}