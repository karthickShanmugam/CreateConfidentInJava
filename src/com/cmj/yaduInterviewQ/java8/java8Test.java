package com.cmj.yaduInterviewQ.java8;

import com.cmj.yaduInterviewQ.java8.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java8Test {

    public static void main(String args[]) {
            List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        String strInput = "heel and Feel";
        String[] stringarry =strInput.split(" ");
        // print even
        var even = myList.stream().filter(env->env%2==0).toList();
        System.out.println("even:" +even);
        // print even and old
        var evenAndOdd = myList.stream().collect(Collectors.partitioningBy(env->env%2==0));
        System.out.println("even:" +evenAndOdd);

        //Find the repetitive character from a word or sentence using java8

        var repetitiveSeqChar = strInput.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c->(char)c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toList());
        System.out.println("repetitive character from a word:" +repetitiveSeqChar);

        //reverse String

        var strR = Arrays.stream(stringarry).map(s -> new StringBuilder(s).reverse()).collect(Collectors.toList());

        System.out.println("reverse String"+strR);

        //      String strInput = "heel and heel for feel"; count word repeated
        String strInput2 = "heel and heel for feel";
        var repeatedSeqWord = Arrays.stream(strInput2.split("  ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("count word repeated"+repeatedSeqWord);


        // Employee max salary by department
        List<Employee> employeeList = Arrays.asList(
                new Employee("ram","male","IT",110000.00),
                new Employee("jam","female","HR",40000.00),
                new Employee("jaua","male","LT",10000.00),
                new Employee("jaya","female","IT",4000000.00)
        );


        var emplist =employeeList.stream().
                collect(Collectors.
                        groupingBy(Employee ::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("Employee max salary by department"+emplist);

        //// print duplicate from list
        List<Integer> ipNum = Arrays.asList(1,2,2,5,7,8,7);
        System.out.println("Duplicate i/p"+ipNum);

        HashSet<Integer> notAllowDuplicate = new HashSet<>();

        var duplicateNum = ipNum.stream().
                filter(n->!notAllowDuplicate.add(n)).
                collect(Collectors.toSet());
        System.out.println("w/o Duplicate o/p"+duplicateNum);

        //// start with A and salry > 1000

        var result = employeeList.stream()
                .filter(e -> e.getName().startsWith("r"))
                .filter(e -> e.getSalary() > 1000)
                .collect(Collectors.toList());
        System.out.println("start with A and salry > 1000"+result);

        // duplicate word in String array
        String[] arr = {
                "java Ruby Struts",
                "spring java",
                "spring python spring"
        };

        Map<String, Long> wordCount =
                Arrays.stream(arr)
                        .flatMap(s -> Arrays.stream(s.toLowerCase().split("\\s+")))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        wordCount.forEach((k, v) -> System.out.println(k + " = " + v));

        /// patition by palindrom
        List<Integer> numbers = Arrays.asList(121, 23, 11, 454, 67, 101, 22, 900);

        var  listPalindrom = numbers.stream()
                .collect(Collectors.partitioningBy(n->n.toString().equals( new StringBuilder(n.toString()).reverse().toString())));
        System.out.println("Palindrom"+listPalindrom);

        // from list find start with 1

        var startWithOne = numbers.stream().filter(n->n.toString().startsWith("1")).collect(Collectors.toList());

        System.out.println("start with 1 "+startWithOne);

        // even numbers and odd number in List
        var evenAndOddNums = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("even  and Odd num in list : "+evenAndOddNums);


        // i/p1,0,7,0,2,0,5,0,9,0  o/p ==[1,7,2,5,0,0,0,0]
        List<Integer> myListOrder = Arrays.asList(1,0,7,0,2,0,5,0,9,0);

        var outPut= Stream.concat( myListOrder.stream().filter(n->n!=0) ,
                myListOrder.stream().filter(n->n==0)).collect(Collectors.toList());

        System.out.println("o/p"+outPut);


        /// average
        var averageL = numbers.stream().mapToInt(n->n).average();
        System.out.println("average : "+averageL);


        //java8  print 2 end highest char in string
        String ip = "oh my god in love my india";
        String inp1= ip.replaceAll("\\s","").toString();
        var op= inp1.chars().mapToObj(c->(char)c).
                collect(Collectors.
                        groupingBy(ch->ch,Collectors.counting()))
                .entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1).findFirst();
        System.out.println(op);

        // print 2nd largest number from list

        List<Integer> numList2ndLargest = Arrays.asList(2, 4, 6, 8, 1, 3, 5, 7);
        var numList2ndLargest1 = numList2ndLargest.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        System.out.println("numList2ndLargest"+numList2ndLargest1);

        //java8  1 larger number occurecnce  [AA=3]
        List<String> myListAA = Arrays.asList("AA", "BB", "AA", "CC","AA","BB");

        var op1=myListAA.stream().
                collect(Collectors.
                        groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println("op String "+op1);



    }
}
