/*
 * @(#)Kakao2022_2.java $version 2022/02/22
 *
 */
package com.jason.argos;

import java.util.Arrays;

/**
 * @author Insu Yang
 */
public class Kakao2022_2 {
    public static void main(String[] args){

        int n = 110011;

        int k = 10;

        //System.out.println(solution(n, k));

        solution(n, k);
    }

    static public int solution(int n, int k){

        String knary = kNary(n, k);
        String[] ps = knary.split("0");

        int answer = 0;

        for(String t : ps){
            if(!t.isEmpty() && !t.isBlank()){
                long p = Long.parseLong(t);
                if(isPrime(p)) answer++;

            }
        }
        return answer;

    }

    public static String kNary(int n, int k){
        String ans = "";
        while(n > 0){
            ans = (n % k) + ans;
            n /= k;
        }
        return ans;
    }

    public static boolean isPrime(long n){
        if(n == 1) return false;
        else if(n == 2) return true;

        for(int i = 3; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }

        return true;

    }

}
