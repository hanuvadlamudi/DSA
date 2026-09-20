import java.util.ArrayList;

public class SortedActivities {
    public static void main(String[] args) {
    int start[] = {1,3,0,5,8,5};
    int end[] = {2,4,6,7,9,9};

    ArrayList<Integer> list = new ArrayList<>();
    int maxActiv = 1;
    list.add(0);
    int lastind = 0;
    for(int i=1;i<end.length;i++){
        if(start[i]>=end[lastind]){
            maxActiv++;
            list.add(i);
            lastind = i;
        }

    }
    for(int i=0;i<list.size();i++){
        System.out.print("A"+list.get(i)+" ");
    }
    System.out.println();
    System.out.println("Total Activities are : "+maxActiv);
    }
}
