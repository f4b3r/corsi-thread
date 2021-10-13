package magazzino;

public class Producer implements Runnable{

    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse){
        this.wareHouse = wareHouse;
        new Thread(this, "PRODUCER").start();
    }

    @Override
    public void run() {
        for(int i =1; i<=10; i++){
            wareHouse.put(i);
        }
    }
}
