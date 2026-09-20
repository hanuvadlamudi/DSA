import java.util.ArrayList;

public class BellmanFord {
    static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void algorithm(ArrayList<Edge>[] graph,int src){
        int dis[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<graph.length-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dst;
                    int w = e.wt;

                    //relaxation step
                    if(dis[u] != Integer.MAX_VALUE && dis[u]+w < dis[v]){
                        dis[v] = dis[u] + w;
                    }
                }
            }
        }

        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

        algorithm(graph, 0);
    }
}