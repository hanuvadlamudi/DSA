import java.util.HashSet;

public class CountDistinct {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        int a[] = {1,2,5,6,5,4,6,8,9 ,5,0,1,0,9,4,6};

        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }

        System.out.println(set.size());

    }
}
