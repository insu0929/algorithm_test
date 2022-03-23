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

        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        solution(info, edges);
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

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);

        System.out.println(maxCount);
        return maxCount;
    }

    static void dfs(int curNode, int sheepCnt, int wolfCnt, List<Integer> children) {

        sheepCnt += type[curNode] ^ 1;
        wolfCnt += type[curNode];

        if (wolfCnt >= sheepCnt) return;

        maxCount = Math.max(maxCount, sheepCnt);


        List<Integer> list = new ArrayList<>();
        list.addAll(children);

        list.remove(Integer.valueOf(curNode));

        if(adj[curNode] != null){
            for(int nxt : adj[curNode]){
                list.add(nxt);
            }
        }

        for(int next : list){
            dfs(next, sheepCnt, wolfCnt, list);
        }
    }


}
