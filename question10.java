class sample{
    static int count=0;
    synchronized void Tellcount(int n)
    {
        for(int i=0;i<n;i++){
            System.out.println(count++);
            try{
                Thread.sleep(400);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread{
    sample t;
    MyThread1(sample t){
        this.t=t;
    }
    public void run(){
        t.Tellcount(2);
    }

}
class MyThread2 extends Thread{
    sample t;
    MyThread2(sample t){
        this.t=t;
    }
    public void run(){
        t.Tellcount(3);
    }
}

public class question10{
    public static void main(String args[]){
        sample s = new sample();
        MyThread1 t1=new MyThread1(s);
        MyThread2 t2=new MyThread2(s);
        t1.start();
        t2.start();
    }
}  