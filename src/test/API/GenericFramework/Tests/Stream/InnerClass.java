package GenericFramework.Tests.Stream;
class dummy{
    int i=20;
    public void demo(){
        System.out.println("dummy");
    }
     class inner{
        int k=10;
        public void demo(){
            System.out.println(k);
        }
    }
}
public class InnerClass {

    public static void main(String[] args) {
        dummy dd=new dummy();
        System.out.println(dd.i);
        dd.demo();

        dummy.inner kk= dd.new inner();
        kk.demo();

    }
}
