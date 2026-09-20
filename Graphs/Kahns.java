import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahns{
    static class Edge{
        int src;
        int dst;

        Edge(int src,int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static void calIndegree(ArrayList<Edge>[] graph,int[] ind){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                ind[e.dst]++;
            }
        }
    }

    public static void topologicalBFS(ArrayList<Edge>[] graph){
        int[] ind = new int[graph.length];
        calIndegree(graph, ind);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();

            System.out.print(curr+" ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                ind[e.dst]--;
                if(ind[e.dst] == 0){
                    q.add(e.dst);
                }
            }
        }

        System.out.println();
    }

    
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        topologicalBFS(graph);
    }
}