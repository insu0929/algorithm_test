/*
 * @(#)BOJ_1110.java $version 2022/02/01
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_1110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cycle = 0;

        int curNo = n;

        while(true){

            int ten = curNo / 10;
            int one = curNo % 10;

            int add = ten + one;

            int newOne = add % 10;

            curNo = one * 10 + newOne;

            cycle++;

            if(curNo == n){
                break;
            }
        }

        System.out.println(cycle);
    }
}
