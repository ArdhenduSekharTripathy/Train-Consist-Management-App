import java.util.*;
import java.util.stream.*;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String toString() {
        return type + "(" + capacity + ")";
    }
}

public class TrainAppUC13 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Bogie" + i, (int)(Math.random() * 100)));
        }

        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Execution Time: " + loopTime + " ns");
        System.out.println("Stream Execution Time: " + streamTime + " ns");
    }
}