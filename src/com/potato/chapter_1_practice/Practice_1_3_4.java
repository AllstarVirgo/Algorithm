package com.potato.chapter_1_practice;

import com.potato.chapterone.StackImplementedWithLink;

import java.util.Scanner;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class Practice_1_3_4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String content=in.nextLine();
        int n=content.length();
        if(n%2!=0){
            System.out.println("false");
            return;
        }
        StackImplementedWithLink<Character>left=new StackImplementedWithLink<>();
        boolean isMatched=true;
        for(int i=0;i<n;i++){
           char charAt=content.charAt(i);
           switch (charAt){
               case '[':
                   left.push(charAt);
                   break;
               case '(':
                   left.push(charAt);
                   break;
               case '{':
                   left.push(charAt);
                   break;
               case ']':
                   char recentPush=left.pop();
                   if(recentPush!='['){
                       isMatched=false;
                       System.out.println(isMatched);
                       return;
                   }
                   break;
               case ')':
                   char a_recentPush=left.pop();
                   if(a_recentPush!='('){
                       isMatched=false;
                       System.out.println(isMatched);
                       return;
                   }
                   break;
               case '}':
                   char b_recentPush=left.pop();
                   if(b_recentPush!='{'){
                       isMatched=false;
                       System.out.println(isMatched);
                       return;
                   }
                   break;
           }
        }
        System.out.println(isMatched);
    }
}
