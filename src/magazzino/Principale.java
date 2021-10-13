package magazzino;

public class Principale {

    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
        new Producer(wareHouse);
        new Consumer(wareHouse);
        System.out.println("thread principale muore");
    }
}
