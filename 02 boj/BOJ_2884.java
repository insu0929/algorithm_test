/*
 * @(#)BOJ_2884.java $version 2022/01/25
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_2884 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        int mins = 45 - Integer.parseInt(t[1]);
                    //-10

        int hrs = Integer.parseInt(t[0]);

        if(mins <= 0){
            mins = -1 * mins;
        }else{
            mins = 60 - mins;
            hrs--;

            if(hrs < 0){
                hrs = 24 + hrs;
            }
        }

        System.out.println(hrs + " " + mins);

    }
}
