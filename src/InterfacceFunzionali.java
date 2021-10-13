import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacceFunzionali {


    public static void main(String[] args) {
        List<Integer> numeri = Arrays.asList(3,1,6,4,9);

        Collections.sort(numeri, Collections.reverseOrder());

        for (Integer number: numeri
             ) {
            System.out.println(number);
        }

        Consumer<Integer> consumerQuadrato = (input) ->{
            System.out.println("risultato = " + input * input);
        };

        consumerQuadrato.accept(3);

        Consumer<String> consumerCheFaUppperCASE = new Consumer<String>() {
            @Override
            public void accept(String s) {

                System.out.println("stringa modificata = " + s.toUpperCase());
            }
        };

        consumerCheFaUppperCASE.accept("fabrizio");

        Supplier<Double> supplierNumeroRandom = () ->{

                return Math.random();
        };

        System.out.println("random numero " + supplierNumeroRandom.get() );

        String prova = "fabrizio";
String prova2 = "ciao";
        if (prova.charAt(1) == 'a'){
            System.out.println("è presente la a");
        }

        Predicate<String> controllaSecondoCarattereUgualeA = (test) ->{
            if(test.charAt(1) == 'a')
                return true;
            return false;
        };

        if(controllaSecondoCarattereUgualeA.test(prova)){
            System.out.println("è presente la a");
        }

        if(controllaSecondoCarattereUgualeA.test(prova2)){
            System.out.println("è presente la a");
        }else{
            System.out.println(" non è presente la a");
        }
    }
}
