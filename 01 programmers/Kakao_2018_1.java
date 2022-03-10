/*
 * @(#)Kakao_2018.java $version 2022/03/10
 *
 */
package com.jason.argos;

/**
 * @author Insu Yang
 */
public class Kakao_2018_1 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0 ; i < n; i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

            if(answer[i].length() < n){
                int idx = n - answer[i].length();
                for(int j = 0; j < idx; j++)
                    answer[i] = "0"+ answer[i];
            }

            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");

        }

        return answer;

    }
}
