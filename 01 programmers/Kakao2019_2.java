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

        int[] stuck = new int[N+2];
        int[] passed = new int[N+1];

        for(int i = 0; i < stages.length; i++){
            int userLvl = stages[i];

            stuck[userLvl]++;

            for(int j = 1; j < userLvl; j++){
                passed[j]++;
            }
        }

        List<double[]> failRate = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            double fail = (double)stuck[i] / (double)passed[i];
            failRate.add(new double[]{i, fail});
        }

        failRate.sort(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[1] > o2[1]) return -1;
                else if(o1[1] < o2[1]) return 1;
                else{
                    return (int)(o1[0] - o2[1]);
                }
            }
        });

        int[] answer = new int[N];

        for(int i = 1 ; i <= N; i++){
            answer[i-1] = (int)failRate.get(i)[0];
        }

        return answer;

    }


}
