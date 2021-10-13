public class ThreadCount implements Runnable{

    private long count = 0;
    private Thread t;
    private boolean running = true;


    public synchronized void pagamento(int somma){
        //checkCC() -> saldo = 1000;
        //if(soldiNelConto > somma =500)
        //procediamo con l'acquisto
        //togliere i soldi dal cc = 1000-500 = 500
    }

    public ThreadCount(int priority, String name){
        t = new Thread(this);
        t.setPriority(priority);
        t.setName(name);
        //t.start();
    }

    public long getCount(){
        return count;
    }
    public void stopApplication(){
        this.running = false;
    }

    public void startApplication(){
        t.start();
    }

    @Override
    public void run() {
        while(running) {
            count++;
        }
    }

    public static void main(String[] args) {
        ThreadCount tLow = new ThreadCount(Thread.MIN_PRIORITY,"Thread low");
        ThreadCount tHigh = new ThreadCount(Thread.MAX_PRIORITY, "Thread high");

        tLow.startApplication();

        tHigh.startApplication();


        try{
            Thread.sleep(5);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        tLow.stopApplication();
        tHigh.stopApplication();

        System.out.println("Numero count thread low= " + tLow.getCount() +"\n " +
                "Numero count thread high= " + tHigh.getCount());

    }
}
