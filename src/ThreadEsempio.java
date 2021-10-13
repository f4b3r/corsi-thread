public class ThreadEsempio {

    public static void main(String[] args) {

        // creazione thread con nuova classe --antico
       Thread t = new Thread(new ThreadSemplice());

       t.start();

        //creazione thread con uso di inner class
       Thread tInner = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("eseguo thread inner class");
           }
       });

       tInner.start();

       //creazione thread tramite interfaccia funzionale e lambda function

        Thread tLambda = new Thread(() -> {
            System.out.println("eseguo thread lambda function");
        });
        tLambda.start();
    }
}
