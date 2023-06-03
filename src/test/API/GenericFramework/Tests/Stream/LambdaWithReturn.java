package GenericFramework.Tests.Stream;

@java.lang.FunctionalInterface
interface add{
    int addition(int i,int j);
}

public class LambdaWithReturn {

    public static void main(String[] args) {
        add aa=(i,j)-> {
            System.out.println("Hi");
           return i+j;
        };
       int k= aa.addition(10,20);
       System.out.println(k);


        add aa1=(i,j)-> i+j;

        int k1= aa.addition(100,200);
        System.out.println(k1);
    }
}
