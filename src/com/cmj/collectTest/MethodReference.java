package com.cmj.collectTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

class RemoveDuplicate implements Function<List<Integer>, Set<Integer>> {
    public Set<Integer> apply(List<Integer> data){
        Set<Integer> result = new HashSet<>(data);
         return result;
    }
}


public class MethodReference {
    public MethodReference(Integer data) {
        System.out.println("Parameterized Constructor: "+(data*2));
    }
    public MethodReference() {
        System.out.println("Default Constructor");
    }

    public static Set<Integer> removeDuplicateData(List<Integer> data){
        Set<Integer> result = new HashSet<>(data);
        return result;
    }

    public Set<Integer> removeDuplicateDataInstance(List<Integer> data){
        Set<Integer> result = new HashSet<>(data);
        return result;
    }

    public static String multiply(Integer data){
        System.out.println("Multiply "+data*2);
        return "completed";
    }
    public static void main(String[] arg){
        MethodReference methodReferenceObj = new MethodReference();
        List<Integer> data = Arrays.asList(21,55,22,21,55,2,3,22,6);
        System.out.println("Normal function implementation");
        Function<List<Integer>, Set<Integer>> obj =  new RemoveDuplicate();
        obj.apply(data).forEach(System.out::println);

        System.out.println("Inner class function implementation");
        Function<List<Integer>, Set<Integer>> obj1 = new Function<List<Integer>, Set<Integer>>() {
            @Override
            public Set<Integer> apply(List<Integer> integers) {
                Set<Integer> result = new HashSet<>(integers);
                return result;
            }
        };
        obj1.apply(data).forEach(System.out::println);

        System.out.println("lambda function implementation");
        Function<List<Integer>, Set<Integer>> obj2 = (a)->{
            Set<Integer> result = new HashSet<>(a);
            return result;
        };
        obj2.apply(data).forEach(System.out::println);

        System.out.println("using static method reference function implementation");
        Function<List<Integer>, Set<Integer>> obj3 = MethodReference::removeDuplicateData;
        obj3.apply(data).forEach(System.out::println);

        System.out.println("using static different structure method reference function implementation");
        Consumer<Integer> obj4 =MethodReference::multiply;
        obj4.accept(55);

        System.out.println("using instance method reference function implementation");
        Function<List<Integer>, Set<Integer>> obj5 = methodReferenceObj::removeDuplicateDataInstance;
        obj5.apply(data).forEach(System.out::println);

        System.out.println("using constructor method reference function implementation");
        Consumer<Integer> obj6 = MethodReference::new;
        obj6.accept(22);

        System.out.println("using arbitrary method reference function implementation");
        Function<String,String> obj7 = String::toUpperCase;
        System.out.println(obj7.apply("Hello Karthick Shanmugam"));


    }

}
