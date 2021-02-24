import java.util.concurrent.*;

public class question7 implements Runnable{
    Thread t= new Thread();
    public void run()
    {
        for(int i=0;i<3;i++)
        {
            try{
                t.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName());
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newSingleThreadScheduledExecutor();
        executor.submit(new question7());
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
