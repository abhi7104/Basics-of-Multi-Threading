public class question2 extends Thread {
    public void run(){
        try {
            Thread.sleep(5);
            for(int i=0;i<3;i++)
                System.out.println(Thread.currentThread().getName()+" "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
    question2 q= new question2();
    question2 q1= new question2();
    q.start();
    q1.start();
    q.join();
    q1.join();
    }
}
