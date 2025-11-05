package com.cmj.streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(){

   /*    Optional<String> a=  Optional.of("2323");
        String b = Optional.ofNullable("asas").orElse("empty");

        List<Integer> data = Arrays.asList(5,2,3,5,4);
        System.out.println(data.stream().reduce(0,(aa,bb)->aa+bb));
        System.out.println(data.stream().reduce(1,(aa,bb)->aa*bb));
        System.out.println(data.stream().sorted().skip(data.size()-1).toList());
        System.out.println(data.stream().reduce((ac,bc)->Integer.sum(ac,bc)));
        System.out.println(data.stream().reduce(Integer::sum));*/

        String data1 = "Welcome to oracle";
        /*List<String[]> da = Stream.of(data1).map(a -> a.split(" ")).collect(Collectors.toList());
        for(String s[]:da){
            System.out.println(s[1]);
        }*/

        String data = IntStream.range(0, data1.length()).mapToObj(a -> data1.split(" ")).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(data);

        List<String> names = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana", "Apple");
         Map<String, Long > data11 =names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         for(String key: data11.keySet()){
             System.out.println("Key:"+key+"  value"+data11.get(key));
         };

        List<Integer> responseTimes = Arrays.asList(1,2,3,50);



    }
}
