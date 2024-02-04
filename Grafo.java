import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
	private Map<Integer, List<Aresta>> adjacencia;

	public Grafo() {
		adjacencia = new HashMap<>();
	}

	public void adicionarVertice(int vertice) {
		if (!adjacencia.containsKey(vertice)) {
			adjacencia.put(vertice, new ArrayList<>());
		}
	}

	public void adicionarAresta(int vertice1, int vertice2, int peso) {
		adicionarVertice(vertice1);
		adicionarVertice(vertice2);

		Aresta aresta1 = new Aresta(vertice2, peso);
		Aresta aresta2 = new Aresta(vertice1, peso);

		adjacencia.get(vertice1).add(aresta1);
		adjacencia.get(vertice2).add(aresta2);
	}

	public List<Aresta> getArestas(int vertice) {
		return adjacencia.getOrDefault(vertice, new ArrayList<>());
	}

	public List<Integer> getVertices() {
		return new ArrayList<>(adjacencia.keySet());
	}

	public void imprimirGrafo() {
		for (int vertice : adjacencia.keySet()) {
			System.out.print("Vértice " + vertice + ": ");
			for (Aresta aresta : adjacencia.get(vertice)) {
				System.out.print("(" + aresta.getVerticeDestino() + ", " + aresta.getPeso() + ") ");
			}
			System.out.println();
		}
	}

	public int quantidadeArestas() {
		int quantidade = 0;
		for (int vertice : adjacencia.keySet()) {
			quantidade += adjacencia.get(vertice).size();
		}
		return quantidade / 2;
	}

	public Map<Integer, List<Aresta>> getAdjacencia() {
		return adjacencia;
	}

	public int getGrau(int vertice) {
		return adjacencia.get(vertice).size();
	}
}
