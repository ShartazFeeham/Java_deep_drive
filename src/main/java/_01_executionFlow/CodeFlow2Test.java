package _01_executionFlow;

// Singleton
public class CodeFlow2Test {
    {
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
    static {
        System.out.println("C");
    }
    {
        System.out.println("D");
    }

    // Private constructor
    private CodeFlow2Test() {
        System.out.println("E");
    }

    private static CodeFlow2Test instance;
    public static synchronized CodeFlow2Test getInstance() {
        if (instance == null) {
            System.out.println("F");
            instance = new CodeFlow2Test();
        }
        System.out.println("G");
        return instance;
    }
}
