/*
 * @(#)BOJ_2583.java $version 2022/01/27
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @author Insu Yang
 */
public class BOJ_2583 {

    static int[][] map;
    static boolean[][] visited;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dim = br.readLine().split(" ");

        int col = Integer.parseInt(dim[0]);
        int row = Integer.parseInt(dim[1]);

        int k = Integer.parseInt(dim[2]);

        int[][] rects = new int[k][2];


        for(int i = 0 ; i < k; i++){
            String[] rectCoor = br.readLine().split(" ");

        }

    }
}
