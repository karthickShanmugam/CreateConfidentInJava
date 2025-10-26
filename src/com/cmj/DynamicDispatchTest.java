package com.cmj;
class A {
    public void show(){
        System.out.println("in A show");
    }

    public void showA(){
        System.out.println("in AA show");
    }
}

class B extends A {
    public void show(){
        System.out.println("in B show");
    }
    public void showB(){
        System.out.println("in BB show");
    }
}

class C extends B {
    public void show(){
        System.out.println("in C show");
    }
}


public class DynamicDispatchTest {

    public static void main(String[] args){

        A a = new A();
        a.show();
        a = new B();
        a.show();
        a.showA();
        B bb = (B)a;
        bb.showB();

        a= new C();
        a.show();

        A b = (A) new B();
        b.show();
    }
}
