package _05_collections_sequencedCollection;

import java.util.SequencedCollection;

public class BetterArrayListSequenced extends AbstractBetterArrayList implements SequencedCollection {

    @Override
    public SequencedCollection reversed() {
        return null;
    }

    @Override
    public void addFirst(Object o) {
        SequencedCollection.super.addFirst(o);
    }

    @Override
    public void addLast(Object o) {
        SequencedCollection.super.addLast(o);
    }
}
