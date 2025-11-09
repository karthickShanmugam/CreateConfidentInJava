package com.cmj.yaduInterviewQ.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FindDuplicateInteger {

    public static void main(){
        List<Integer> obj = Arrays.asList(55,65,72,36,63,55,63,2);
        Set<Integer> obj1 = new HashSet<>();
        obj = obj.stream().filter(d->!obj1.add(d)).toList();
        System.out.println(obj);
    }

}
