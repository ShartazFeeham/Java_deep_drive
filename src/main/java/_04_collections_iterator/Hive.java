package _04_collections_iterator;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;

public class Hive implements Iterator {

    private final Random random = new Random();
    private boolean isQueenLeft = false;

    @Override
    public boolean hasNext() {
        return !isQueenLeft;
    }

    @Override
    public Object next() {
        if (random.nextInt(100) == 1) {
            isQueenLeft = true;
            return Bee.QUEEN;
        }
        return random.nextInt(2) == 1 ? Bee.WORKER : Bee.DRONE;
    }

    @Override
    public void remove() {
        System.out.println("Removed a bee");
    }

    @Override
    public void forEachRemaining(Consumer action) {
        while (hasNext()) {
            next();
        }
    }

    private static enum Bee {
        QUEEN, WORKER, DRONE
    }
}
