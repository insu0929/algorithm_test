package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        HashMap<Integer, Integer> hm = new HashMap<>();

        int len = n.length();

        for(int i = 0; i < len; i++){
            int digit = n.charAt(i) - '0';

            if(digit == 9) digit = 6;

            if(hm.containsKey(digit)){
                hm.put(digit, hm.get(digit) + 1);
            }else{
                hm.put(digit, 1);
            }
        }

        int max = 0;
        int sixNine = 0;

        for(int d : hm.keySet()){
            int count = hm.get(d);

            if(d == 6) sixNine = hm.get(d);
            else{
                if(count > max) max = count;
            }
        }

        sixNine = (int)Math.ceil((double)sixNine/2);
        if(max > sixNine) System.out.println(max);
        else System.out.println(sixNine);

    }
}
