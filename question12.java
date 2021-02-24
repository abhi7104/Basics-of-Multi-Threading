import java.util.concurrent.atomic.AtomicInteger;

public class question12 implements Runnable{
    private AtomicInteger a= new AtomicInteger(0);
    int max=100000000;
    public void run(){
        for(int i=0;i<max;i++){
            a.addAndGet(1);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        question12 q= new question12();
        Thread t = new Thread(q);
        Thread t1 = new Thread(q);
        t.start();
        t1.start();
        t.join();
        t1.join();
        System.out.println(q.a);
    }
}
