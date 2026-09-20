import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_Map{
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();

        map.put("India", 142);
        map.put("China", 140);
        map.put("Indonesia", 33);
        map.put("us", 35);

        System.out.println(map);

        int population = map.get("India");
        System.out.println(population);

        System.out.println(map.get("Japan"));
        

        System.out.println(map.containsKey("india"));
        System.out.println(map.containsValue(142));


        System.out.println(map.remove("China")); //returns value
        System.out.println(map);
        System.out.println(map.remove("France"));

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        // map.clear();

        // System.out.println(map.isEmpty());

        Set<String> keys = map.keySet();  //learn about entryset
        System.out.println(keys);

        for (String country : keys) {
            System.out.println("Key = "+country+" ,"+" value = "+map.get(country));
        }

        Set<Map.Entry<String,Integer>> e = map.entrySet();  //entrySet

        System.out.println(e);

    }
}