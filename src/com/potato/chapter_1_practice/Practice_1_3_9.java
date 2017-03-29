package com.potato.chapter_1_practice;

import com.potato.chapterone.StackImplementedWithLink;
import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class Practice_1_3_9 {
    public static void main(String[] args) {
        StackImplementedWithLink<String>ops=new StackImplementedWithLink<>();
        StackImplementedWithLink<String>vals=new StackImplementedWithLink<>();

        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            String s=in.next();
            if(s.equals("("));
            else if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("sqrt"))ops.push(s);

            else if(s.equals(")")){
                String val=vals.pop();
                String op=ops.pop();
                if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/")) {
                    String result = String.format("( %s %s %s )", vals.pop(), op, val);
                    vals.push(result);
                }else if(s.equals("sqrt")){
                    String result=String.format("( %s %s )",op,val);
                    vals.push(result);
                }
            }else vals.push(s);
        }
        System.out.println(vals.pop());
    }


}
