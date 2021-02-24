import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class isterminate implements Runnable{
    Thread t= new Thread();
    @Override
    public void run() {
        for(int i=0;i<5;i++)
        {
          try{
              t.sleep(500);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        }
        System.out.println(t.getName());
    }
}
public class question5 {

    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadScheduledExecutor();
        executor.submit(new isterminate());

    }

}
