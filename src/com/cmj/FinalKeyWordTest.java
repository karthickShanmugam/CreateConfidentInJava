package com.cmj;

 class Calculator {
    final double pi = 3.14;

    public void add(double x, double y) {
        System.out.println("Result = " + (x+y));
    }

     public void show(double x, double y) {
        System.out.println("Karthick Hello World "+pi);
        add(x,  y);
    }
}

class AdvanceCalculator extends Calculator {

    public void show(double x, double y) {
        System.out.println("Vigensh Hello World "+pi);
        add(x,  y);
    }
}

public class FinalKeyWordTest {

    public static void main(String[] args) {
        Calculator  c = new Calculator();
        //c.pi = 3.141;
       // c.show(5,5);

        c =  new AdvanceCalculator();
        c.show(10,10);
    }
}
