package com.cmj;

@FunctionalInterface
interface Predict{
    void evaluate();
}

@FunctionalInterface
interface PredictWithParam{
    int evaluate(int a, int b);
}

class Life implements Predict {

    @Override
    public void evaluate() {
        System.out.println("Life is unpredictable");
    }
}

class FunctionalInterfaceTest {

     static void main(String[] args) {

         Life life = new Life();
         life.evaluate();

         Predict predict = new Life();
         predict.evaluate();

         Predict predict2 = new Predict(){
              public void evaluate(){
                 System.out.println("Life is Predictable on focus");
             }
         };
         predict.evaluate();

         Predict predict3 = ()->System.out.println("Life is Predictable on hardwork");
         predict3.evaluate();

         PredictWithParam pwp = (a,b)-> a+b;
         int result = pwp.evaluate(45,56);
         System.out.println(result);

          pwp = (a,b)-> { int c = a+b;
          return c;
          };
          result = pwp.evaluate(201,460);
          System.out.println(result);

    }

    static int add(int a, int b){
        return a+b;
    }
}
