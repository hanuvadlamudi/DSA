import java.util.PriorityQueue;

public class WeakPerson {

    public static class Soldiers implements Comparable<Soldiers> {
    int idx;
    int number;

    public  Soldiers(int idx,int number){
        this.idx = idx;
        this.number = number;

    }

    @Override
    public int compareTo(Soldiers s2){
        if(this.number == s2.number){
            return this.idx - s2.idx;
        }else{
            return this.number - s2.number;
        }
    }
        
    }
    public static void main(String[] args) {
        int a[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}
        };

        int k = 2;

        PriorityQueue<Soldiers> pq = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
            int count = 0;
            for(int j=0;j<a[0].length;j++){
                count += a[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Soldiers(i,count));
        }

        for(int i=0;i<k;i++){
            System.out.print(" Row"+pq.remove().idx);
        }
        
    }
}
