//directed cycle detection
import java.util.*;
public class Cycledirected {
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

    graph[2].add(new Edge(2,4));

    graph[3].add(new Edge(3,5));
    graph[3].add(new Edge(3,4));

    graph[4].add(new Edge(4,5));

    graph[5].add(new Edge(5,3));

}
public static boolean isCycleDetection(ArrayList<Edge> graph[], boolean visArray[], boolean recStack[], int current){
    visArray[current] = true;
    recStack[current] = true;
    for(int i =0; i<graph[current].size(); i++){
        Edge e = graph[current].get(i);
        if(recStack[e.dest]){
            return true;}
        else if(!recStack[e.dest]){
            if(isCycleDetection(graph, visArray, recStack, e.dest)){
                return true;
            }
            } 
    }
    recStack[current] = false;
    return false;
}


public static void main(String args[]){
    int v = 6;
    ArrayList<Edge> graph[] = new ArrayList[v];
    createGraph(graph);
    boolean visArray[] = new boolean[v];
    boolean recStack[] = new boolean[v];
    for(int i=0; i<v; i++){
        if(!visArray[i]){
            boolean isCycle = isCycleDetection(graph, visArray, recStack, 0);
            if(isCycle){
                System.out.println(isCycle);
                break;
            }
        }
    }
}
}