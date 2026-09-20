public class MethodsThread extends Thread {

    MethodsThread(String name){
        super(name);
    }
    
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        
        MethodsThread t1 = new MethodsThread("T1");
        t1.start();
        t1.join();
        System.out.println("Hello");
    }
}
