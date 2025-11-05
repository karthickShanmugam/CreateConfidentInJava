package com.cmj.yaduInterviewQ.java8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
    public static void main(String[] args) {

        // 1. Find the maximum number in a list
        List<Integer> numbers = List.of(5, 3, 9, 1, 7, 10, 20, 29, 2, 3, 1, 4, 6, 8,5,15,20,45);
        var max = numbers.stream().max(Integer::compare).orElseThrow();
        System.out.println("max number from list  " + max);

        // 2. Count even numbers in a list
        var evenNum = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("even num in list : "+evenNum);

        // 3.  even numbers and odd number in List
        var evenAndOddNums = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("even  and Odd num in list : "+evenAndOddNums);

        //4. Convert list of strings to uppercase
        List<String> str = List.of("VAISHNAVI YADU");
        var strToUpper = str.stream().map(String::toLowerCase).toList();
        System.out.println("strToUpper :"+ strToUpper);

        // 5.Filter names starting with 'A'
        List<String> str2 = List.of("Apple","Arrow","Ant","Ball","Cat","Dog","anchor");
        var startWithA = str2.stream().filter(n->n.startsWith("a")).toList();
        System.out.println("A start with :"+ startWithA);

        //6. Find duplicate elements in a list
        HashSet<Integer> setI = new HashSet<>();
        var duplicateNumber = numbers.stream().filter(n->!setI.add(n)).toList();
        System.out.println("duplicate  Number :"+ duplicateNumber);

        //7. Get first 3 elements of a list
        var first3Num = numbers.stream().limit(3).toList();
        System.out.println("first 3 Num :"+ first3Num);

        //8. Skip first 2 elements
        var skip3Num = numbers.stream().skip(3).toList();
        System.out.println("first 3 Num :"+ skip3Num);

        //9. Sum of number
        var sumOfNum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum :"+ sumOfNum);

        //10. Check if any number is divisible by 5
        var divBy5 = numbers.stream().filter(n->n%5==0).collect(Collectors.toSet());
        System.out.println("div By 5 :"+ divBy5);

        //11. Sort list in descending order
        var sort = numbers.stream().sorted().toList();
        System.out.println("sort decs :"+ sort);

        // 12. Remove duplicates from list
        var duplicate = numbers.stream().distinct().toList();
        System.out.println("duplicate  :"+ duplicate);

        //13. Find average of a list of numbers
        var avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("avg  :"+ avg);

        var divBy5List = numbers.stream().filter(n->n%5==0).toList();
        System.out.println("div By 5 :"+ divBy5);

        //





    }
}
    