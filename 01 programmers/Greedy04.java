package com.company;

import java.util.*;

public class Greedy04 {

    public static void main(String[] args){
        int[] people = {70, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    /* 풀이 로직
    * 남아있는 사람들 중 (가장 가벼운 사람, 가장 무거운 사람) 이 보트 무게 한계를 넘지 않으면 태우는게 베스트 시나리오 (greedy)
    * 이게 최적의 결과를 보장하는 이유: 사람들을 무게 순으로 정렬하면 나보다 무거운 사람은 무조건 나와 탑승한 사람보다 가벼운 사람과 탑승을 해야하기 때문이다.
    * */
    public static int solution(int[] people, int limit){
        int answer = 0;

        //무게 순으로 정렬
        Arrays.sort(people);

        //혼자 타야되는 사람 수
        int single = 0;

        //가장 무거운 사람 index
        int last = people.length -1;

        int cur = 0;

        //마지막 남은 사람 파악하기 위해 지금까지 탑승한 사람들 기록
        HashSet<Integer> history = new HashSet();

        //배열 순회는 양쪽 끝에서 서로 만날 때까지
        while(cur + 1 <= last){
            int small = people[cur];
            int big = people[last];

            if(small + big <= limit){
                history.add(cur);
                history.add(last);
                cur++;
                answer++;
                last--;
            }else{
                history.add(last);
                last--;
                single++;
            }
        }
        //마지막 한 사람
        if(!history.contains(cur)) answer++;

        return answer+single;
    }
}
