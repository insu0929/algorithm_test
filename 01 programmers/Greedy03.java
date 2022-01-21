package com.company;

public class Greedy03 {

    //775841
    public static void main(String[] args){
        solution("4177252841", 4);
    }

    public static String solution(String number, int k){
        StringBuilder sb = new StringBuilder();

        int len = number.length();
        int anLen = len - k;

        int lastIdx = 0;

        for(int i = 0; i < anLen; i++){
            int max = 0;
            for(int j = lastIdx; j <= i + k ; j++){

                //int curDigit = Character.getNumericValue(number.charAt(j)); <- 10번 시간초과 이유
                int curDigit = number.charAt(j) - '0';
                if(curDigit > max){
                    max = curDigit;
                    lastIdx = j + 1;
                }

            }
            sb.append(max);
        }
        return sb.toString();
    }
}
