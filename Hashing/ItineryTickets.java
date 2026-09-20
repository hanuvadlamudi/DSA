import java.util.HashMap;

public class ItineryTickets {
    public static String Start(HashMap<String,String> map){
        HashMap<String,String> reverse = new HashMap<>();

        for(String city : map.keySet()){
            reverse.put(map.get(city), city);
        }

        for(String city : map.keySet()){
            if(!reverse.containsKey(city)){
                return city;
            }
        }
        
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("chennai", "banglore");
        map.put("mumbai", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");    

        String startPoint = Start(map);

        System.out.print(startPoint);
        
        for(String city : map.keySet()){
            System.out.print("==>>"+map.get(startPoint));
            startPoint= map.get(startPoint);
        }
    }
}
