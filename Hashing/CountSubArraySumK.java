import java.util.HashMap;

public class CountSubArraySumK {
    public static void main(String[] args) {
        int a[] = {10,2,-2,-20,10};
        int count =0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int k=-10;
        for(int j=0;j<a.length;j++){
            sum +=a[j];
            if(map.containsKey(sum - k)){
                count +=map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(count);
    }
}
