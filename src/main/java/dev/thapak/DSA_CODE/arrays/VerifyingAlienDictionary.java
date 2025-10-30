package dev.thapak.DSA_CODE.arrays;


import java.util.HashMap;

public class VerifyingAlienDictionary {
    public static void main(String[] args) {
        String[] strArr = new String[]{"hello", "leetcode"};

        String order = "hlabcdefgijkmnopqrstuvwxyz";

        boolean dictionary = isAlienDictionarySorted(strArr, order);
        System.out.println(dictionary);
    }

    private static boolean isAlienDictionarySorted(String[] words, String order) {

        HashMap<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }


        outerLoop:
        for (int i = 0; i < words.length - 1; i++) {

            String currentStr = words[i];
            String nextStr = words[i + 1];

            int minLength = Math.min(currentStr.length(), nextStr.length());


            // e.g, batman , bat
            if (currentStr.length() > nextStr.length() && currentStr.substring(0, nextStr.length()).equals(nextStr))
                return false;

            innerLoop:
            for (int j = 0; j < minLength; j++) {
                char currentStrCh = currentStr.charAt(j);
                char nextStrCh = nextStr.charAt(j);

                int orderOfCurrentStrChar = orderMap.get(currentStrCh);
                int orderOfNextStrChar = orderMap.get(nextStrCh);

                if (orderOfCurrentStrChar > orderOfNextStrChar) return false;

                if (orderOfCurrentStrChar < orderOfNextStrChar) {
                    break innerLoop;
                }

            }

        }

        return true;
    }
}
