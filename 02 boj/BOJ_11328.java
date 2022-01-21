package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_11328 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String answer = "";

        for(int i = 0 ; i < n; i++){
            String line = br.readLine();
            String[] input = line.split(" ");
            String origin = input[0];
            String strfry = input[1];
            answer = "Possible";

            HashMap<Character, Integer> orHm = getCount(origin);
            HashMap<Character, Integer> stHm = getCount(strfry);
            for(Character c : orHm.keySet()){
                int orVal = orHm.get(c);

                if(stHm.containsKey(c)){
                    int stVal = stHm.get(c);
                    if(orVal != stVal){
                        answer = "Impossible";
                        break;
                    }
                }else{
                    answer = "Impossible";
                    break;
                }

            }
            System.out.println(answer);

        }
    }
    static HashMap<Character, Integer> getCount(String str){
        int len = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < len; i++){
            char c = str.charAt(i);

            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) + 1);
            }else{
                hm.put(c, 1);
            }
        }
        return hm;
    }
}
