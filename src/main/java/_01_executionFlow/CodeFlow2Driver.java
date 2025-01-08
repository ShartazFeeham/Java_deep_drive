package _01_executionFlow;

// Singleton
public class CodeFlow2Driver {
    {
        System.out.println("J");
    }
    static {
        System.out.println("K");
    }

    public static void main(String[] args) {
        System.out.println("H");
        CodeFlow2Test codeFlow2Test = CodeFlow2Test.getInstance();
        System.out.println("I");
    }
}
