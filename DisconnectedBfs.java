import java.util.*;
public class DisconnectedBfs {
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
            graph[i] = new ArrayList<Edge>();
        }
        //add element
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void bfs(ArrayList<Edge> graph[], int v, boolean visitedArray[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(visitedArray[curr] == false){
                System.out.println(curr+ " ");
                visitedArray[curr] = true;
                for(int j=0; j<graph[curr].size(); j++){
                    Edge e = graph[curr].get(j);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args){
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean visitedArray[] = new boolean[v];
        for(int i=0; i<v; i++){
            if(visitedArray[i] == false){
                bfs(graph, v, visitedArray, i);
            }
        }
        }
    }
   