public class ThreadCreate implements Runnable{

    public static void main(String[] args) {
        new ThreadCreate();
    }
    public ThreadCreate(){
        Thread current = Thread.currentThread();
        current.setName("Thread corrente");
        Thread t = new Thread(this,"Thread secondario");

        Thread t2 = new Thread(this,"Thread terzo");
        System.out.println(current);
        System.out.println(t);

        t.start();
        t2.start();
        try{
            System.out.println("Vado a dormire");
            current.sleep(3000);
            System.out.println("Mi sveglio");
        }catch(InterruptedException e){
            System.out.println("errore thread principale");
        }
        System.out.println("finito processo thread principale");

    }
    @Override
    public void run() {
        //dentro il metodo run ci metto tutta la roba che gli voglio far fare al thread
        //quando viene lanciato dalla JVM
        try{
            for(int i = 0; i<5; i++){
                System.out.println("thread figlio... " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Thread secondario errore");
        }
        System.out.println("Finito processo thread secondario");
    }
}
