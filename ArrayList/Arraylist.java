import java.util.ArrayList;
import java.util.Collections;
public class Arraylist{
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        for(Integer i=1;i<=7;i++){
            list.add(i);
        }
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(5));
        list.set(0, 1);
        System.out.println(list.contains(10));
        System.out.println(list.isEmpty());
        list.add(1,2);
        System.out.println(list);
        System.out.println(list.size()); 
        for(Integer i=list.size()-1;i>=0;i--){   //Print Reverse of a ArrayList
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //For largest number in ArrayList

        int max = Integer.MIN_VALUE;
        for(Integer i=0;i<list.size();i++){
            max = Math.max(max, list.get(i));

        }
        System.out.println(max);

        //Sorting

        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
}