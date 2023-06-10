package GenericFramework.Tests.Java8Featurre;


class demo implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread starts");
    }
}

public class LambdaRunnableInterface {

    public static void main(String[] args) {
        Thread thread=new Thread(new demo());
        thread.run();
        System.out.println(thread.getId());

        Runnable runnable=()->{
            String s = "Runnable call";
        };

        Thread t2=new Thread(runnable);
        t2.run();
        System.out.println(t2.getId());


    }
}
