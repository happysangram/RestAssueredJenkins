package GenericFramework.Tests.Stream;

interface fun{
    void cool(int i);
}

public class LambdaExpression {
    public static void main(String[] args) {
        fun f= (int i)-> System.out.println("dummy " + i);
        f.cool(5);

        fun f1= i-> System.out.println("dummy " + i);
        f1.cool(55);

        fun f2=jj-> {
            int kk=jj+jj;
            System.out.println(kk);
        };
        f2.cool(11);


    }
}
