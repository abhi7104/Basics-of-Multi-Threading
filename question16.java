import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class question16 {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public void task1(){
        lock1.lock();
        System.out.println("Thread1 lock1 acquired");
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        lock2.lock();
        System.out.println("Thread1 lock2 acquired");

        System.out.println("Thread1 executing first operation.");

        lock2.unlock();
        lock1.unlock();
    }

    public void task2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MICROSECONDS);
                System.out.println("Thread2 lock2 acquired, trying to acquire lock1.");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (lock1.tryLock()) {
                System.out.println("Thread2 lock1 acquired.");
            } else {
                System.out.println("Thread2 cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            System.out.println("Thread2 executing second operation.");
            lock1.unlock();
            lock2.unlock();
        }

    }

    public static void main(String[] args) {
        question16 q = new question16();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                q.task1();
            }
        });
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                q.task2();
            }
        });
        t.start();
        t1.start();
    }
}