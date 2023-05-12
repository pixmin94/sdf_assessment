package sdf;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

        FileReader fr = new FileReader(args[0]);
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
        System.out.println(wordPairs);

        // Map<String, Map<String, Value> finalMap = new HashMap<String, HashMap<String,Value>>();

    }
}
