package _03_collections_spliterators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpliteratorDemo {
    public static void main(String[] args) {

        // 5000 random temperature objects
        List<Temperature> dataSet = Stream.generate(() ->
                        new Temperature("Celsius", Math.random() * 100))
                .limit(50000)
                .collect(Collectors.toCollection(LinkedList::new));

        tryAdvanceDemo(dataSet);
        System.out.println("=================<>==================");
        trySplitDemo(dataSet);
    }

    private static void tryAdvanceDemo(List<Temperature> dataSet) {
        // Get the Spliterator
        Spliterator<Temperature> spliterator = Spliterators.spliterator(dataSet, Spliterator.NONNULL);
        // *** performs the action provided and returns boolean true until all elements are processed
        while (spliterator.tryAdvance(System.out::println));
    }

    private static void trySplitDemo(List<Temperature> dataSet) {
        // *** splits the elements into two parts
        Spliterator<Temperature> split1 = dataSet.spliterator();
        Spliterator<Temperature> split2 = split1.trySplit();

        List<Temperature> articlesListOne = new ArrayList<>();
        List<Temperature> articlesListTwo = new ArrayList<>();

        split1.forEachRemaining(articlesListOne::add);
        split2.forEachRemaining(articlesListTwo::add);

        System.out.println(articlesListOne.size());
        System.out.println("------------------");
        System.out.println(articlesListTwo.size());
    }
}
