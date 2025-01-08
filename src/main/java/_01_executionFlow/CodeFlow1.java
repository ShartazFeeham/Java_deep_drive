package _01_executionFlow;

public class CodeFlow1 {
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
    public CodeFlow1() {
        System.out.println("E");
    }

    public static void main(String[] args) {
        System.out.println("F");
        new CodeFlow1();
        System.out.println("G");
    }
}
