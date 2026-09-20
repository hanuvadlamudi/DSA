import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class UnsortedActivities {
    public static void main(String[] args) {
    int start[] = {1,3,0,5,8,5};
    int end[] = {2,4,6,7,9,9};

    int Activities[][] = new int[start.length][3];

    for(int i=0;i<start.length;i++){
    Activities[i][0] = i;
    Activities[i][1] =start[i];
    Activities[i][2]=end[i];
    }
    
    ArrayList<Integer> list = new ArrayList<>();
    Arrays.sort(Activities,Comparator.comparingDouble(o -> o[2]));
    list.add(Activities[0][0]);
    int maxActiv=1;
    int lastindex=Activities[0][2];

    for(int i=1;i<end.length;i++){
        if(Activities[i][1] >= lastindex){
            maxActiv++;
            list.add(Activities[i][0]);
            lastindex=Activities[i][2];
        }
    }

    for(int i=0;i<list.size();i++){
        System.out.print("A"+list.get(i)+" ");
    }

    System.out.println();
    System.out.println("Total Activities are : "+maxActiv);
    
    }
}
