import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class isterminate implements Runnable{
    Thread t= new Thread();
    @Override
    public void run() {
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
}
public class question5 {

    public static void main(String[] args) {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        executor.submit(new isterminate());
        System.out.println(" Is Executor is Shutdown :"+ executor.isShutdown());
        executor.shutdown();
        System.out.println(" Is Executor is Terminated :"+ executor.isTerminated());
        System.out.println(" Is Executor is Shutdown :"+ executor.isShutdown());
    }

}
