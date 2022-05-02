/*
 * @(#)BOJ_2003.java $version 2022/04/25
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[] a = new int[n];

        tmp = br.readLine().split(" ");
        for(int i = 0 ; i < n; i++){
            a[i] = Integer.parseInt(tmp[i]);
        }

        int count = 0;
        int start = 0; int end = 0;

        int sum = 0;
        while(true){
            if(sum >= m){
                sum -= a[start++];
            }else if (end >= n){
                break;
            }else{
                sum += a[end++];
            }

            if(sum == m){
                count++;
            }
        }

        System.out.println(count);

    }

}
