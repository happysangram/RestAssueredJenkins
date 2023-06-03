package GenericFramework.Tests.Stream;

interface demo1{
    void dummy();
    void cat();
}

public class InterfaceInnerClass {
    public static void main(String[] args) {
        demo1 demo1=new demo1() {
            @Override
            public void dummy() {
                System.out.println("hi");
            }

            @Override
            public void cat() {
                System.out.println("cat");
            }
        };
        demo1.dummy();
        demo1.cat();
    }
}
