import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public static void main(String[] args) {
        int a[] ={1,3,4,6,3,7,9,3,6,5,7,8,5,2,1,4,5,7};
        HashMap<Integer,Integer> map = new HashMap<>(); 

        for(int i=0;i<a.length;i++){
            int count = a[i];

            // if(map.containsKey(count)){
            //     map.put(count, map.get(count)+1);
            // }else{
            //     map.put(count, 1);
            map.put(count, map.getOrDefault(count, 0)+1);
        }
        
        System.out.println(map);
        int key = 0;
        //Set<Integer> keys = map.keySet();
        int max = Integer.MIN_VALUE;
        for(Integer k : map.keySet()){
            if(map.get(k)>a.length/8){
                System.out.println(k +" "+map.get(k));
            }
        }
        
    }
}
