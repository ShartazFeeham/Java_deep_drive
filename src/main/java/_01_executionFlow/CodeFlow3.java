package _01_executionFlow;

public class CodeFlow3 {
    public static void main(String[] args) {
        System.out.println("A");
        {
            System.out.println("B");
            {
                System.out.println("C");
            }
            {
                {
                    {
                        {
                            {
                                System.out.println("D");
                            }
                        }
                    }
                }
            }
            {{{{{{{{{{{}{}{}{}{}{}{}{}{}{}{}{}{{{{{{{{{{{{}{}{}{}{}{}{}{}{}{}{}{
                System.out.println("Brain is not braining...");
            }{}{}{}{}{}{}{}{}{}{}{}{}}}}}}}}}}}}{}{}{}{}{}{}{}{}{}{}{}}}}}}}}}}}
        }
    }
}
