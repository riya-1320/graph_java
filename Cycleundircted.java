//directed cycle detection
import java.util.*;
public class Cycleundircted {
    static class Edge{
        int src;
        int dest;
        //constructor
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
  
public static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<Edge>();
    }
    //add element
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
public static boolean isCycleDetection(ArrayList<Edge> graph[], boolean visArray[], int current, int parent){
    visArray[current] = true;
    for(int i=0; i<graph[current].size();i++){
        Edge e = graph[current].get(i);
        if(visArray[e.dest] && e.dest != parent){
            return true;
        }
        else if(! visArray[e.dest])
        {
            if(isCycleDetection(graph, visArray,e.dest,current))
                return true;
        }
    }
    return false;
}


public static void main(String args[]){
    int v = 7; 
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    boolean visArray[] = new boolean[v];
   
            System.out.println(isCycleDetection(graph, visArray, 0, 0));
            
        
}
}