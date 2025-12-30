package headfirst.designpatterns.singleton;

public class ChocolateController {
    public static void main(String[] args) {
        ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();

        System.out.println("Same instance? " + (boiler1 == boiler2));

        boiler1.fill();
        boiler2.boil();
        boiler1.drain();

        // second cycle to show state protection
        boiler2.drain();
        boiler2.fill();
        boiler1.boil();
        boiler2.drain();
    }
}
