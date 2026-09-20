import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  //for descending order
        pq.add(5);
        pq.add(3);
        pq.add(34);
        pq.add(12);
        pq.add(2);

        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        
    }
}