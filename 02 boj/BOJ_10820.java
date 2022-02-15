/*
 * @(#)BOJ_10820.java $version 2022/02/15
 *
 */

import java.util.Scanner;

/**
 * @author Insu Yang
 */
public class BOJ_10820 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String s = sc.nextLine();
            int[] ans = getCnt(s);

            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }

    }

    static int[] getCnt(String s){
        int[] answer = new int[4];

        //lower caps num space
        int len = s.length();
        for(int i = 0 ; i < len; i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c))
                answer[0]++;
            else if (Character.isUpperCase(c))
                answer[1]++;
            else if (Character.isDigit(c))
                answer[2]++;
            else if (Character.isSpaceChar(c))
                answer[3]++;
        }
        return answer;
    }

}
