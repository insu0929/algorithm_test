/*
 * @(#)Kakao2022_1.java $version 2022/02/21
 *
 */
package com.jason.argos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Insu Yang
 */
public class Kakao2022_1 {
    public static void main(String[] args){

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        //solution(id_list, report, k);
        System.out.println(solution(id_list, report, k));
    }

    static public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> map = new HashMap<>();
        List<HashSet<String>> rep = new ArrayList<>(); //누구에게 신고 당했는지
        List<HashSet<String>> his = new ArrayList<>(); //누굴 신고 했는지
        HashSet<String> bans = new HashSet<>();

        for(int i = 0 ; i < id_list.length; i++){
            rep.add(new HashSet<>());
            map.put(id_list[i], i);
            his.add(new HashSet<>());
        }

        for(int i = 0 ; i < report.length; i++){

            String[] line = report[i].split(" ");
            String reporter = line[0];
            String reportee = line[1];

            int id = map.get(reportee);
            int id2 = map.get(reporter);

            HashSet<String> hs = rep.get(id);
            if(!hs.contains(reporter)){
                hs.add(reporter);
            }

            if(hs.size() >= k){
                bans.add(reportee);
            }
            rep.set(id, hs);

            HashSet<String> hashSet = his.get(id2);
            hashSet.add(reportee);
            his.set(id2, hashSet);
        }

        for(int i = 0; i < id_list.length; i++){
            int id = map.get(id_list[i]);

            HashSet<String> hs = his.get(id);

            int count = 0;
            for(String ban : bans){
                if(hs.contains(ban)) count++;
            }

            answer[i] = count;
        }
        return answer;
    }
}
