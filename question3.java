import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class question3 extends Thread {
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

    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadScheduledExecutor();
        executor.submit(new question3());
        executor.submit(new question3());

    }
}
