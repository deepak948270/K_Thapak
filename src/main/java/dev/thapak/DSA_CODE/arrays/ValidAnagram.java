package dev.thapak.DSA_CODE.arrays;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = isAnagram2(s, t);
        System.out.println(isAnagram);

    }


    public static boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) - 1);
        }

        for (int value : frequencyMap.values()) {
            if (value != 0) {
                return false;
            }

        }

        return true;


    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
