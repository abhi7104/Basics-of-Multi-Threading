import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class shutDown implements Runnable{
    Thread t = new Thread();
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(t.getName());
        }
    }
}
class shutdownNow implements Runnable{
    Thread t = new Thread();
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println(t.getName());
        }
    }
}
public class question4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        shutDown r1 = new shutDown();
        shutDown r2 = new shutDown();
        executor.submit(r1);
        executor.submit(r2);
        executor.shutdown();
        shutdownNow r3 = new shutdownNow();
        shutdownNow r4 = new shutdownNow();
        executor2.submit(r3);
        executor2.submit(r4);
        executor2.shutdownNow();
    }
}