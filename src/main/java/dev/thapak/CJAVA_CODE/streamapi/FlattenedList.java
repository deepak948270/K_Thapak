package dev.thapak.CJAVA_CODE.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenedList {
    public static void main(String[] args) {
        List<String> listOfString = List.of("hello world", "java springBoot", "hi daddy");

        /*List<String> flattenedList = listOfString.stream().flatMap((str) -> {
            String[] splitArr = str.split("\\s");

            return Arrays.stream(splitArr);

        }).collect(Collectors.toList());
*/

        List<String> flattenedList = listOfString
                .stream()
                .flatMap(str -> Arrays.stream(str.split("\\s")))
                .collect(Collectors.toList());

        System.out.println(flattenedList);
    }
}
