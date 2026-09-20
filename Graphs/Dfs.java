import java.util.ArrayList;

public class Dfs {
    public static class Edge{
        int src;
        int dest;
        int wt;


        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void printGraph(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                printGraph(graph, e.dest, vis);
            }
        }
        
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,5));

        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));

        graph[3].add(new Edge(4,2,2));

        for(int i=0;i<graph[1].size();i++){

            Edge e = graph[1].get(i);
            System.out.print(e.dest+" ");
        }
        System.out.println();

        
        printGraph(graph, 0, new boolean[v]);
    }
}
