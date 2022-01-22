/*
 * @(#)BOJ_10610.java $version 2022/01/22
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Insu Yang
 */
public class BOJ_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int len = n.length();
        Integer[] arr = new Integer[len];

        for(int i = 0 ; i < len; i++){
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0 ; i < len - 1; i++){
            sum += arr[i];
            sb.append(arr[i]);
        }
        sb.append(0);

        if(sum % 3 != 0 || arr[len - 1] != 0){
            System.out.println(-1);
        }else{
            System.out.println(sb.toString());
        }
    }
}
