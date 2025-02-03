package _04_collections_iterator;

public class IterableDemo {
    public static void main(String[] args) {
        Hive hive = new Hive();
        while (hive.hasNext()) {
            System.out.println(hive.next());
        }
    }
}
