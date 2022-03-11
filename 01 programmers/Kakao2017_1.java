/*
 * @(#)Kakao2017_1.java $version 2022/03/11
 *
 */
package com.jason.argos;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Insu Yang
 */
public class Kakao2017_1 {

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count = 0;
    static int curNo = 0;

    public static void main(String[] args){

        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] answer = solution(m,n,picture);

        for(int a : answer){
            System.out.println(a);
        }
    }

    static int[] solution(int m, int n, int[][] picture){
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        map = picture;
        visited = new boolean[m][n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                count = 0;
                if(map[i][j] != 0 && visited[i][j] == false){
                    curNo = map[i][j];
                    dfs(i, j);
                    pq.add(count);
                }
            }
        }

        numberOfArea = pq.size();
        maxSizeOfOneArea = pq.peek();

        int[] answer = {numberOfArea, maxSizeOfOneArea};
        return answer;
    }

    static void dfs(int row, int col){
        visited[row][col] = true;
        count++;

        for(int idx = 0 ; idx < 4; idx++){
            int nxtRow = row + dy[idx];
            int nxtCol = col + dx[idx];

            if(nxtRow >= 0 && nxtRow < map.length && nxtCol >= 0 && nxtCol < map[0].length){
                if(map[nxtRow][nxtCol] == curNo && visited[nxtRow][nxtCol] == false){
                    dfs(nxtRow, nxtCol);
                }
            }

        }
    }
}
