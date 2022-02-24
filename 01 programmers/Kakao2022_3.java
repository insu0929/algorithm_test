package com.company;

import java.util.HashMap;
import java.util.TreeMap;

public class Kakao2022_3 {
    public static void main(String[] args){
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        solution(fees, records);
    }

    static public int[] solution(int[] fees, String[] records){
        TreeMap<String, Integer> tm = new TreeMap<>();
        HashMap<String, String> hm = new HashMap<>();

        for(String rec : records){
            String[] parsed = rec.split(" ");
            String ts = parsed[0];
            String carNo = parsed[1];
            String flag = parsed[2];

            if(flag.contentEquals("IN")){
                hm.put(carNo, ts);
            }else{
                String inTime = hm.get(carNo);
                int timeDiff = getTimeDiff(inTime, ts);

                if(tm.containsKey(carNo)){
                    tm.put(carNo, tm.get(carNo) + timeDiff);
                }else{
                    tm.put(carNo, timeDiff);
                }

                hm.remove(carNo);
            }
        }

        if(!hm.isEmpty()){
            for(String key : hm.keySet()){
                int timeDiff = getTimeDiff(hm.get(key), "23:59");

                if(tm.containsKey(key)){
                    tm.put(key, tm.get(key) + timeDiff);
                }else{
                    tm.put(key, timeDiff);
                }
            }
        }

        int[] answer = new int[tm.size()];

        String[] keys = tm.keySet().toArray(new String[0]);

        for(int i = 0 ; i < keys.length; i++){
            String carNo = keys[i];
            answer[i] = getFee(fees, tm.get(carNo));
        }
        return answer;
    }

    static int getFee(int[] fees, int time){
        int minTime = fees[0];
        int minFee = fees[1];
        int addMin = fees[2];
        int addFee = fees[3];


        if(time <= minTime) return minFee;
        else{
            double added = Math.ceil((double)(time-minTime) / (double)addMin);
            return (int)(minFee + added * addFee);
        }
    }

    static int getTimeDiff(String in, String out){
        String[] ins = in.split(":");
        String[] outs = out.split(":");

        int inHr = Integer.parseInt(ins[0]);
        int inMin = Integer.parseInt(ins[1]);

        int outHr = Integer.parseInt(outs[0]);
        int outMin = Integer.parseInt(outs[1]);

        return (outHr-inHr)*60 + (outMin - inMin);
    }


}
