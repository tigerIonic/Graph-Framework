package GraphAlgorithms;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import Abstraction.AbstractListGraph;
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

	public static void parcoursEnLargeur(AbstractListGraph<AbstractNode> g){
		boolean[] mark = new boolean[g.getNbNodes()];
		for(int i = 0; i<g.getNbNodes(); i++){
			mark[i] = false;
		}
		int index = 0;
		Queue<AbstractNode> q= new PriorityQueue<AbstractNode>();
		AbstractNode v = g.getNodes().get(0);
		q.add(v);
		while (!q.isEmpty()){
			AbstractNode n = q.poll();

		}

	}




	public static void main(String[] args) {
		int[][] Matrix = GraphTools.generateGraphData(10, 20, false, false, true, 100001);
		GraphTools.afficherMatrix(Matrix);
		DirectedGraph<DirectedNode> al = new DirectedGraph<>(Matrix);
		System.out.println(al);

		// A completer

		//GraphToolsList.parcoursEnLargeur(al);

	}
}
