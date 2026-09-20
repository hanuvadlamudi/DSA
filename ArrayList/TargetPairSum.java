import java.util.ArrayList;

public class TargetPairSum {
    // public static boolean TargetSum(ArrayList<Integer> list, int target){
    //     for(int i=0;i<list.size();i++){
    //         for(int j=i;j<list.size();j++){
    //             if(list.get(i)+list.get(j)==target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean targetSum(ArrayList<Integer> list , int target){
        int li = 0;
        int ri = list.size()-1;
        while(li<ri){
            if(list.get(li)+list.get(ri)==target){
                return true;
            }
            if(list.get(li)+list.get(ri)>target){
                ri--;
            }else{
                li++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<7;i++){
            list.add(i);
        }
        System.out.println(list);
        int target = 10;
        System.out.println(targetSum(list, target));
    }
}
