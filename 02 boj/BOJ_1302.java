/*
 * @(#)BOJ_1302.java $version 2022/02/17
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Insu Yang
 */
public class BOJ_1302 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String title = br.readLine();

            if(hm.containsKey(title)) hm.put(title, hm.get(title) + 1);
            else hm.put(title, 1);
        }

        List<String> keySet = new ArrayList<>(hm.keySet());

        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(hm.get(o1).compareTo(hm.get(o2)) == 0){
                    return o1.compareTo(o2);
                }else return hm.get(o2).compareTo(hm.get((o1)));
            }
        });

        System.out.println(keySet.get(0));


    }
}
