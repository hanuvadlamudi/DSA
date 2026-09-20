import java.util.ArrayList;

public class CycleInDirectedGraph {
    static class Edge{
        int src;
        int dst;

        Edge(int src,int dst){
            this.src = src;
            this.dst = dst;
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] visit = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                if(isCycleUtil(graph,i,visit,stack)){
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] visit,boolean[] stack){
        visit[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            
            if(stack[e.dst]){
                return true;
            }

            if(!visit[e.dst]){
                if(isCycleUtil(graph, e.dst, visit, stack)){
                    return true;
                }
            }
        }

        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[7];

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        
        graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 1));

        System.out.println(isCycle(graph));
    }
}
