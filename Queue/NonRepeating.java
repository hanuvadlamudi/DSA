import java.util.ArrayDeque;
public class NonRepeating {
    public static void FirstNonRepeating(String str){
        int freq[] = new int[26];
        java.util.Queue<Character> q = new ArrayDeque<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            q.add(c);
            freq[c-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aaabccxb";
        FirstNonRepeating(str);
    }
}
