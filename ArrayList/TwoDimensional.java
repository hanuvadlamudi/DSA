import java.util.ArrayList;

public class TwoDimensional {
    public static void main(String[] args) {
        ArrayList <ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList <Integer> list1 = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        ArrayList <Integer> list3 = new ArrayList<>();
        for(int i=1; i<7; i++){
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }
        System.out.println(list1+" "+list2+" "+" "+list3);
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);
        for(int i=0;i<mainList.size();i++){
            ArrayList <Integer> Templist = mainList.get(i);
            for(int j=0; j<Templist.size();j++){
                System.out.print(Templist.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("Size Of main list Is "+mainList.size());
    }
}
