import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class question9 implements Runnable {
    Thread t= new Thread();
    public void run()
    {
        for(int i=0;i<1;i++)
        {
            try{
                t.sleep(100);
                System.out.println(t.getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        ExecutorService executorfixed= Executors.newFixedThreadPool(2);
        ThreadPoolExecutor p= (ThreadPoolExecutor) executor;
        ThreadPoolExecutor pfixed=(ThreadPoolExecutor) executorfixed;
        executor.submit(new question9());
        executor.submit(new question9());
        executor.submit(new question9());
        executorfixed.submit(new question9());
        executorfixed.submit(new question9());
        executorfixed.submit(new question9());
        executor.shutdown();
        executorfixed.shutdown();
        System.out.println("Current threads in pool "+p.getPoolSize()+" Current threads in pool fixed "+pfixed.getPoolSize());
    }
}
