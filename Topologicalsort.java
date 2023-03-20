//dag topological sort
import java.util.*;

public class Topologicalsort {
    static class Edge{
        int src;
        int des;

        public Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,2));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], boolean visArray[], int current, Stack<Integer> stack){
        visArray[current] = true;
        for(int i=0; i<graph[current].size(); i++){
            Edge e = graph[current].get(i);
            if(! visArray[e.des]){
                topologicalSort(graph, visArray, e.des, stack);
            }
        }
        stack.push(current);
    }

    public static void main(String args[]){
        int v=6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        boolean visArray[] = new boolean[v];
        createGraph(graph);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<v; i++){
            if(!visArray[i]){
                topologicalSort(graph, visArray, i, stack);
            }
        }
        while(!stack.isEmpty()){
        System.out.println(stack.pop()+" ");
        }
    }
}
