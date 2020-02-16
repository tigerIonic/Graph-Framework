package GraphAlgorithms;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import Abstraction.AbstractListGraph;
import Abstraction.IDirectedGraph;
import Abstraction.IGraph;
import AdjacencyList.DirectedGraph;
import AdjacencyList.DirectedValuedGraph;
import AdjacencyList.UndirectedGraph;
import AdjacencyList.UndirectedValuedGraph;
import AdjacencyMatrix.AdjacencyMatrixDirectedValuedGraph;
import Collection.Triple;
import Nodes.AbstractNode;
import Nodes.DirectedNode;
import Nodes.UndirectedNode;

public class GraphToolsList  extends GraphTools {

	private static int _DEBBUG =0;

	private static int[] visite;
	private static int[] debut;
	private static int[] fin;
	private static List<Integer> order_CC;
	private static int cpt=0;

	//--------------------------------------------------
	// 				Constructors
	//--------------------------------------------------

	public GraphToolsList(){
		super();
	}

	// ------------------------------------------
	// 				Accessors
	// ------------------------------------------



	// ------------------------------------------
	// 				Methods
	// ------------------------------------------

	// A completer

	public static void parcoursEnProfondeur(DirectedGraph<DirectedNode> g){
		boolean[] mark = new boolean[g.getNbNodes()];
		for(int i=0 ; i<g.getNbNodes() ; i++){
			mark[i] = false;
		}
		Stack<DirectedNode> toVisit = new Stack<>();
		toVisit.add(g.getNodes().get(0));
		while (!toVisit.isEmpty()){
			DirectedNode v = toVisit.pop();
			for (int i = 0; i < g.getNbNodes(); i ++){
				if (g.isArc(v, g.getNodes().get(i))  && !mark[i]){
					mark[i] = true;
					toVisit.push(g.getNodes().get(i));
				}
			}
		}
	}

	public static void parcoursEnLargeur(DirectedGraph<DirectedNode> g){
		boolean[] mark = new boolean[g.getNbNodes()];
		for(int i=0 ; i<g.getNbNodes() ; i++){
			mark[i] = false;
		}
		Queue<DirectedNode> toVisit = new LinkedList<>();
		toVisit.add(g.getNodes().get(0));
		while (!toVisit.isEmpty()){
			DirectedNode v = toVisit.poll();
			for (int i = 0; i < g.getNbNodes(); i ++){
				if (g.isArc(v, g.getNodes().get(i))  && !mark[i]){
					mark[i] = true;
					toVisit.add(g.getNodes().get(i));
				}
			}
		}
	}

	void explorerSommet(AbstractNode s, Set<AbstractNode> a) {
		a.add(s);
/*
		for (AbstractNode t : s.) {
			if (!a.contains(t)) {
				explorerSommet(t,a);
			}
		}
		*/

	}

	void explorerGraphe(UndirectedGraph<UndirectedNode> g) {
		Set<AbstractNode> atteint = new HashSet<AbstractNode>();
		for (UndirectedNode s : g.getNodes()) {
			if (!atteint.contains(s)) {
				explorerSommet(s, atteint);
			}
		}
	}


	public static int[] bellman(AbstractListGraph<DirectedNode> g){
		// Initialisation
		int n = g.getNbNodes();
		List<DirectedNode> listNodes = g.getNodes();
		int[] v = new int[n];
		DirectedNode[] p = new DirectedNode[n];
		Arrays.fill(v, Integer.MAX_VALUE);
		v[0] = 0;
		p[0] = listNodes.get(0);
		for (int k = 0 ; k < n-1; k++){
			for (DirectedNode node : listNodes){
				if (v[node.getLabel()] != Integer.MAX_VALUE){
					for (Map.Entry<DirectedNode,Integer> entry : node.getSuccs().entrySet()){
						if ( v[entry.getKey().getLabel()]  > ( v[node.getLabel()] + entry.getValue() )){
							v[entry.getKey().getLabel()] =  v[node.getLabel()] + entry.getValue();
							p[entry.getKey().getLabel()] = node;
						}
					}
				}
			}
		}
		System.out.print("[");
		for (int c = 0 ; c < n ; c++){
			System.out.print(v[c] + ",");
		}
		System.out.println("]");

		return v;
	}
	
	public static int[] dijkstra(AbstractListGraph<DirectedNode> g){
		// Initialisation
		int n = g.getNbNodes();
		List<DirectedNode> listNodes = g.getNodes();
		int[] v = new int[n];
		boolean[] b = new boolean[n];
		DirectedNode[] p = new DirectedNode[n];
		Arrays.fill(v, Integer.MAX_VALUE);
		Arrays.fill(b, false);
		v[0] = 0;
		p[0] = listNodes.get(0);

		boolean isDone = false;
		while (!isDone){
			int nodeValue = Integer.MAX_VALUE;
			int index = 0;

			for (int i = 0 ; i<n; i++){
				if (v[i] <= nodeValue && !b[i]){
					index = i;
					nodeValue = v[index];
				}
			}

			b[index] = true;


			if (nodeValue != Integer.MAX_VALUE){
				for (Map.Entry<DirectedNode,Integer> entry : listNodes.get(index).getSuccs().entrySet()){
					if (v[entry.getKey().getLabel()] > v[index] + entry.getValue()){
						v[entry.getKey().getLabel()] =  v[index] + entry.getValue();
						p[entry.getKey().getLabel()] = listNodes.get(index);
					}
				}
			}


			isDone = true;
			for (boolean j : b){
				isDone = j && isDone;
			}
		}

		System.out.print("[");
		for (int c = 0 ; c < n ; c++){
			System.out.print(v[c] + ",");
		}
		System.out.println("]");

		return v;
	}


	void calculComposantesFortementConnexe(UndirectedGraph<UndirectedNode> g) {
        // TODO: 1. Ex´ecuter l’algorithme explorerGraphe() sur le graphe G et m´emoriser fin[].
        explorerGraphe(g);
        // TODO: 2. Inverser le graphe G par la proc´edure introduite durant le cours (transparent 32). Soit G−1 le graphe inverse de G.
        // TODO: 3. Ex´ecuter l’algorithme explorerGraphe() sur le graphe G−1 en appelant dans la boucle principale les sommets de G−1 par ordre d´ecroissant sur fin[].
    }

	public static void main(String[] args) {
		int[][] Matrix = GraphTools.generateGraphData(10, 20, false, false, true, 100001);
		GraphTools.afficherMatrix(Matrix);
		DirectedGraph<DirectedNode> al = new DirectedGraph<>(Matrix);
        UndirectedGraph<UndirectedNode> undirectedGraph = new UndirectedGraph<>(Matrix);

		// A completer

		GraphToolsList.parcoursEnProfondeur(al);
		
		int[][] matrixValued = GraphTools.generateValuedGraphData(5, false, false, true, false, 100001);
		DirectedValuedGraph al = new DirectedValuedGraph(matrixValued);
		GraphToolsList.bellman(al);
	}
}
