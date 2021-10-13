package magazzino;

public class Consumer implements Runnable{

    private WareHouse wareHouse;

    public Consumer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
        new Thread(this,"Consumer").start();
    }
    @Override
    public void run() {
        synchronized (wareHouse) {
            for (int i = 0; i < 10; i++) {
                wareHouse.get();
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
