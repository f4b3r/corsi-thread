package magazzino;

public class WareHouse {

    private int numProducts;
    private int idProduct;
    private boolean empty = true;

    public synchronized void put(int idProduct){
        if(!empty){//se il magazzino non è vuoto attendi che il consumer ti notifichi lo svuotamento
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.idProduct = idProduct;
        numProducts++;
        empty = false;
        printSituazione("PRODOTTO " + idProduct);
        notify();// svegliamo il consumer!! c'è un prodotto da consumare
    }

    public synchronized int get(){
        if(empty){//se il magazzino è vuoto attendi che il producer metta un prodotto e ti notifica
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numProducts--;
        empty = true;
        notify();
        printSituazione("CONSUMATO " + idProduct);
        return this.idProduct;

    }

    private synchronized void printSituazione(String msg){
        System.out.println(msg + "\n" + numProducts + " nel magazzino");
    }
}
