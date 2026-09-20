import java.util.HashMap;

public class LargestSubArraySum0 {

    public static void main(String[] args) {
        // int a[] = {15,-2,2,-8,1,7,10,23};
        int a[] = {0,1,2,3,4,5};

        int length = 0;
        int sum =0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int j=0;j<a.length;j++){
            sum +=a[j];
            if(map.containsKey(sum)){
                length = Math.max(length, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }

        System.out.println(length);
    }
}

// import java.util.HashMap;

// public class Practice {
    

//     public static void main(String[] args) {
//         int a[] = {2,0,0,-1,0,3,0,-1,0,0};
//         int k = 3;
//         int sum = 0;
//         int length = 0;

//         HashMap<Integer,Integer> map = new HashMap<>();   //for both posiotive and negative integers

//         for(int i=0;i<a.length;i++){
//             sum += a[i];

//             if(sum == k){
//                 length = Math.max(length, i+1);  
//             }

//             int part = sum - k;

//             if(map.containsKey(part)){
//                 length = Math.max(length, i-map.get(part));
//             }else{
//                 map.put(sum, i);
//             }

            
//         }

//         System.out.println(length);
//     }
// }