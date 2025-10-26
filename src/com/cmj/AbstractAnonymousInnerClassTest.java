package com.cmj;

abstract class Interview {
    public abstract void result();

    public void finalResult() {
        System.out.println("finalResult can we pass or fail");
    }
}

public class AbstractAnonymousInnerClassTest {
    public static void main(String[] args) {

        Interview interview = new Interview() {
            @Override
            public void result() {
               System.out.println("You have pass the exam");
            }
        };
        interview.finalResult();
        interview.result();
    }
}
