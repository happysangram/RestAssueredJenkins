package GenericFramework.Tests.Stream;

class base{
    public void demo(){
        System.out.println("This is Base");
    }
}

public class AnnonymousInnerClass {
    public static void main(String[] args) {

        base bb=new base()
        {
            public void demo(){
                System.out.println("This is child");
            }
        };
        bb.demo();

    }


}
