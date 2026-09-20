import java.util.ArrayList;
import java.util.Collections;

public class Kruskals {
    static class Edge implements Comparable<Edge>{
        int src;
        int dst;
        int wt;

        public Edge(int src,int dst,int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    static int n = 4;
    static int[] rank = new int[n]; 
    static int[] par = new int[n];


    public static void init(){
        for(int i=0;i<n;i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }else{
            par[parA] = parB;
        }
    }

    public static void constructGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void algorithm(ArrayList<Edge> edges,int V){
        Collections.sort(edges);
        
        int count = 0;
        int maxCost = 0;

        for(int i=0;count<V-1;i++){
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dst);

            if(parA != parB){
                union(e.src, e.dst);
                maxCost += e.wt;
                count++;
            }

        }
        System.out.println(maxCost);
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        constructGraph(edges);
        init();
        algorithm(edges, V);
    }
}
