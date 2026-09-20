public class ThreadwithThread {
    public static void main(String[] args) {
        A one = new A();
        B two = new B();

        one.start();
        two.start();
    }    
}
class A extends Thread{
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println("Thread A : "+i);
        }
    }
}

class B extends Thread{
    public void run(){
        for(int i=0;i<=10;i++){
            System.out.println("Thread B : "+i);
        }
    }
}
