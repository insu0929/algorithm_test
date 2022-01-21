package com.company;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/9012
public class BOJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            if(isVPS(str))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean isVPS(String exp){

        int len = exp.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < len; i++){
            char c = exp.charAt(i);

            if(c == '('){
                stack.add('(');
            }else{ // c == ')'
                if (stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }

}
