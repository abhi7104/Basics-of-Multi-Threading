import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class question8 implements Runnable{
    Thread t= new Thread();
    public void run()
    {
        for(int i=0;i<1;i++)
        {
            System.out.println(t.getName());
        }
    }
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(new question8(),2, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new question8(),5,1, TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(new question8(),4,1,TimeUnit.MILLISECONDS);
    }
}
