public class ThreadSafeMethod {

    public  void stampa(String msg){
        System.out.print("[" + msg);

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        System.out.println("]");
    }
}
