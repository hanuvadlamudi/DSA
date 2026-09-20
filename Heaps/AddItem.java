import java.util.ArrayList;

public class AddItem {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();

        public void addItem(int data){
            list.add(data);

            int x = list.size()-1;

            int parent = (x-1)/2;

            while(list.get(x) < list.get(parent)){
                int temp = list.get(x);
                list.set(x,list.get(parent));
                list.set(parent, temp);

                x = parent;
                parent = (x-1) / 2;
            }
        }
        
        public int peek(){
            return list.get(0);
        }

        public void heapify(int i){
            int minIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;

            if(left < list.size() && list.get(left) < list.get(minIdx)){
                minIdx = left;
            }

            if(right < list.size() && list.get(right)<list.get(minIdx)){
                minIdx = right;
            }

            if(minIdx != i){
                int temp = list.get(minIdx);
                list.set(minIdx, list.get(i));
                list.set(i, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            int data = list.get(0);

            // swap elements
            int temp = list.get(list.size()-1);
            list.set(list.size()-1, list.get(0));
            list.set(0, temp);

            //delete last
            list.remove(list.size()-1);
            
            //heapify
            heapify(0);

            return data;
        }



        public boolean isEmpty(){
            
            return list.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.addItem(10);
        h.addItem(8);
        h.addItem(4);
        h.addItem(7);
        h.addItem(1);
        //h.addItem(6);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();  
        }
    }
}
