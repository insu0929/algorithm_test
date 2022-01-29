/*
 * @(#)BOJ_2566.java $version 2022/01/29
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Insu Yang
 */
public class BOJ_2644 {
    static boolean[][] fTree;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] targets = br.readLine().split(" ");
        int tar1 = Integer.parseInt(targets[0]);
        int tar2 = Integer.parseInt(targets[1]);

        int m = Integer.parseInt(br.readLine());

        fTree = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i < m; i++){
            String[] tmp = br.readLine().split(" ");
            int p = Integer.parseInt(tmp[0]);
            int c = Integer.parseInt(tmp[1]);

            fTree[p][c] = true;
            fTree[c][p] = true;
        }

        dfs(tar1, tar2, 0);

        System.out.println(answer);

    }

    public static void dfs(int start, int end, int count){
        visited[start] = true;

        ArrayList<Integer> children = new ArrayList();

        for(int i = 0 ; i < fTree[start].length; i++){
            if(fTree[start][i])
                children.add(i);
        }

        int len = children.size();

        for(int i = 0 ; i < len; i++){
            int child = children.get(i);

            if(!visited[child]){
                if(child == end){
                    answer = count + 1;
                    return;
                }

                dfs(child, end, count+1);
            }
        }
    }
}
