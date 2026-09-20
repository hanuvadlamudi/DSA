public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        //A a = new A() // pass a in constructor this is another way of doing this
        System.out.println("Start");
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        Thread t3 = new Thread(new A());
        // t1.start();
        t3.start();
        t2.start();
        t2.join();
        t1.start();
        System.out.println("END");
    }    
}

class A implements Runnable{
    public void run(){
        for(int i=0;i<=10;i+=2){
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Thread A : "+i);
        }
    }
}

class B implements Runnable{
    public void run(){
        for(int i=1;i<=10;i+=2){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Thread B : "+i);
        }
    }
}