/*
 * @(#)BOJ_13305.java $version 2022/01/23
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] roads = new long[n - 1];
        long[] prices = new long[n];

        String[] preRoad = br.readLine().split(" ");

        for(int i = 0 ; i < n -1; i++){
            roads[i] = Long.parseLong(preRoad[i]);
        }

        String[] prePrices =  br.readLine().split(" ");

        for(int i = 0 ; i < n; i++){
            prices[i] = Long.parseLong(prePrices[i]);
        }

        long cost = 0;

        long lastPrice = prices[0];
        for(int i = 0 ; i < prices.length - 1; i++){
            long curPrice = prices[i];

            if(lastPrice <= curPrice){
                cost += lastPrice * roads[i];
            }else{
                lastPrice = curPrice;
                cost += lastPrice * roads[i];
            }
        }

        System.out.println(cost);
    }
}
