import java.util.Arrays;

public class AbsoluteDiff {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {3,2,1};

        Arrays.sort(a);
        Arrays.sort(b);
        int minDiffer = 0;
        for(int i=0; i<a.length; i++){
            minDiffer += Math.abs(a[i] - b[i]);
        }

        System.out.println(minDiffer);
    }
}
