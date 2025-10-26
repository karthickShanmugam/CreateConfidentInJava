package com.cmj;

public class WrapperClassTest {

    public static void main(String[] args) {

        int number = 10;
        Integer number1 = new Integer(number);
        System.out.println("It is boxing(From int -> Integer): "+number1);

        Integer number2 = number;
        System.out.println("It is Auto boxing(From int -> Integer): "+number2);

        int number3 = number2.byteValue();
        System.out.println("It is unboxing(From Integer -> int): "+number3);

        int number4 = number2;
        System.out.println("It is auto unboxing(From Integer -> int): "+number4);

        String mark = "33";
        int markvalue = Integer.parseInt(mark);
        System.out.println("mark multiply by 8: "+markvalue*8);
        int rever = Integer.reverse(markvalue * 8);
        System.out.println("mark reverse: "+rever);
    }
}
