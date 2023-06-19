package GenericFramework.Tests.Stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    public static void main(String[] args) {

        //Filter(Predicate)
        //      Boolean
        // Return True/False

        List<String> list=List.of("Sad","Aman","Amonda","Balram");
        list.stream().filter(e->e.startsWith("S")).forEach(e->System.out.println(e));

        List<String> m1 = list.stream().filter(e -> e.endsWith("m")).collect(Collectors.toList());
        System.out.println(m1);





        //Map(Function)
        //     return a element
        //return a value

        List<String> list1=List.of("Sad","Aman","Amonda","Balram");
        Set<String> stream =  list1.stream().map(e -> e.concat("_Stream")).collect(Collectors.toSet());
        System.out.println(stream);
        
        //Sorted/Min/Max
        
        List<Integer> l1=List.of(11,22,33,44,55,6666,1,12,9);

        Stream<Integer> stream1 = l1.stream();
        stream1.sorted().forEach(System.out::println);
        Integer int1 = l1.stream().min((x, y) -> x.compareTo(y)).get();
        System.out.println(int1);

        Integer int2 = l1.stream().max((x, y) -> x.compareTo(y)).get();
        System.out.println(int2);

    }
}
