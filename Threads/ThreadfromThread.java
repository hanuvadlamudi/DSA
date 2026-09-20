public class ThreadfromThread {
    public static void main(String[] args) {

        Thread1 t1 = new Thread1("Hola");
        t1.start(); 

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }

        
    }
}

class Thread1 extends Thread{
    public Thread1(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}