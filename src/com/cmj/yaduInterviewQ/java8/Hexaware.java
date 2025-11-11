package com.cmj.yaduInterviewQ.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Hexaware {

    //Expected output  12 is even, 5 is odd, 121 is odd, 20 is even
    public static void main(String[] a){

           oddEven5(); // From AI
          //oddEven4(); Working
         //oddEven3(); //Not working
         //oddEven2(); //Not working
         //oddEven1(); //Not working
    }

    public static void oddEven5(){
        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2,20,33);
        String d =  numbers.stream().map(number->number+" is "+ (number%2==0?"even":"odd")).collect(Collectors.joining(", "));
        System.out.print(d);
    }

    public static void oddEven4(){
        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2,20,33);
        AtomicInteger index = new AtomicInteger(0);
        numbers.stream().map(i->{
            if(i%2==0)
                System.out.print(i+" is even");
            else
                System.out.print(i+" is odd");
            if(index.get()!=numbers.size()-1)
                System.out.print(", ");
            index.getAndIncrement();
            return i;}).toList();
    }

    public static void oddEven3(){
        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2,20);
        Map<String, String> obj = new LinkedHashMap<>();

        for(Integer i : numbers){
            obj.put(String.valueOf(i), String.valueOf(i));
        }
        List<Integer> even =  numbers.stream().filter(i->i%2==0).toList();
        List<Integer> odd =  numbers.stream().filter(i->!(i%2==0)).toList();

        for(Integer e: even){
            obj.put(String.valueOf(e),e+" is even ");
        }
        for(Integer e: odd){
            obj.put(String.valueOf(e),e+" is odd ");
        }

        int index = 0;
        for(String key: obj.keySet()){
            if(index<obj.size()-1)
                System.out.print(obj.get(key)+", ");
            else
                System.out.print(obj.get(key));
            index++;
        }
    }

    public static void oddEven2(){
        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2);
        Map<String, String> obj = new LinkedHashMap<>();
        for(Integer i : numbers){
            obj.put(String.valueOf(i), String.valueOf(i));
        }
        List<Integer> even =  numbers.stream().filter(i->i%2==0).toList();
        List<Integer> odd =  numbers.stream().filter(i->!(i%2==0)).toList();

        for(Integer e: even){
            obj.put(String.valueOf(e),e+" is even");
        }
        for(Integer e: odd){
            obj.put(String.valueOf(e),e+" is odd");
        }

        int index = 0;
        for(String key: obj.keySet()){
            if(index<obj.size()-1)
                System.out.print(obj.get(key)+", ");
            else
                System.out.print(obj.get(key));
            index++;
        }
    }

    public static void oddEven1(){
        List<Integer> numbers = Arrays.asList(12,5,121,20,63,88,13,2);
        Map<String, String> obj = new HashMap<>();
        for(Integer i : numbers){
            obj.put(String.valueOf(i), String.valueOf(i));
        }
        List<Integer> even =  numbers.stream().filter(i->i%2==0).toList();
        List<Integer> odd =  numbers.stream().filter(i->!(i%2==0)).toList();

        for(Integer e: even){
            obj.put(String.valueOf(e),e+" is even");
        }
        for(Integer e: odd){
            obj.put(String.valueOf(e),e+" is odd");
        }

        int index = 0;
        for(String key: obj.keySet()){
            if(index<obj.size()-1)
                System.out.print(obj.get(key)+", ");
            else
                System.out.print(obj.get(key));
            index++;
        }
    }
}
