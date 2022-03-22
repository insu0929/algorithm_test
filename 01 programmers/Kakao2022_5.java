/*
 * @(#)Kakao2022_5.java $version 2022/02/25
 *
 */
package com.jason.argos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Insu Yang
 */
public class Kakao2022_5 {

    static int[] type;
    static List<Integer>[] adj;
    static int maxCount;

    public static void main(String[] args){

    }

    public static int solution(int[] info, int[][] edges){
        int answer = 0;
        type = info;
        adj = new List[info.length];

        for(int i = 0 ; i < info.length; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];

            adj[parent].add(child);
        }



        return answer;
    }

    static void dfs()


}
