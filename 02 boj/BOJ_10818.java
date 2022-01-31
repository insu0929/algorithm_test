/*
 * @(#)BOJ_10818.java $version 2022/01/31
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] tmp = br.readLine().split(" ");


        for(int i = 0 ; i < n; i++){
            int cur = Integer.parseInt(tmp[i]);

            if(max < cur) max = cur;
            if(min > cur) min = cur;
        }

        System.out.println(min + " " + max);
    }
}
