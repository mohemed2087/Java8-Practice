import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Application {

    public static void main(String[] args) throws IOException {



        // Java word Count
        //  wordCount("/root/data/data.txt");

        List <Integer> myList = Arrays.asList(2,5,67,4,43,2,4,56);

        myList.stream().sorted().forEach(System.out::println);
        myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    // WordCount - Streams
    public static void wordCount(String filePath) throws IOException {

        List<String> lines;

        lines =  Files.readAllLines(Paths.get(filePath),StandardCharsets.UTF_8);

        lines.stream().map(i -> i.split(" ")).flatMap(i -> Arrays.stream(i)).collect(groupingBy(Function.identity(), counting())).entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}