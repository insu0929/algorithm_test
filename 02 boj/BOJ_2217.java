/*
 * @(#)BOJ_2217.java $version 2022/01/22
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Insu Yang
 */
public class BOJ_2217 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;

        for(int i = 0 ; i < n; i++){
            int curMin = arr[i];

            if(curMin * (n - i) > answer){
                answer = curMin * (n - i);
            }
        }

        System.out.println(answer);
    }
}
