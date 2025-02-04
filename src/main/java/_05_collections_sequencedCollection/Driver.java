package _05_collections_sequencedCollection;

public class Driver {
    public static void main(String[] args) {
        IncrementingArrayList<Integer> collection = new IncrementingArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        System.out.println(collection.get(2));
        for (Integer i : collection) {
            System.out.println(i);
        }
    }
}
