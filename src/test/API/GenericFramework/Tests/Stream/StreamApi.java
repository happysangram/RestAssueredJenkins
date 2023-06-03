package GenericFramework.Tests.Stream;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    @Test
    public void Stream(){

//        System.out.println("Stream API");
//         List<Integer> list= List.of(12,45,67,78,44,67,89);
//        List<Integer> list1=Arrays.asList(66,878,78,46,77,99);
//        List<Integer> list2=new ArrayList<>();
//        list2.add(56);
//        list2.add(576);
//        list2.add(506);
//        list2.add(579);
//        System.out.println(list);
////        System.out.println(list1);
////        System.out.println(list2);
//        List<Integer> list3=new ArrayList<>();
//        for (Integer i:list){
//            if(i%2==0){
//                list3.add(i);
//            }
//        }
//       // System.out.println(list3);
//
//        Stream<Integer> stream = list.stream();
//        List<Integer> collect = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
//        System.out.println(collect);

        List<Integer> ll=List.of(10,22,33,44,55);
        Stream<Integer> stream1 = ll.stream();
        stream1.forEach(e->{
            System.out.println(e);
        });

    }
}
