/*
 * @(#)BOJ_1789.java $version 2022/01/22
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_1789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long sum = 0;

        int n = 0;
        while(sum <= n){
            sum += n++;
        }

        if(sum == n) System.out.println(n);
        else System.out.println(n - 1);

    }
}
