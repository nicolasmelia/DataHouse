package dataStructures;
import java.util.ArrayList;


public class Graph {
	
	ArrayList<String> vertexList;
	ArrayList<Edge> edgeList;
	
	public Graph (){
		vertexList = new ArrayList<String>();
		edgeList = new ArrayList<Edge>();
	}
	
	
	public void addVertex(String vertex) {
		if (!vertexList.contains(vertex)) {
			vertexList.add(vertex);			
		}		
	}
	
	public void addEdge(int startVertex, int endVertex, int weight) {
		Edge edge =  new Edge(startVertex,endVertex,weight);
		edgeList.add(edge);
	}
	
}

 class Edge {
	 int startVertex;
	 int endVertex;
	 int weight = 0;
	 
	 public Edge (int startVertex, int endVertex, int weight) {
		 this.startVertex = startVertex;
		 this.endVertex = endVertex;
		 this.weight = weight;
	 }
}
