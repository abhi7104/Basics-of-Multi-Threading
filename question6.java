import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class question6 implements Runnable{
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
        Future f=executor.submit(new question6());
        System.out.println(f.get());

    }
}
