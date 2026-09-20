import java.util.*;
import java.util.Stack;


public class CoinsExchange {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,200,500};

        Arrays.sort(coins,Collections.reverseOrder());
        int coinsCount = 0;
        int amount = 1599;

        Stack<Integer> s = new Stack<>();
        
        for(int i=0;i<coins.length;i++){
            if(amount>= coins[i]){
                while(amount>=coins[i]){
                    coinsCount++;
                    amount -= coins[i];
                    s.add(coins[i]);
                }
            }
        }
        System.out.println("No of Coins are : "+coinsCount);

        for(int i=0;i<s.size();i++){
            System.out.print(s.get(i)+" ");
        }
        System.out.println();
    }
}
