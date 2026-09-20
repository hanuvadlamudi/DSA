import java.util.LinkedList;
public class Jcf {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list); 
        System.out.println("Size of LL : "+list.size());
        System.out.println(list.get(1));
        System.out.println(list.peekFirst());
        System.out.println(list.poll());
        list.offerFirst(100);
        System.out.println(list);
        list.add(1,23);
        System.out.println(list);
    }
}
