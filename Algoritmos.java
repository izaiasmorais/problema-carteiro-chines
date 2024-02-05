import java.util.*;

class Algoritmos {

	int peso = 0;

	public Map<Integer, Integer> dijkstra(Grafo grafo, int verticeInicial) {
		Map<Integer, Integer> distancias = new HashMap<>();
		PriorityQueue<NoDistancia> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(NoDistancia::getDistancia));

		for (int vertice : grafo.getVertices()) {
			distancias.put(vertice, Integer.MAX_VALUE);
		}

		distancias.put(verticeInicial, 0);
		filaPrioridade.add(new NoDistancia(verticeInicial, 0));

		while (!filaPrioridade.isEmpty()) {
			int verticeAtual = filaPrioridade.poll().getVertice();

			for (Aresta aresta : grafo.getArestas(verticeAtual)) {
				int verticeAdjacente = aresta.getVerticeDestino();
				int novaDistancia = distancias.get(verticeAtual) + aresta.getPeso();

				if (novaDistancia < distancias.get(verticeAdjacente)) {
					distancias.put(verticeAdjacente, novaDistancia);
					filaPrioridade.add(new NoDistancia(verticeAdjacente, novaDistancia));
				}
			}
		}

		return distancias;
	}

	private class NoDistancia {
		private int vertice;
		private int distancia;

		public NoDistancia(int vertice, int distancia) {
			this.vertice = vertice;
			this.distancia = distancia;
		}

		public int getVertice() {
			return vertice;
		}

		public int getDistancia() {
			return distancia;
		}
	}

	public int dijkstra(Grafo grafo, int verticeInicial, int verticeFinal) {
		Map<Integer, Integer> distancias = dijkstra(grafo, verticeInicial);
		return distancias.get(verticeFinal);
	}

	public ArrayList<Integer> getCicloEuleriano(Grafo grafo, int verticeInicial) {
		Map<Integer, List<Aresta>> adjacencia = grafo.getAdjacencia();
		ArrayList<Integer> ciclo = new ArrayList<>();
		int peso = 0;
		ciclo.add(verticeInicial);
		int verticeAtual = verticeInicial;
		int verticeProximo = 0;
		int i = 0;																								//  contador não usado
		while (adjacencia.get(verticeInicial).size() > 0) {
			verticeProximo = adjacencia.get(verticeAtual).get(0).getVerticeDestino();
			peso += adjacencia.get(verticeAtual).get(0).getPeso();
			adjacencia.get(verticeAtual).remove(0);
			for (int j = 0; j < adjacencia.get(verticeProximo).size(); j++) {
				if (adjacencia.get(verticeProximo).get(j).getVerticeDestino() == verticeAtual) {
					peso += adjacencia.get(verticeProximo).get(j).getPeso();
					adjacencia.get(verticeProximo).remove(j);
					break;
				}
			}
			ciclo.add(verticeProximo);
			verticeAtual = verticeProximo;
			i++;
		}
		this.peso = peso;
		return ciclo;
	}

	public int getPesoCicloEuleriano(Grafo grafo, ArrayList<Integer> ciclo) {
		int peso = 0;
		for (int i = 0; i < ciclo.size() - 1; i++) {
			peso += dijkstra(grafo, ciclo.get(i), ciclo.get(i + 1));
		}
		return peso;
	}

	public Grafo criaGrafoKN(Grafo grafo) {
		Grafo KN = new Grafo();

		Map<Integer, List<Aresta>> adjacencia = grafo.getAdjacencia();

		ArrayList<Integer> vertices = new ArrayList<>();

		for (int vertice : adjacencia.keySet()) {
			if (grafo.getGrau(vertice) % 2 != 0) {
				vertices.add(vertice);
			}
		}

		for (int i = 0; i < vertices.size(); i++) {
			for (int j = i + 1; j < vertices.size(); j++) {
				int vertice1 = vertices.get(i);
				int vertice2 = vertices.get(j);
				int peso = dijkstra(grafo, vertice1, vertice2);
				KN.adicionarAresta(vertice1, vertice2, peso);
			}
		}

		return KN;
	}

	@SuppressWarnings("rawtypes")
	public List getCaminhoMinimo(Grafo grafo, int verticeInicial, int verticeFinal) {
		Map<Integer, Integer> distancias = dijkstra(grafo, verticeInicial);
		int distancia = distancias.get(verticeFinal);
		List<Integer> caminho = new ArrayList<>();
		caminho.add(verticeFinal);

		while (verticeFinal != verticeInicial) {
			for (Aresta aresta : grafo.getArestas(verticeFinal)) {
				int verticeAdjacente = aresta.getVerticeDestino();
				int distanciaAdjacente = distancias.get(verticeAdjacente);
				if (distanciaAdjacente + aresta.getPeso() == distancia) {
					caminho.add(verticeAdjacente);
					distancia = distanciaAdjacente;
					verticeFinal = verticeAdjacente;
					break;
				}
			}

		}

		Collections.reverse(caminho);
		return caminho;
	}

	public Grafo duplicaArestasDoCaminhoGrafo(Grafo grafo, List<Integer> caminho) {
		Grafo grafoComCaminhoDuplicado = grafo;

		for (int i = 0; i < caminho.size() - 1; i++) {
			int vertice1 = caminho.get(i);
			int vertice2 = caminho.get(i + 1);
			int peso = dijkstra(grafo, vertice1, vertice2);
			grafoComCaminhoDuplicado.adicionarAresta(vertice1, vertice2, peso);
		}

		return grafoComCaminhoDuplicado;
	}

	public ArrayList<Integer> criaM(Grafo KN) {

		ArrayList<Integer> emparelhamento = new ArrayList<>();
		Map<Integer, List<Aresta>> adjacencia = KN.getAdjacencia();

		for (int vertice : adjacencia.keySet()) {
			if (KN.getGrau(vertice) % 2 != 0) {
				emparelhamento.add(vertice);
			}
		}
		return emparelhamento;
	}

	public Grafo criaHipergrafo(Grafo grafo, Grafo KN, ArrayList<Integer> M) {
		Grafo hiperGrafo = grafo;

		for (int i = 0; i < KN.getAdjacencia().size(); i += 2) {
			int vertice1 = M.get(i);
			int vertice2 = M.get(i + 1);
			@SuppressWarnings("unchecked")
			List<Integer> caminho = getCaminhoMinimo(grafo, vertice1, vertice2);
			hiperGrafo = duplicaArestasDoCaminhoGrafo(hiperGrafo, caminho);
		}

		return hiperGrafo;
	}

	public Boolean verificaGrafoEuleriano(Grafo grafo) {
		for (int vertice : grafo.getVertices()) {
			if (grafo.getGrau(vertice) % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	public int getPeso() {
		return peso;
	}
}
