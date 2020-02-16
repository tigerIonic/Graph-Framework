# Graph-Framework

## AUTHOR : Ismail EL KHANTACHE  - Gaétan CEUTERICKX

This repository is used during the practice classes of "Graphe et algorithmes" course in IMT Atlantique.

This is a standard maven project so please use the according import option in your IDE (IntelliJ IDEA or Eclipse).

The bellman and dijkstra algorithms are in the Graph-Framework/src/main/java/GraphAlgorithms/GraphToolsList.java file.

Example to use it : 
```java

  int[][] matrixValued = GraphTools.generateValuedGraphData(5, false, false, true, false, 100001);
  DirectedValuedGraph al = new DirectedValuedGraph(matrixValued);
  
  GraphToolsList.bellman(al); // output: table of values
  GraphToolsList.dijkstra(al); // output: table of values

```
