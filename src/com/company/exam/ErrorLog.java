package com.company.exam;

import java.util.*;

/**
 * Created by ZJZL_HP on 2018/6/4.
 */
public class ErrorLog {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (!scanner.hasNext("quit")){
            String filePath = scanner.next();
            String rowNum = scanner.next();

            int index = filePath.lastIndexOf("\\");
            String fileName = (index ==-1) ? filePath: filePath.substring(index+1,filePath.length());
            String key = fileName + "_" +rowNum;

            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        Comparator<Map.Entry<String,Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()-o2.getValue())==0? 0:(o2.getValue()-o1.getValue());
            }
        };


        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list,comparator);

        int num = list.size()>8?8:list.size();
        for(int i=0;i<num;i++){
            Map.Entry<String,Integer> entry = list.get(i);
            String s = entry.getKey();
            String[] strings = s.split("_");
            if(strings[0].length()>16)
                strings[0] = strings[0].substring(strings[0].length()-16,strings[0].length());

            System.out.println(strings[0] + " "+ strings[1] + " " + entry.getValue());
        }

    }
}
