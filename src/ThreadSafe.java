public class ThreadSafe implements Runnable{
    private String msg;
    private ThreadSafeMethod method;

    public ThreadSafe(ThreadSafeMethod method, String msg){
        this.method = method;
        this.msg = msg;
        new Thread(this).start();
    }
    @Override
    public void run() {
        synchronized (method) {
            method.stampa(msg);
        }
    }

    public static void main(String[] args) {
        //creo un oggetto che condivido con tutti e 3 i threads
        ThreadSafeMethod istanza = new ThreadSafeMethod();
        ThreadSafe ts1 = new ThreadSafe(istanza,"HELLO");

        ThreadSafe ts2 =  new ThreadSafe(istanza, "FABRIZIO");
        ThreadSafe ts3 =  new ThreadSafe(istanza,"WORLD");

    }
}
