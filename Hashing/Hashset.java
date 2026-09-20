import java.util.HashSet;
import java.util.Iterator;


public class Hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("Vizag");
        set.add("Hyderabad");
        set.add("Bengaluru");
        set.add("Delhi");
        set.add("Mumbai");

        System.out.println(set);

        Iterator<String> it = set.iterator(); 

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println();
        
        for(String c : set){
            System.out.println(c);
        }
    }
}
