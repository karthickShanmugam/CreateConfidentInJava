package com.cmj.collectTest;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiTypeFunctionalInterface {
    public static void main(String[] args) {
        //example1();
        //example2();
        //example3();
        example4();
    }

    public static void example4(){
        BiConsumer<Integer, Integer> add = (a,b)->{System.out.println(a+b);};
        BiConsumer<Integer, Integer> multiple = (a,b)->{System.out.println(a*b);};
        add.andThen(multiple).accept(5,5);
        IntConsumer obj = (a)->System.out.println(a*a);
        obj.accept(5);
    }

    public static void example3(){
        BiPredicate<String, String> secondName = (first, second) -> { return second.length()>0;};
        BiPredicate<String, String> firstNameSize = (first, second) -> { return first.length()<5;};
        /*System.out.println(secondName.test("karthick","shanmugam"));
        System.out.println(firstNameSize.test("kart",""));*/
        System.out.println(secondName.and(firstNameSize).test("kart","shanmugam"));
    }

    public static void example2(){
        List<String> firstName = Arrays.asList("Bat","Super","Wonder");
        List<String> secondName = Arrays.asList("Man","Man","Women");

        BiFunction<List<String>, List<String>, List<String>> join =  new BiFunction<>() {

            @Override
            public List<String> apply(List<String> firstName, List<String> secondName) {
                List<String> result = new ArrayList<>();
                    for(int i=0;i<firstName.size();i++){
                        result.add(firstName.get(i)+" "+secondName.get(i));
                    }
                return result;
            }
        };
        /*join.apply(firstName,secondName).forEach(System.out::println);

        firstName.stream().map(String::toUpperCase).forEach(System.out::println);*/
        Stream.concat(firstName.stream(),secondName.stream()).collect(Collectors.toList()).forEach(System.out::println);
    }
    public static void example1(){
        BiFunction<String, String, String> combainName = new BiFunction<>(){
            public String apply(String first, String second){
                return first.concat(" "+second);
            }
        };

        Function<String, Map<String, String>> nameCount = new Function<>(){
            @Override
            public Map apply(String first){
                Map<String, String>map = new HashMap<>();
                map.put("Name", "welcome "+first);
                map.put("Size", String.valueOf(map.get("Name").length()));
                return map;
            }
        };
        Map<String, String> count =  combainName.andThen(nameCount).apply("karthick","Shanmugam");
       /* String Result = combainName.apply("Karthick", "Shanmugam");
        System.out.println(Result);

       Map<String, String> count =  nameCount.apply("Karthick", "Shanmugam");*/
        for(String a: count.keySet()){
            System.out.println(a +"Value is: "+count.get(a));
        }
    }
}
