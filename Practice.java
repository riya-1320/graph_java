//graph implementation using adjacency list
import java.util.*;
public class Practice{
	static class Edge{
		int src;
		int dest;
		//constructor
		public Edge(int s, int d){
			this.src = s;
			this.dest = d;
		}
	}
	//method to create graph
	public static void createGraph(ArrayList<Edge>[] graph){
		//replace null value with empty arraylist in graph
		for(int i=0; i<graph.length; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		//insert element in graph
		graph[0].add(new Edge(0,1));
    graph[0].add(new Edge(0,2));

    graph[1].add(new Edge(1,3));
    graph[1].add(new Edge(1,0));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,4));

    graph[3].add(new Edge(3,5));

    graph[4].add(new Edge(4,2));
    graph[4].add(new Edge(4,5));

    graph[5].add(new Edge(5,6));
    graph[5].add(new Edge(5,4));
    graph[6].add(new Edge(6,5));

	}
       

	public static void main(String[] args){
		int v = 7;
        boolean visArray[] = new boolean[v];
		ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
		int dist[] = {1,2,3,4};
		for(int i:dist){
			System.out.println(i);
		}
        }
		

		
			

		
	}
