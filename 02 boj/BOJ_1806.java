/*
 * @(#)BOJ_1806.java $version 2022/05/04
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_1806 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);

        int[] arr = new int[n];

        String[] pStr = br.readLine().split(" ");

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(pStr[i]);
        }

        int minLen = n;

        int start = 0; int end = 0;

        int sum = 0;

        while(true){
            if(sum >= s){
                sum -= arr[start++];
            }else if(end >= n){
                break;
            }else{
                sum += arr[end++];
            }

            if(sum == s){
                int diff = end - start;
                minLen = Math.min(minLen, diff);
            }
        }

        System.out.println(minLen);
    }
}
