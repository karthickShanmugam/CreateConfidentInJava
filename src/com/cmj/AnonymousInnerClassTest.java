package com.cmj;

class Behaviour {

    public void confident(){
        System.out.println("Be Confident in your life some time");
    }
}


public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        Behaviour behaviour = new Behaviour();
        behaviour.confident();

        Behaviour anonymousInnerbehaviour = new Behaviour(){
            public void confident(){
                System.out.println("Be Confident in your life always");
            }

            public void personality(){
                System.out.println("Be strong and confident in your life");
            }
        };
        anonymousInnerbehaviour.confident();

        new Behaviour(){
            public void confident(){
                System.out.println("Be Confident in your life always");
            }

            public void personality(){
                System.out.println("Be strong and confident in your life");
            }
        }.personality();
    }
}
