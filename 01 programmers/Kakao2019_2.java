/*
 * @(#)Kakao2019_2.java $version 2022/02/25
 *
 */
package com.jason.argos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Insu Yang
 */
public class Kakao2019_2 {
    public static void main(String[] args){

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        //System.out.println(solution(N, stages));
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];

        List<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            list.add(new int[]{i, 0});
        }

        for(int i = 0; i < stages.length; i++){
            int userLvl = stages[i];
            int[] stage = list.get(userLvl);
            stage[1]++;
            list.set(userLvl, stage);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]) return -1;
                else if(o1[1] < o2[1]) return 1;
                else{
                    return o1[0] - o2[0];
                }
            }
        });

        for(int i = 0 ; i < N; i++){
            answer[i] = list.get(i)[0];
        }

        return answer;

    }


}
