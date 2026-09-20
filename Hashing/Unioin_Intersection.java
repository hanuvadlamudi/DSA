import java.util.HashSet;

public class Unioin_Intersection {
    public static void main(String[] args) {
        int a[] ={7,3,9};
        int b[] = {6,3,9,2,9,4};

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            set.add(b[i]);
        }

        System.out.println("Union size "+set.size());

        set.clear();

        int count = 0;
        
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }

        for(int i=0;i<b.length;i++){
            if(set.contains(b[i])){
                count++;
                set.remove(b[i]);
            }
        }

        System.out.println("Intersection size "+count);
    }
}
