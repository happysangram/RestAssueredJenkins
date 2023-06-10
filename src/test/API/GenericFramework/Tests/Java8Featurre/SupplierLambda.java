package GenericFramework.Tests.Java8Featurre;

import java.time.LocalDateTime;
import java.util.function.Supplier;

//class demo1 implements Supplier<LocalDateTime> {
//
//    @Override
//    public LocalDateTime get() {
//        return LocalDateTime.now();
//    }
//}

public class SupplierLambda {

    public static void main(String[] args) {
//        demo1 me = new demo1();
//        System.out.println(me.get());

        Supplier<LocalDateTime> ss = () -> LocalDateTime.now();
        System.out.println(ss.get());
    }
}
