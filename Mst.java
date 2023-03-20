//graph implementation using adjacency list
//prims Algorithm
import java.util.*;
public class Mst{
	static class Edge{
		int src;
		int dest;
		int weight;
		//constructor
		public Edge(int s, int d, int w){
			this.src = s;
			this.dest = d;
			this.weight = w;
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
		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));
        
		graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

		graph[2].add(new Edge(2,1,15));
		graph[2].add(new Edge(2,3,50));

		graph[3].add(new Edge(3,0,15));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
	}

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int n, int c){
            this.node  = n;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }

    }
    public static void mst(ArrayList<Edge> graph[], int v){
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        int mstCost = 0;
        boolean visArray[] = new boolean[v];
        pq.add(new Pair(0,0));
        while(! pq.isEmpty()){
            Pair current = pq.remove();
            if(!visArray[current.node]){
                visArray[current.node] = true;
                mstCost+=current.cost;
            
                for(int i=0; i<graph[current.node].size(); i++){
                    Edge e = graph[current.node].get(i);
                    if(!visArray[e.dest]){
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println(mstCost);
    }

	public static void main(String[] args){
		int v = 4;
		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);
        mst(graph, v);

		
			

		
	}
}