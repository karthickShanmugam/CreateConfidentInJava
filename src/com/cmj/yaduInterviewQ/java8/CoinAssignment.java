package com.cmj.yaduInterviewQ.java8;

public class CoinAssignment {
   /* "Given an array of coins[] of size n and a target value sum, where coins[i] represent the coins of different denominations. You have an infinite supply of each of the coins. The task is to find the minimum number of coins required to make the given value sum. If it’s not possible to make a change, return -1.
    Examples:
    Input: coins[] = [25, 10, 5], sum = 30
    Output: 2
    Explanation : Minimum 2 coins needed, 25 and 5

    Input: coins[] = [9, 6, 5, 1], sum = 19
    Output: 3
    Explanation: 19 = 9 + 9 + 1

    Input: coins[] = [5, 1], sum = 0
    Output: 0
    Explanation: For 0 sum, we do not need a coin

    Input: coins[] = [4, 6, 2], sum = 5
    Output: -1
    Explanation: Not possible to make the given sum."
*/

    public static void main(String args[]) {

        int[] coins = {25, 10, 5};
        int sumAmt = 30;
        System.out.println("Minimum coin reqiured : " + minCoins(coins, sumAmt));

    }

    public static int minCoins(int[] coins, int sum) {

        int count = 0;
        for (int coin : coins) {
            if (sum >= coin) {           //30> 25

                count = count + sum / coin;    //     0+ 30/25

                sum = sum % coin;  //10
            }

        }

        return count;
    }
}
