/*
 * @(#)BOJ_10026.java $version 2022/01/26
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Insu Yang
 */
public class BOJ_10026 {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new char[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 0 ; i < n; i++){
            String line = br.readLine();

            for(int j = 0 ; j < n; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int normal = 0;

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    normal++;
                }
            }
        }

        int colorBlind = 0;
        visited = new boolean[n+1][n+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        for(int i = 0 ; i < n ;i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    colorBlind++;
                }
            }
        }

        System.out.println(normal + " " + colorBlind);

    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        int n = map.length;
        char curColor = map[x][y];

        for(int i = 0; i < 4; i++){
            int nxtX = x + dx[i];
            int nxtY = y + dy[i];

            if (nxtX<0 || nxtY<0 || nxtX>n || nxtY>n){
                continue;
            }
            if (!visited[nxtX][nxtY] && map[nxtX][nxtY] == curColor){
                dfs(nxtX, nxtY);
            }

        }
    }
}
