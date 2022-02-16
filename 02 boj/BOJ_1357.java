/*
 * @(#)BOJ_1357.java $version 2022/02/16
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        int x = Integer.parseInt(in[0]);
        int y = Integer.parseInt(in[1]);

        System.out.println(getRev(getRev(x) + getRev(y)));
    }

    static int getRev(int num){

        int answer = 0;

        int d = (int)Math.log10(num);

        int tmp = num;


        while(tmp > 0){
            int n = tmp % 10;
            answer += n * (Math.pow(10, d--));
            tmp /= 10;
        }

        return answer;
    }
}
