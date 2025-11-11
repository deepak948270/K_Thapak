package dev.thapak.DSA_CODE.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        ArrayList<String> listOfStr = new ArrayList<>();
        listOfStr.add("ab");
        listOfStr.add("b");
        listOfStr.add("c");
        listOfStr.add("abc");

//        encodeAndDecodeStrings(listOfStr);

        String encoded = encode(listOfStr);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);


    }

    // Encode list of strings to a single string
    private static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode encoded string back to list
    private static List<String> decode(String encoded) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < encoded.length()) {
            int j = i;
            // find the '#' that separates length and string
            while (encoded.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(encoded.substring(i, j));
            i = j + 1; // move past '#'
            String str = encoded.substring(i, i + length);
            result.add(str);
            i += length;
        }

        return result;
    }

    private static void encodeAndDecodeStrings(ArrayList<String> listOfStr) {
        StringBuffer encodedBuffer = new StringBuffer();
        for (String str : listOfStr) {
            encodedBuffer.append(str + "#");
        }

        System.out.println(encodedBuffer);

        String encodedBufferString = encodedBuffer.toString();

        String[] decodedStrArray = encodedBufferString.split("#");
        List<String> listOfDecodedStr = Arrays.asList(decodedStrArray);
        System.out.println(listOfDecodedStr);
    }
}
