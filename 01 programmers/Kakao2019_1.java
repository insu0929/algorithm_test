/*
 * @(#)Kakao2019_1.java $version 2022/03/11
 *
 */
package com.jason.argos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Insu Yang
 */
public class Kakao2019_1 {
    static List<HashSet<Integer>> candidateKey;
    static String[][] relation;

    public static void main(String[] args){

    }

    public static int solution(String[][] relation){
        int answer = 0;

        candidateKey = new ArrayList<>();
        Kakao2019_1.relation = relation;

        int colLen = relation[0].length;

        for(int i = 1 ; i <= colLen; ++i){
        }

        return answer;
    }

    static void makeKeyComb(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet){


    }
}
