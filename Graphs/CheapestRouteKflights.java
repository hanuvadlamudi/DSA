import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheapestRouteKflights {
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

    public static class Info{
        int src;
        int cost;
        int stops;

        public Info(int src,int cost,int stops){
            this.src = src;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static void findStops(ArrayList<Edge>[] graph,int src,int dst,int k){
        int dist[] = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();

        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stops > k){
                break;
            }

            for(int i=0;i<graph[curr.src].size();i++){
                Edge e = graph[curr.src].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v]  && curr.stops <= k){
                    dist[v] = curr.cost + wt;

                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            System.out.println("No such route");
        }else{
            System.out.println(dist[dst]);
        }
    }
    public static void main(String[] args) {

        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e); 
        }

        findStops(graph, 0, 3, 1);
    }
}
