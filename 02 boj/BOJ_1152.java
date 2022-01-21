package com.company;
import java.util.*;
import java.io.*;

public class BOJ_1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(wordCount(str));
    }

    static int wordCount(String str){
        int answer = 0;

        //erase space at the start, end
        str = str.trim();

        String[] words = str.split(" ");

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0 ; i < words.length; i++){
            String preWord = words[i];
            int preLen = preWord.length();

            String word = String.valueOf(preWord);
            for(int j = 0; j < preLen; j++){
                char c = preWord.charAt(j);
                if(!Character.isAlphabetic(c)){
                    word = word.replace(String.valueOf(c), "");
                }
            }

            int finLen = word.length();

            if(finLen != 0){
                word = word.toLowerCase();
                if(hm.containsKey(word)){
                    hm.put(word, hm.get(word) + 1);
                }else{
                    hm.put(word, 1);
                }
            }
        }
        for(String key : hm.keySet()){
            answer += hm.get(key);
        }
        return answer;
    }
}
