/*
 * @(#)BOJ_1946.java $version 2022/01/23
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Insu Yang
 */
public class BOJ_1946 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++){

            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][2];

            for(int j = 0; j < n; j++){
                String[] line = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(line[0]);
                arr[j][1] = Integer.parseInt(line[1]);
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int count = 1;

            int[] prev = arr[0];

            for(int j = 1; j < n; j++){
                if(arr[j][1] < prev[1]){
                    count++;
                    prev = arr[j];
                }
            }

            System.out.println(count);
        }
    }
}
