package com.company;

import java.util.*;

public class Ka2021_1 {
    static HashMap<String, ArrayList<Integer>> allCases;
    static ArrayList<Integer> scores;
    public static void main(String[] args){

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);

        for(int a : answer)
            System.out.print(a + " ");

    }

    public static int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];

        allCases = new HashMap<>();

        for(int i = 0; i < info.length; i++){
            String[] applicant = info[i].split(" "); // lang role career food score
            dfs("", 0, applicant);
        }

        for(String key : allCases.keySet()){
            ArrayList<Integer> scores = allCases.get(key);
            Collections.sort(scores);
            allCases.put(key, scores);

        }

        int idx = 0;
        for(String q : query){
            q = q.replaceAll("and","");
            q = q.replaceAll(" ", "");

            int score = Integer.parseInt(q.replaceAll("[^0-9]", ""));
            q = q.replaceAll("[0-9]", "");

            if(allCases.containsKey(q)){
                ArrayList<Integer> sc = allCases.get(q);
                int[] scores = new int[sc.size()];

                for(int i = 0 ; i < scores.length; i++){
                    scores[i] = sc.get(i);
                }
                //int count = scores.length - Arrays.binarySearch(scores, score);
                int count = search(q, score);
                answer[idx++] = count;
            }
        }
        return answer;
    }

    static void dfs(String comb, int depth, String[] applicant){
        if(depth == 4){
            int score = Integer.parseInt(applicant[4]);

            if(!allCases.containsKey(comb)){
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(score);
                allCases.put(comb, scores);
            }else{
                allCases.get(comb).add(score);
            }
            return;
        }

        dfs(comb + "-", depth+1, applicant);
        dfs(comb + applicant[depth], depth+1, applicant);

    }

    static int search(String str, int score) {
        if(!allCases.containsKey(str)) return 0;
        List<Integer> scoreList = allCases.get(str);
        int start= 0, end = scoreList.size()-1;
        while(start<=end) {

            int mid =(start+end)/2;
            if(scoreList.get(mid) <score) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return scoreList.size()-start;
    }


}
