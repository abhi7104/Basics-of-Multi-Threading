class sample1{
    void Tellcount(int n)
    {
        synchronized (this){
        for(int i=0;i<5;i++){
            System.out.println(i+"*"+n+": "+i*n);
            try{
                Thread.sleep(400);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    }
}

class Syncblock extends Thread{
    sample1 t;
    Syncblock(sample1 t){
        this.t=t;
    }
    public void run(){
        t.Tellcount(2);
    }

}
class Syncblock1 extends Thread{
    sample1 t;
    Syncblock1(sample1 t){
        this.t=t;
    }
    public void run(){
        t.Tellcount(3);
    }
}

public class question11{
    public static void main(String args[]){
        sample1 s = new sample1();
        Syncblock t1=new Syncblock(s);
        Syncblock1 t2=new Syncblock1(s);
        t1.start();
        t2.start();
    }
}  