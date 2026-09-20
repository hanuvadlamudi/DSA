import java.util.Arrays;
import java.util.Comparator;

public class ChainPairs {
    public static void main(String[] args) {
        int a[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(a,Comparator.comparingDouble(o -> o[1]));

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        int chainlength = 1;
        int endlink = a[0][1];
        for(int i=1;i<a.length;i++){
            if(a[i][0]>endlink){
                chainlength++;
                endlink=a[i][1];
            }
        }
        System.out.println(chainlength);
    }
}
