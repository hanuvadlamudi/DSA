import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
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
        int v;
        int cost;

        public Pair(int v,int cost){
            this.v = v;
            this.cost = cost;
        }


        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void mst(ArrayList<Edge>[] graph){
        boolean visit[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int finalcost = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair cur = pq.remove();

            if(!visit[cur.v]){
                visit[cur.v] = true;

                finalcost += cur.cost;

                for(int i=0;i<graph[cur.v].size();i++){
                    Edge e = graph[cur.v].get(i);
                    pq.add(new Pair(e.dst,e.wt));
                }
            }
        }

        System.out.println(finalcost);
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        mst(graph);
    }
}
