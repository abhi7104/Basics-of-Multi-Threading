import java.util.concurrent.atomic.AtomicInteger;

public class question12 implements Runnable{
    private AtomicInteger a= new AtomicInteger(0);
    int max=100000000;
    public void run(){
        for(int i=0;i<=max;i++){
            a.addAndGet(1);
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread();

    }
}
