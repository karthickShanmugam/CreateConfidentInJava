package com.cmj;

interface Computer{

    void run();
}

interface laptop extends Computer{

    void run();
    void run1();
}

class StudentI implements laptop, Computer{

    @Override
    public void run() {
        System.out.println("Student I run");
    }

    @Override
    public void run1() {
        System.out.println("Student I run1");
    }
}


public class InterfaceMoreClassTest {
    public static void main(String[] args) {

        Computer computer = new StudentI();
        computer.run();
        StudentI studentII = (StudentI) computer;
        studentII.run1();
        StudentI studentI = new StudentI();
        studentI.run1();
    }
}


