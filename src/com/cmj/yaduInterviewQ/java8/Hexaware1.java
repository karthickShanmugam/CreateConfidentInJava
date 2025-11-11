package com.cmj.yaduInterviewQ.java8;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hexaware1 {

    public static void main(String[] a){

        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2,20,33);

        List<Integer> starting1 = numbers.stream().filter(i->i.toString().split("")[0].equals("1")).collect(Collectors.toList());
        System.out.println("Start with 1 using split: "+starting1);

        starting1  = numbers.stream().filter(num->num.toString().startsWith("1")).collect(Collectors.toList());
        System.out.println("Start with 1 using to String and startsWith: "+starting1);

        long count1 = numbers.stream().filter(num -> num.toString().startsWith("1")).count();
        System.out.println("Count of start with: "+count1);

        Optional<Integer> data = numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst();
        System.out.println("Second max number:"+data.orElse(0));

        List<Integer> data1 = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Ascending Order:"+data1.get(data1.size()-2));

        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("Average:"+ average.orElse(0));

        AtomicLong avg = new AtomicLong();
        numbers.stream().forEach(num->{avg.getAndAdd(num);});
        double average1 = avg.get()/numbers.size();
        System.out.println("Average"+average1);

        List<String> num = Arrays.asList("12","5","121","20","63","88","13","2","20","33");
        OptionalDouble aa = num.stream().mapToInt(Integer::parseInt).average();
        System.out.println(aa.orElse(0));


    }
}
