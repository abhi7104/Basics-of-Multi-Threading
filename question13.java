import java.util.Scanner;

public class question13 {
    public  void produce() throws InterruptedException{
      synchronized (this){
          System.out.println("producer thread running");
          wait();
          System.out.println("back to producer");
      }
    }
    public  void consume() throws InterruptedException{
        Scanner sc= new Scanner(System.in);
        Thread.sleep(500);
        synchronized (this) {
            System.out.println("In consumer waiting for return key");
            sc.nextLine();
            System.out.println("key pressed");
            notify();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        question13 q = new question13();
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
        t2.start();
    }
}
