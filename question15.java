import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class question15 {
    private final ReentrantLock lock=new ReentrantLock();
    private final Condition con =lock.newCondition();
    public void sample() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample");
            System.out.println("Current lock hold "+lock.getHoldCount());
            System.out.println("current owner "+lock.getOwner());
            con.await();
            System.out.println("Signal received");
        }finally {
            lock.unlock();
        }
    }
    public void sample1() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample2");
            con.signal();
            System.out.println("Signal received");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        question15 q = new question15();
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    q.sample();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    q.sample1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t1.start();

    }
}
