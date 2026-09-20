public class ThreadFromRunnable {
    public static void main(String[] args) {
        
        Thread1 t1 = new Thread1();
        Thread t = new Thread(t1);
        t.start();
        
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}


class Thread1 implements Runnable{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}