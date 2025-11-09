package com.cmj.yaduInterviewQ.java8;

import java.util.*;


//Epac company
public class EpacCompany {
    public static void main(String a[]){
      List<User> users = Arrays.asList( new User(Integer.valueOf(1), Arrays.asList(1,9,2)),
                                        new User(Integer.valueOf(2), Arrays.asList(5,1)),
                                        new User(Integer.valueOf(3), Arrays.asList(7,3,1)),
                                        new User(Integer.valueOf(4), Arrays.asList(1,8)),
                                        new User(Integer.valueOf(5), Arrays.asList(1,3,8))
      );
      Map<Integer, Integer> count = new HashMap<>();
      for(User u : users){
        for(Integer s : u.subscriptionId){
            if(count.get(s)==null){
                count.put(s,1);
            }
            else{
                count.put(s,count.get(s)+1);
            }
        }
      }

        System.out.println(count.toString());

      Integer max = 0;
      Integer Key = 0;
      for(Integer k : count.keySet()){
            if(count.get(k)>max) {
                max = count.get(k);
                Key = k;
            }
      }
      System.out.println(max);
      System.out.println(Key);

    }
}

class User{
    Integer userId;
    List<Integer> subscriptionId;


    public User(Integer userId, List<Integer> subscriptionId){
        this.userId = userId;
        this.subscriptionId = subscriptionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<Integer> getSubscriptionId() {
        return subscriptionId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setSubscriptionId(List<Integer> subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
