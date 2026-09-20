// import java.util.*;
// public class HasPath {
//     public static class Edge{
//         int src;
//         int dest;
//         int wt;

//         public Edge(int s,int d,int w){
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }
//     public static void main(String[] args) {
//         int v = 5;
//         ArrayList<Edge>[] graph = new ArrayList[v];

//         for(int i=0;i<v;i++){
//             graph[i] = new ArrayList<>();
//         }

//         graph[0].add(new Edge(0,1,5));

//         graph[1].add(new Edge(1,0,5));
//         graph[1].add(new Edge(1,2,1));
//         graph[1].add(new Edge(1,3,3));

//         graph[2].add(new Edge(2,1,1));
//         graph[2].add(new Edge(2,3,1));
//         graph[2].add(new Edge(2,4,4));

//         graph[3].add(new Edge(4,2,2));

//         for(int i=0;i<graph[1].size();i++){

//             Edge e = graph[1].get(i);
//             System.out.print(e.dest+" ");
//         }

//         System.out.println();

//     }
// }

import java.util.ArrayList;

public class HasPath {
    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,boolean[] visit,int src,int dest){
        if(src == dest){
            return true;
        }

        visit[src] = true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!visit[e.dest] ){
                if(hasPath(graph, visit, e.dest, dest)){
                    return true;
                }
            } 
        }
        
        return false;
        
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(4, 2, 2));

        System.out.println(hasPath(graph, new boolean[v], 0, 3 ));
    }
}
