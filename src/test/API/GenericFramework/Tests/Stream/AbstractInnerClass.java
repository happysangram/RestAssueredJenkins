package GenericFramework.Tests.Stream;

abstract class demo{
    abstract void dummy();
}

public class AbstractInnerClass {

    public static void main(String[] args) {
        demo demo=new demo() {
            @Override
            void dummy() {
                System.out.println("hi");
            }
        };

        demo.dummy();
    }
}
