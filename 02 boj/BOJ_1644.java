/*
 * @(#)BOJ_1644.java $version 2022/05/03
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Insu Yang
 */
public class BOJ_1644 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] primes = erastosthenes(size);

        int count = 0;

        int start = 0; int end = 0;

        int sum = 0;

        while(true){
            if(sum >= size){
                sum -= primes[start++];
            }else if(end >= primes.length){
                break;
            }else{
                sum += primes[end++];
            }

            if(sum == size){
                count++;
            }
        }

        System.out.println(count);



    }

    static int[] erastosthenes(int size){
        boolean[] notPrime = new boolean[size + 1];
        ArrayList<Integer> primeList = new ArrayList<>();

        if(size < 2){
            return new int[]{};
        }

        notPrime[0] = notPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(size); i++){

            if(notPrime[i] == true){
                continue;
            }

            for(int j = i * i; j < notPrime.length; j = j + i) {
                notPrime[j] = true;
            }
        }


        for(int i = 2; i < notPrime.length; i++){
            if(!notPrime[i])
                primeList.add(i);
        }

        Collections.sort(primeList);
        int len = primeList.size();
        int[] primes = new int[len];

        int i = 0;
        for(int num : primeList){
            primes[i++] = num;
        }

        return primes;
    }
}
