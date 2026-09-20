import java.util.Arrays;
import java.util.Collections;

public class Chocola {
    public static void main(String[] args) {
        int n=4,m=6;

        Integer costv[] = {2,1,3,1,4};
        Integer costh[] = {4,1,2};

        Arrays.sort(costv,Collections.reverseOrder());
        Arrays.sort(costh,Collections.reverseOrder());

        int h = 0;
        int v = 0;

        int hp=1 , vp = 1;

        int mincost = 0;

        while(h<costh.length && v<costv.length){
            if(costv[v]<=costh[h]){
                mincost += (vp * costh[h]);
                hp++;
                h++;
            }else{
                mincost += (hp * costv[v]);
                vp++;
                v++;
            }
        }

        while(h<costh.length){
            mincost += (vp * costh[h]);
            hp++;
            h++;
        }

        while(v < costv.length){
            mincost += (hp * costv[v]);
            vp++;
            v++;
        }

        System.out.println(mincost);
    }
}
