import java.util.ArrayList;

public class ContainerWater {
    public static int MoreWater(ArrayList<Integer> list){
        int li=0,ri=list.size()-1;
        int max =0;
        while(li<ri){
            int height = Math.min(list.get(li), list.get(ri));
            int width=ri-li;
            int water = height * width;
            max=Math.max(max,water);
            if(list.get(li)>list.get(ri)){
                ri--;
            }else{
                li++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(MoreWater(list));
    }
}