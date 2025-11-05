package com.cmj.yaduInterviewQ.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8statwith1 {

    public static  void  main(String arg[])
    {

        List<Integer> list = Arrays.asList(5,10,2,22,33,12,45,80,41,70);



        List<String> list1=list.stream().map(s->s+"").filter(s -> s.startsWith("1")).collect(Collectors.toList());

        System.out.println(list1);


    }
}
