package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import AdjacencyList.DirectedGraph;
import AdjacencyList.DirectedValuedGraph;
import AdjacencyList.UndirectedGraph;
import AdjacencyList.UndirectedValuedGraph;
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

	public static void parcoursEnProfondeur(UndirectedGraph g){

	}

	public static void parcoursEnLargeur(UndirectedGraph g){

	}

	void explorerSommet(AbstractNode s, Set<AbstractNode> a) {
		a.add(s);

		for (AbstractNode t : s.) {
			if (!a.contains(t)) {
				explorerSommet(t,a);
			}
		}
	}
	void explorerGraphe(UndirectedGraph g) {
		Set<AbstractNode> atteint = new HashSet<AbstractNode>();
		for (UndirectedNode s : g.getNodes()) {
			if (!atteint.contains(s)) {
				explorerSommet(s, atteint);
			}
		}
	}


	public static void main(String[] args) {
		int[][] Matrix = GraphTools.generateGraphData(10, 20, false, false, true, 100001);
		GraphTools.afficherMatrix(Matrix);
		DirectedGraph<DirectedNode> al = new DirectedGraph<>(Matrix);
		System.out.println(al);

		// A completer
	}
}
