package GenericFramework.Tests.Stream;

class dummy2{
    int i=20;
    public void demo(){
        System.out.println("dummy");
    }
    static class inner1{
        int k=10;
        public void demo(){
            System.out.println(k);
        }

    }
}

public class staticInnerClass {

    public static void main(String[] args) {
        dummy2 dd=new dummy2();
        System.out.println(dd.i);
        dd.demo();

        dummy2.inner1 kk=  new dummy2.inner1();
        kk.demo();
    }
}
