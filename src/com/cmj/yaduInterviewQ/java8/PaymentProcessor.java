package com.cmj.yaduInterviewQ.java8;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// PaymentProcessor should be able triger notification after complete
// client should be blocked
class PayamentRequest{

    String udi;
    Double amt;

    public PayamentRequest(String udi, Double amt) {
        this.udi = udi;
        this.amt = amt;
    }
}

class  Notification{
    String sendNotification() {
        return "Send Notification".toString();
    }
}


public class PaymentProcessor {

    private final ExecutorService excute =
            Executors.newFixedThreadPool(5);
    private  Notification notification = new Notification();

    String paymentId = UUID.randomUUID().toString();

    public String process(PayamentRequest req) {

        CompletableFuture.supplyAsync(() ->
                        doPayment(paymentId, req), excute).
                thenAccept(res -> {
                    System.out.println(notification.sendNotification());
                });
        return paymentId;

    }


    private String doPayment(String paymentId, PayamentRequest req) {
        System.out.println("Start");
        try {

            Thread.sleep(2000);

            return req.udi + "Success";

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentId;
    }

    public void shutDowm() {
        excute.shutdown();
    }
}
class  Client {



public static void main(String[] args) {

PaymentProcessor service = new PaymentProcessor();

String payment1 = service.process(new PayamentRequest("11",121.00));

    String payment2 = service.process(new PayamentRequest("21",343.00));

       /* - > call payment service to process paylment
        - > Service should be able to receive success/failure response without being bloc*/
    System.out.println("Payment1" +payment1 +"Payment2" +payment2);

    try {
        Thread.sleep(4);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
service.shutDowm();

}

        }




