package _02_dataTypeAndNumberSystems;

public class IntegerClassWithNumberSystems {
    public static void main(String[] args) {
        // Octal
        int a = 077;
        // Not treated as octal
        int b = Integer.parseInt("077");
        // Now treated as octal
        int c = Integer.parseInt("077", 8);
        // Also can be converted into any base
        int d = Integer.parseInt("077", 20);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
