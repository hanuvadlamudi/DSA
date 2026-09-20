import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge implements Comparable<Edge>{
        int dst;
        int cost;

        Edge(int dst,int cost){
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public static void citiesCost(int cities[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[cities.length];

        pq.add(new Edge(0, 0));

        int finalCost = 0;

        while(!pq.isEmpty()){
            Edge e = pq.remove();

            if(!visit[e.dst]){
                visit[e.dst] = true;
                finalCost += e.cost;

                for(int i=0;i<cities[e.dst].length;i++){
                    if(cities[e.dst][i]!=0){
                        pq.add(new Edge(i, cities[e.dst][i]));
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},
    {1,0,5,0,6},
{2,5,0,6,0},
{3,0,6,0,0},
{4,7,0,0,0}};
    }
}
