/*
 * @(#)BOJ_8958.java $version 2022/02/14
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){
            String line = br.readLine();
            System.out.println(getScore(line));
        }
    }

    public static int getScore(String line){
        int len = line.length();

        int prev = 0;

        int score = 0;

        for(int i = 0 ; i < len; i++){
            char c = line.charAt(i);

            if(c =='O'){
                score += prev + 1;
                prev++;
            }else{
                prev = 0;
            }
        }

        return score;
    }
}
