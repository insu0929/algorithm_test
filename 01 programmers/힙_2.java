package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        solution(jobs);
    }

    public static int solution(int[][] jobs){

        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0 ; i < jobs.length; i++){
            pq.offer(jobs[i]);
        }

        int time = 0;

        while(!pq.isEmpty()){

            PriorityQueue<int[]> wq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            while(!pq.isEmpty()){
                int[] top = pq.peek();

                if(top[0] <= time){
                    wq.offer(pq.poll());
                }else{
                    break;
                }
            }

            if(!wq.isEmpty()){
                int[] top = wq.poll();
                answer += top[1] + time - top[0];
                time += top[1];

                while(!wq.isEmpty()) {
                    pq.offer(wq.poll());
                }
            }else{
                time++;
            }
        }
        return (int)Math.floor(answer/ jobs.length);

    }
}
