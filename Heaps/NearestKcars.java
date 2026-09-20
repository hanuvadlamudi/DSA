import java.util.PriorityQueue;

public class NearestKcars {

    public static class Points  implements Comparable<Points>{
        int x ;
        int y;
        int sq;
        int idx;

        public Points(int x,int y,int sq,int idx){
            this.x = x;
            this.y = y;
            this.sq = sq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Points p){
            return this.sq - p.sq;
        }
    }
    public static void main(String[] args) {
        int a[][] = {{3,3} , {5,-1}, {-2,4}};
        int k =2;
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            int sq = a[i][0] * a[i][0] + a[i][1] * a[i][1];
            
            pq.add(new Points(a[i][0],a[i][1],sq,i));
        }

        for(int i=0;i<k;i++){
            System.out.print(" C"+pq.remove().idx);
        }
    }
}
