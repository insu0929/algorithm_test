/*
 * @(#)BOJ_1316.java $version 2022/01/28
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author Insu Yang
 */
public class BOJ_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 0 ; i < n; i++){
            String word = br.readLine();

            if(isGroupWord(word)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isGroupWord(String word){
        HashSet<Character> appeared = new HashSet<>();

        int len = word.length();
        char prev = '0';
        for(int i = 0 ; i < len; i++){
            char cur = word.charAt(i);
            if(cur != prev && appeared.contains(cur)){
                return false;
            }else{
                appeared.add(cur);
                prev = cur;
            }
        }
        return true;

    }
}
