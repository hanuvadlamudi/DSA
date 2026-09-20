import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int w = 30;

        double table[][] = new double[val.length][2];

        for(int i=0;i<val.length;i++){
            table[i][0]=i;
            table[i][1] = val[i] / (double)weight[i];
        }
        
        Arrays.sort(table,Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int totalvalue = 0;

        for(int i=table.length-1;i>=0;i--){

            int idx = (int)table[i][0];
            if(capacity >= weight[idx]){
                totalvalue += val[idx];
                capacity -=weight[idx];
            }else{
                totalvalue += (table[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Total value of knapsack is : "+totalvalue);
    }
}
