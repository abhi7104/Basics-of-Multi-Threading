class threadClass extends Thread
{
    public void run(){
        System.out.println("Extended from Thread Class");
    }
}
class threadInterface implements Runnable{

    @Override
    public void run() {
        System.out.println("Implemented using Runnable Interface");
    }
}
public class question1 {
    public static void main(String[] args) {
        threadClass t = new threadClass();
        Thread t1=new Thread(new threadInterface());
        t.start();
        t1.start();
    }
}
