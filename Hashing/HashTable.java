import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable{

    static class HashMap<K,V>{

        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        private  int n;
        private  int N;
        private LinkedList<Node> buckets[];

        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];

            for(int i=0;i<N;i++){
                this.buckets[i] = new LinkedList<>();
            }

        }

        public  void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchLL(key,bi);

            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            }else{
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                reHash();
            }
        }

        public int hashFunction(K key){
            int bi = key.hashCode();

            return Math.abs(bi)%N;
        }

        public int searchLL(K key,int bi){

            for(int i=0;i<buckets[bi].size();i++){
                if(buckets[bi].get(i).key == key){
                    return i;
                }
            }

            return -1;
        }

        public void reHash(){
            LinkedList<Node>[] oldlist = buckets;
            N = 2*N;
            buckets = new LinkedList[N];

            for(int i=0;i<N;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldlist.length;i++){
                LinkedList<Node> ll = oldlist[i];

                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }

            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if(di == -1){
                return null;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if(di == -1){
                return false;
            }else{
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchLL(key, bi);

            if(di == -1){
                return null;
            }else{
                Node node = buckets[bi].get(di);
                buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keylist = new ArrayList<>();
            
            for(int i=0;i<N;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keylist.add(node.key);
                }
            }

            return keylist;
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public int size(){
            return n;
        }


    }
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap();

        map.put("India", 140);
        map.put("Israel", 1);
        map.put("Russia", 15);
        

        System.out.println(map.size());
        System.out.println(map.containsKey("India"));
        System.out.println(map.get("India"));

        ArrayList<String> keys = map.keySet();

        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }

        map.remove("Russia");

        ArrayList<String> keys2 = map.keySet();

        for(int i=0;i<keys2.size();i++){
            System.out.println(keys2.get(i)+" "+map.get(keys2.get(i)));
        }

    }
}