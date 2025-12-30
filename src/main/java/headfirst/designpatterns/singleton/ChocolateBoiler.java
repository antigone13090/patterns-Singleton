package headfirst.designpatterns.singleton;

public class ChocolateBoiler {

    // volatile: nécessaire pour le double-checked locking correct en Java
    private static volatile ChocolateBoiler instance;

    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) { // 1) fast path
            synchronized (ChocolateBoiler.class) {
                if (instance == null) { // 2) re-check
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("Filling the boiler with a milk/chocolate mixture");
        } else {
            System.out.println("Fill ignored: boiler already full");
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("Boiling the mixture");
        } else if (isEmpty()) {
            System.out.println("Boil ignored: boiler is empty");
        } else {
            System.out.println("Boil ignored: mixture already boiled");
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("Draining the boiled milk/chocolate");
        } else if (isEmpty()) {
            System.out.println("Drain ignored: boiler is empty");
        } else {
            System.out.println("Drain ignored: mixture not boiled yet");
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
