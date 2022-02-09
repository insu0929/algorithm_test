/*
 * @(#)BOJ_2577.java $version 2022/02/09
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Insu Yang
 */
public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());

        long mul = a * b * c;

        int[] count = new int[10];

        while(mul > 0){
            int n = (int)(mul % 10);
            count[n] = count[n] + 1;
            mul /= 10;
        }

        for(int n : count){
            System.out.println(n);
        }

    }
}
