import java.util.PriorityQueue;

public class SlidingWindow {
    public static class Pairs implements Comparable<Pairs>{
        int num;
        int idx;

        public Pairs(int num,int idx){
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pairs p2){
            return p2.num - this.num;
        }
    }
    public static void main(String[] args) {
        int a[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int n = a.length;
        int sol[] = new int[n-k+1];
        PriorityQueue<Pairs> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(new Pairs(a[i], i));
        }
        
        sol[0] = pq.peek().num;

        for(int  i=k;i<n;i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pairs(a[i], i));
            sol[i-k+1] = pq.peek().num;
        }

        for(int i=0;i<sol.length;i++){
            System.out.print(sol[i]+" ");
        }
    }
}
