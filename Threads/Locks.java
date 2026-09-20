public class Locks {
    public static void main(String[] args) {
        BankAccount sbi = new BankAccount();
        
        Runnable task = new Runnable() {
            @Override
            public void run(){
                try {
                    sbi.withdraw(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"Thread2");

        t1.start();
        t2.start();
    }
}

class BankAccount{
    private int balance = 100;

    public synchronized void withdraw(int amount) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" attempting withdraw "+amount);
        if(amount <= balance){
            System.out.println(Thread.currentThread().getName()+" proceeding withdraw ");

            Thread.sleep(10000);

            balance -=amount;

            System.out.println(Thread.currentThread().getName()+" withdrawal successful and balance is : "+balance);
        }else{
            System.out.println("Insufficient amount");
        }
    }
}
