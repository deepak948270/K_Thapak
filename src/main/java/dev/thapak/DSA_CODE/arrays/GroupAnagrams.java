package dev.thapak.DSA_CODE.arrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {

        String [] strs=new String[]{"eat","tea","tan","ate","nat","bat"};

        List<List<String>> groupedAnagrams = groupAnagramsOptimized(strs);
        System.out.println(groupedAnagrams);

    }

    public  static List<List<String>> groupAnagramsOptimized(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }

        Map<String, List> ansMap = new HashMap<>();

        int[] count = new int[26];

        for(String s:strs){
            Arrays.fill(count, 0);
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<26; i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)){
                ansMap.put(key,new ArrayList());

            }
            ansMap.get(key).add(s);

        }

        return new ArrayList(ansMap.values());

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();

        if (strs == null || strs.length == 0)
            return resultList;

        if (strs.length == 1) {
            resultList.add(Arrays.asList(strs[0]));
            return resultList;
        }

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue;

            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }

            resultList.add(list);
        }

        return resultList;
    }


    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> fMap = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            fMap.put(ch, fMap.getOrDefault(ch, 0) - 1);
        }

        for (int count : fMap.values()) {
            if (count != 0)
                return false;
        }

        return true;
    }
}
