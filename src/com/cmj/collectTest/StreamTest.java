package com.cmj.collectTest;


import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

class StreamTest {
    public static void main(String[] args) {
        //usingLoops();
        //usingStream();
        //usingStream1();
        //usingStream2();
        //predicateTest();
        supplierAndConsumer();
    }
    public static void supplierAndConsumer(){

        Supplier<String> r = ()->{
            Calendar c = new GregorianCalendar();
            return String.valueOf(c.get(Calendar.YEAR));};
        System.out.println(r.get());

        Consumer<String> c = (d) -> System.out.println(d+" Karthick");
        Consumer<String> a = (d) -> System.out.println(d+" Shanmugam");
        c.andThen(a).andThen(a).andThen(a).accept("hello");

    }
    public static void predicateTest() {

        Predicate<Integer> firstSubject = (fs) -> fs > 0;
        Predicate<Integer> secondSubject = (fs) -> fs > 0;
        Predicate<Integer> orsubject = (fs) -> fs == 0;

        //System.out.println(firstSubject.test(12));
        //System.out.println(secondSubject.test(12));
        //boolean result = firstSubject.and(secondSubject).test(1);

        Predicate<Integer> data = firstSubject.and(secondSubject).or(orsubject);

        System.out.println(data.test(0));

    }

    public static void usingStream2() {
        Function<String, Integer> first = (i) -> {
            System.out.println(i +" Fist Input");
           return Integer.valueOf(Integer.valueOf(i)+6);
        };
        Function<Integer, String> second = (i) -> {
            System.out.println(i +" Second Input");
            return  String.valueOf(i * 2);
        };
        /*first.apply(12);
        second.apply(13);*/
        String d = first.andThen(second).apply("6");
        int i = first.compose(second).apply(6);

        System.out.println(d +"|"+i);
    }

    public static void usingStream1(){
      List<Integer> integers = Arrays.asList(12, 22, 13, 24, 15,47);

        Stream<Integer> data = integers.stream();
        Predicate<Integer> obj = new Predicate<>(){
            public boolean test(Integer t){
                return t % 2 == 0;
            }
        };

        data = data.filter(obj.negate());
        Function<Integer, Integer> function = new Function<>(){
            public Integer apply(Integer t){
                System.out.println(t*t);
                return t * t;
            }
        };
        data = data.map(function);

        BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>(){

            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        Integer result = data.reduce(7, accumulator);
        System.out.println(result);
    }
    public static void usingStream(){
        List<Integer> data = Arrays.asList(12, 22, 13, 24, 15,47);

      /* *//* Consumer<Integer> obj = new Consumer<>() {
            @Override
            public void accept(Integer o) {
                  System.out.println("From Consumer:"+o);
            }
        };*//*
        data.forEach( o -> System.out.println("From Consumer:"+o));*/

        Consumer<List<Integer>> obj = new Consumer<>() {
            @Override
            public void accept(List<Integer> o) {
                for(int index =0; index<o.size() ; index++){
                    o.set(index,o.get(index)*2);
                    System.out.println("obj called");
                }
            }
        };

        Consumer<List<Integer>> obj1 = new Consumer<>() {
            @Override
            public void accept(List<Integer> o) {
                o.stream().forEach(System.out::println);
                System.out.println("obj1 called");
            }
        };

    }

    public static void usingLoops(){
        List<Integer> data = Arrays.asList(12, 22, 13, 24, 15,47);
        int sum = 0;
        for(Integer i : data){
            if(i%2==0){
                sum+=(2*i);
            }
        }
        System.out.println(sum);
    }

}
