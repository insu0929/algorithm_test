/*
 * @(#)BOJ_4673.java $version 2022/02/12
 *
 */

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Insu Yang
 */
public class BOJ_4673 {
    public static void main(String[] args){
        HashSet<Integer> list = new HashSet<>();

        for(int i = 1 ; i <= 10000; i++){
            int n = i;
            int dn = 0;

            while(n > 0) {
                dn += n%10;
                n /= 10;
            }

            dn = dn + i;
            list.add(dn);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 1; i <= 10000; i++){
            if(!list.contains(i))
                answer.add(i);
        }

        for(int no : answer){
            System.out.println(no + " ");
        }

    }
}
