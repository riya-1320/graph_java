//strongly connected graph
import java.util.*;

public class Kosaraju {
    static class Edge{
        int source;
        int destination;

        public Edge(int s, int d){
            this.source = s;
            this.destination = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[], int v){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }

    public static void topSort(ArrayList<Edge> graph[], Stack<Integer> stack, boolean visArray[], int current){
        visArray[current] = true;
        for(int i=0; i<graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(!visArray[e.destination]){
                topSort(graph, stack,visArray,e.destination);
            }
        }
        stack.push(current);
    }

    public static void dfs(ArrayList<Edge> transposeGraph[], boolean visArray[], int current){
        visArray[current] = true;
        System.out.print(current+ " ");

        for(int i=0; i<transposeGraph[current].size(); i++){
            Edge e = transposeGraph[current].get(i);
            if(!visArray[e.destination]){
                dfs(transposeGraph, visArray, e.destination);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[], int v){

        //step 1--> create stack and add nodes in topological sort order

        Stack<Integer> s = new Stack<>();
        boolean visArray[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(!visArray[i]){
                topSort(graph,s,visArray,i);
            }
            
        }

        //step 2 --> create transpose of graph
        ArrayList<Edge> transposeGraph[] = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            visArray[i] = false;
            transposeGraph[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < v; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);//e.dest-->e.src, e.src-->e.dest
                transposeGraph[e.destination].add(new Edge(e.destination, e.source));
            }
        }

        //step 3 --> apply dfs in transpose graph acc to topological sort
        while(!s.isEmpty()){
            int curr = s.pop();
                if(!visArray[curr]){
                    System.out.print ("SCC: ");
                    dfs(transposeGraph, visArray, curr);
                    System.out.println();
                }
            }
          
        }    
        


    

    public static void main(String args[]){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph, v);
        kosaraju(graph, v);
    }
}

