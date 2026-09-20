import java.util.*;

public class ObjectsPq{
        public static class Student implements Comparable<Student> {
            String name;
            int Rank;

            Student(String name, int Rank){
                this.name = name;
                this.Rank = Rank;

            }

            @Override
            public int compareTo(Student s2){
                return this.Rank - s2.Rank;
            }
        }
    public static void main(String[] args) {
        //PriorityQueue<Student> pq = new PriorityQueue<>();
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Kavin", 3));
        pq.add(new Student("Joseph", 1));
        pq.add(new Student("Anthony", 4));
        pq.add(new Student("Harry", 2));

        while(!pq.isEmpty()){
            System.out.print(pq.peek().name+" "+pq.peek().Rank);
            pq.remove();
            System.out.println();
        }
    }
}

