import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);

        System.out.println(set.size());
        System.out.println(set);
        if(set.contains(5)){
            System.out.println("set Contains 5");
        }
        if(set.contains(2)){
            System.out.println("Set Contains 2");
        }

        set.remove(2);
        System.out.println(set);

        set.clear();

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        HashSet<String> set1 = new HashSet<>();

        set1.add("Banglore");
        set1.add("Mysore");
        set1.add("Vizag");
        set1.add("Cochin");
        set1.add("Chennai");

        Iterator it = set1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+"  ");
        }
        System.out.println();
        for(String k : set1){
            System.out.print(k+" ");
        }

        Iterator i = set.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
