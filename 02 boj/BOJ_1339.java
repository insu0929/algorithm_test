package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> hm = new HashMap<>();

        String[] words = new String[n];

        for(int i = 0 ; i < n; i++){
            String w = br.readLine();
            words[i] = w;
            int len = w.length();

            for(int j = 0; j < len; j++){
                char c = w.charAt(j);
                int digit = (int)Math.pow(10, len - j - 1);

                if(hm.containsKey(c)){
                    hm.put(c, hm.get(c) + digit);
                }else{
                    hm.put(c, digit);
                }
            }
        }

        List<HashMap.Entry<String, Integer>> entryList = new LinkedList(hm.entrySet());
        entryList.sort(new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int num = 9;
        int sum = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            sum += entry.getValue() * num--;
        }

        System.out.println(sum);
    }
}
