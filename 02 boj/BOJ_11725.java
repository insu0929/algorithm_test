/*
 * @(#)BOJ_11725.java $version 2022/01/30
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Insu Yang
 */
public class BOJ_11725 {

    static ArrayList<ArrayList<Integer>> relTree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        relTree = new ArrayList();

        for(int i = 0; i < n; i++){
            relTree.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i < n - 1; i++){
            String[] tmp = br.readLine().split(" ");

            int node1 = Integer.parseInt(tmp[0]) - 1;
            int node2 = Integer.parseInt(tmp[1]) - 1;

            relTree.get(node1).add(node2);
            relTree.get(node2).add(node2);

        }

        System.out.println(relTree.get(1).get(0));





    }
}
