/*
 * @(#)BOJ_10809.java $version 2022/02/10
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Insu Yang
 */
public class BOJ_10809 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();

        int[] alph = new int[26];

        for(int i = 0 ; i < 26; i++){
            alph[i] = -1;
        }

        for(int i = 0; i < len; i++){
            char c = str.charAt(i);
            int idx = c - 97;

            if(alph[idx] == -1)
                alph[idx] = i;
        }

        for(int i = 0 ; i < 26; i++){
            System.out.print(alph[i] + " ");
        }
    }
}
