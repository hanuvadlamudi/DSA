public class Synchro {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        MyThread t1 = new MyThread(c);
        MyThread t2 = new MyThread(c);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getCount());
    }
}


class Counter{
    private int count = 0;  

    public void increment(){
        synchronized(this){ //use this to synchronize only this part of code. KA --> Synchronized block
            count++;
        }
    }

    // public synchronized void increment(){ //this synchronizes entire fun 
    //     count++;
    // }

    public int getCount(){
        return count;
    }
}

class MyThread extends Thread{

    private Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){

        for(int i=0;i<10000;i++){
            counter.increment();
        }

    }
}