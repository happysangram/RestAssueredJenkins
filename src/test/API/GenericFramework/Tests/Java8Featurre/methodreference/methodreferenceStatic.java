package GenericFramework.Tests.Java8Featurre.methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;

public class methodreferenceStatic {

    public static Integer de(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        Function<Integer,Double> function=(n)-> Math.sqrt(n);
        System.out.println(function.apply(100));

        Function<Integer,Double> function1=Math::sqrt;
        System.out.println(function1.apply(100));


        BiFunction<Integer,Integer,Integer> function2=(a,b) -> methodreferenceStatic.de(a,b);
        System.out.println(function2.apply(11,22));

        BiFunction<Integer,Integer,Integer> function3=methodreferenceStatic::de;
        System.out.println(function3.apply(111,222));

    }
}
