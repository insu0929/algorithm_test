/*
 * @(#)BOJ_2562.java $version 2022/02/11
 *
 */

import java.util.Scanner;

/**
 * @author Insu Yang
 */
public class BOJ_2562 {
    public static void main(String[] args){

        int[] arr = new int[9];

        int max = Integer.MIN_VALUE;

        int idx = 0;

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 9; i++){
            arr[i] = sc.nextInt();
        }


        for(int i = 0 ; i < 9; i++){
            int n = arr[i];
            if(n > max){
                max = n;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx + 1);
    }
}
