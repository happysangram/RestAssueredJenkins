package GenericFramework.Tests.Stream;

@java.lang.FunctionalInterface
interface M1{
    void demo();
}

public class FunctionalInterface {
    public static void main(String[] args) {
        M1 m1=new M1() {
            @Override
            public void demo() {
                System.out.println("Functional Interface");
            }
        };
        m1.demo();
    }
}
