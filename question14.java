import java.util.Scanner;

public class question14 {
    public  void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("producer thread running");
            wait();
            System.out.println("back to producer");
        }
    }
    public  void produce1() throws InterruptedException{
        synchronized (this){
            System.out.println("producer1 thread running");
            wait();
            System.out.println("back to producer1");
        }
    }
    public  void consume() throws InterruptedException{
        Scanner sc= new Scanner(System.in);
        Thread.sleep(500);
        synchronized (this) {
            System.out.println("In consumer waiting for return key");
            sc.nextLine();
            System.out.println("key pressed");
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        question14 q = new question14();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    q.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    q.produce1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    q.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t3.start();
        t2.start();
    }
}