/*
 * @(#)BOJ_2638.java $version 2022/02/03
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Insu Yang
 */

class Point{
    int row;
    int col;

    Point(int row, int col){
        this.col = col;
        this.row = row;
    }

    @Override
    public int hashCode() {
        return col * 31 + row;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)){
            return false;
        }
        Point p = (Point) obj;
        if(p.row == this.row && p.col == this.col) return true;
        else return false;
    }
}

public class BOJ_2638 {
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static HashSet<Point> air;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        map = new int[n][m];

        ArrayList<Point> cheese = new ArrayList();

        for(int i = 0 ; i < n; i++){
            String[] line = br.readLine().split(" ");

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j] == 1) cheese.add(new Point(n, m));
            }
        }


        while(!cheese.isEmpty()){
            //get air

            air = new HashSet<>();

            getAir(0, 0);

            //find cheese to melt

        }




    }

    static void getAir(int row, int col){




    }




}
