package com.potato.chapter_2_practice.chapter_2_5;

import java.util.*;

/**
 * Created by AllstarVirgo on 2017/5/3.
 * 从标准输入读取一列字符串并按照字符串出现的频率又高到低的顺序打印出
 * 每个字符串及其出现次数
 */
public class Frequency {
    private TreeMap<Character,Integer>treeMap=new TreeMap<>();


    public void printStr(String string){
        char[] strToChar=string.toCharArray();
        Arrays.sort(strToChar);
        int N=strToChar.length;
        int count=1;
        for(int i=0;i<N;i++){
            if(i+1>=N){
                treeMap.put(strToChar[i],count);
                break;
            }
            if (strToChar[i]==strToChar[i+1])count++;
            else {
                treeMap.put(strToChar[i],count);
                count=1;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();

        Frequency frequency=new Frequency();

        frequency.printStr(string);

        List<Map.Entry<Character,Integer>> list = new ArrayList<>(frequency.treeMap.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });



        for(Map.Entry<Character,Integer> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }



}
