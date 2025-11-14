package com.cmj.yaduInterviewQ.java8;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hexaware1 {

    public static void main(String[] a){

          task4();
         //task3();
         //task2();
    }
    public static void task4(){

        List<Integer> a = Arrays.asList(1,2,4,1,2);
        a.stream().distinct().map(aa->aa*2).toList().forEach(System.out::println);

        List<List<Integer>> b = Arrays.asList(Arrays.asList(1,2,4,1,2), Arrays.asList(1,2,4,1,2));
        b.stream().flatMap(List::stream).distinct().map(cc->cc*2).forEach(System.out::println);


    }


    public static void task3(){
        List<Integer> num1 = Arrays.asList(121,333,123,1881,423,111,121);
           System.out.println("In Java 8");
           Function<Integer, String> obj = new Function<>(){
              @Override
              public String apply(Integer integer) {
                  Integer original = integer;
                  Integer reverse = 0;
                  for(int index =0; index<String.valueOf(integer).length();index++){
                      int temp = original%10;
                      original = original/10;
                      reverse=(reverse*10)+temp;
                  }
                  if(integer.equals(reverse))
                      return "Palindrome";
                  else
                      return "Non Palindrome";
              }
          };

        Map<String, List<Integer>> ans1 = num1.stream().collect(Collectors.groupingBy(obj));
        System.out.println(ans1);

        Map<Boolean, List<Integer>> ans2 = num1.stream().collect(Collectors.partitioningBy(i->i.toString().equals(new StringBuilder(i.toString()).reverse().toString())));
        System.out.println(ans2);

        //Before Java 8 Palindrome
        System.out.println("Before Java 8");
        List<Integer> num = Arrays.asList(121,333,123,1881,423,111);
        Map<Integer, String> result = new LinkedHashMap<>();
        for(Integer i : num){
            Integer original = i;
            Integer reverse = 0;
            for(int index =0; index<String.valueOf(i).length();index++){
                int temp = original%10;
                original = original/10;
                reverse=(reverse*10)+temp;
            }
            if(i.equals(reverse))
                result.put(i,"Palindrome");
            else
                result.put(i, "Non Palindrome");
        }
        System.out.println(result);
    }

    public static void task2(){
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
