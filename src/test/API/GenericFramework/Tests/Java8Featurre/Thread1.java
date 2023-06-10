package GenericFramework.Tests.Java8Featurre;

public class Thread1 {

    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        System.out.println(thread.getId());

        Thread thread1=new Thread();
        thread1.start();
        System.out.println(thread1.getId());
    }
}
