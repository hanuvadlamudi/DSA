import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra{
    static class Edge{
        int src;
        int dst;
        int wt;

        Edge(int src,int dst,int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        Pair(int n,int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }

    }

    public static void algorithm(ArrayList<Edge>[] graph,int src){
        boolean visit[] = new boolean[graph.length];
        int dist[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair cur = pq.remove();
            if(!visit[cur.n]){
                visit[cur.n] = true;

                for(int i=0;i<graph[cur.n].size();i++){
                    Edge e = graph[cur.n].get(i);
                    int u = e.src;
                    int v = e.dst;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(e.dst,dist[v]));
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        algorithm(graph, 0);
    }
}