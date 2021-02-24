import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class question15 {
    private final ReentrantLock lock=new ReentrantLock();
    private final Condition con =lock.newCondition();
    public void sample() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample");
            con.await();
            System.out.println("Signal received by sample2 or sample4 in sample");
        }finally {
            lock.unlock();
        }
    }
    public void sample1() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample2 signaling sample");
            con.signal();
        }finally {
            lock.unlock();
        }
    }
    public void sample3() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample3");
            con.await();
            System.out.println("Signal received by sample4 in  sample3");
        }finally {
            lock.unlock();
        }
    }
    public void sample4() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("In sample4 signaling all sample");
            con.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
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
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    q.sample3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    q.sample4();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
       // t1.start();
        t2.start();
        t3.start();
    }
}
