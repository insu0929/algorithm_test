/*
 * @(#)BOJ_2675.java $version 2022/02/13
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_2675 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++){
            String[] in = br.readLine().split(" ");

            int s = Integer.parseInt(in[0]);
            String p = in[1];

            int pLen = p.length();
            for(int j = 0; j < pLen; j++){
                for(int k = 0; k < s; k++){
                    System.out.print(p.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
