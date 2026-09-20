import java.util.ArrayList;
public class RotatedTargetSum {
    public static boolean RotatedSum(ArrayList<Integer> list,int target){
        int bp = -1;
        int n = list.size();
        for(int i=0;i<n;i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }
        int li =bp+1;
        int ri = bp;
        while(li!=ri){
            if(list.get(li)+list.get(ri)==target){
            return true;
        }
        if(list.get(li)+list.get(ri)>target){
            ri = (n+ri-1) % n;
        }
        else{
            li = (li+1)%n;
        }
        
    }
    
        return false;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        System.out.println(list);
        System.out.println(RotatedSum(list,16 ));
    }
}


// import java.util.ArrayList;

// public class Practice {
//     public static boolean rotated(ArrayList<Integer> list,int target){
//         int si = 0;
//         int li = list.size()-1;
//         for(int i=0;i<list.size()-1;i++ ){
//             if(list.get(i)>list.get(i+1)){
//                 si = i+1;
//                 li = i;
//             }
//         }
//         while(si!=li){
//             if(list.get(si)+list.get(li)==target){
//                 return true;
//             }else if(list.get(si)+list.get(li)>target){
//                 li = (li+list.size()-1) % list.size();
//             }else{
//                 si = (si +1) % list.size();
//             }
//         }
//         return false;

//     }

//     public static void main(String[] args) {
//         int a[] = {11,15,6,8,9,10};
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i=0;i<a.length;i++){
//             list.add(a[i]);
//         }
//         System.out.println(rotated(list, 19));
//     }
// }