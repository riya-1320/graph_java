import java.util.*;
//code
public class Dfs {
     static class Edge{
        int src;
        int dest;
        //constructor
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    //cretegraph method
    
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //add element
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));
        graph[6].add(new Edge(6,5));

    }
    public static void dfs(ArrayList<Edge> graph[], boolean visitedArray[], int current){
        
        System.out.println(current);
        visitedArray[current] = true;
        for(int i=0; i<graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(visitedArray[e.dest] == false)
                dfs(graph, visitedArray, e.dest);
        }
    }

    public static void main(String[] args){
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visitedArray[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(visitedArray[i] == false)
            dfs(graph, visitedArray, i);  
        }
           
    }
}