package sdf;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String directory = args[0];
        List<Path> pathList = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(Paths.get(directory))) {
        pathList = stream.map(Path::normalize)
            .filter(Files::isRegularFile)
            .skip(1)
            .collect(Collectors.toList());
        }
        // pathList.forEach(System.out::println);

        for (Path path : pathList) {
            File filename = new File(path.toString());
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> wordsList = new ArrayList<>();
            br.lines()
                .map(line -> line.trim().toLowerCase().replaceAll("\\p{Punct}", ""))
                .map(line -> line.split("\\s+"))
                .flatMap(w -> Arrays.asList(w).stream())
                .forEach(w -> wordsList.add(w))
                ;
            String[] wordsArray = wordsList.toArray(new String[0]);
            // System.out.println(wordsArray);
            
            Map<String, ArrayList<String>> wordPairs = new HashMap<String, ArrayList<String>>(); 

            for (int i = 0; i < wordsArray.length-1; i++) {
                wordPairs.computeIfAbsent(wordsArray[i], k -> new ArrayList<>()).add(wordsArray[i+1]);
            }
            // System.out.println(wordPairs);

            // Map<String, Map<String, Value> finalMap = new HashMap<String, HashMap<String,Value>>();
            for (Map.Entry<String, ArrayList<String>> set : wordPairs.entrySet()) {
                Map<String, Double> innerMap = new HashMap<>();
                for (String word : set.getValue()) {
                    Double count = innerMap.getOrDefault(word, 0.0);
                    innerMap.put(word, count + 1);
                }
                Double totalCount = Double.valueOf(set.getValue().size());
                for (Map.Entry<String, Double> item : innerMap.entrySet()) {
                    String word = item.getKey();
                    double count = item.getValue();
                    double percentage = (count / totalCount);
                    innerMap.put(word, percentage);
                }

                System.out.println(set.getKey());
                System.out.println("   " + innerMap);
            }

        }

    }

}