import java.util.ArrayList;

public class Swap {
    public static void Swapping(ArrayList <Integer> list,int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        for(Integer i=1;i<8;i++){
            list.add(i);
        }
        int idx1=1,idx2=3;
        System.out.println(list);
        Swapping(list, idx1, idx2);
        System.out.println(list);
        }
}
