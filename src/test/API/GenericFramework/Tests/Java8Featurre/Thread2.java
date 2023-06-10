package GenericFramework.Tests.Java8Featurre;

class dd extends Thread{

    public void run(){
        System.out.println("Thread class00000");
    }

}

public class Thread2 {
    public static void main(String[] args) {
        dd mm=new dd();
        mm.start();
        System.out.println(mm.getId());


    }
}
