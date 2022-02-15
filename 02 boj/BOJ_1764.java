/*
 * @(#)BOJ_1764.java $version 2022/02/15
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Insu Yang
 */
public class BOJ_1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        HashSet<String> notHeard = new HashSet<>();

        for(int i = 0 ; i < n; i++){
            String name = br.readLine();
            notHeard.add(name);
        }

        TreeSet<String> answer = new TreeSet<>();

        for(int i = 0 ; i < m; i++){
            String name = br.readLine();
            if(notHeard.contains(name))
                answer.add(name);
        }

        System.out.println(answer.size());
        for(String name : answer){
            System.out.println(name);
        }
    }
}
