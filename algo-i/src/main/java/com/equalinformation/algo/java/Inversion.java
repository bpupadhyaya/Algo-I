package com.equalinformation.algo.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpupadhyaya on 6/18/16.
 */
public class Inversion {
    public static void main(String...args) throws IOException {
        if(args.length > 0) {
            File file = new File(args[0]);
            readFile(file);
        } else {
            System.err.println("File not found");
        }
    }

    private static void readFile(File file) throws IOException {
        //TODO use divide and conquer algo

        List<Integer> numbers = new ArrayList<Integer>();

        FileInputStream fis = new FileInputStream((file));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while((line = br.readLine()) != null) {
            numbers.add(new Integer(line));
        }

        int count = numbers.size();
        int[] intArray = new int[count];
        int k = 0;
        for(Integer num: numbers) {
            intArray[k++] = num.intValue();
        }

        for(int num: intArray) {
            System.out.println(num);
        }

        long inversionCount = 0;
        for(int i = 0; i < count; ++i) {
            for(int j = i+1; j < count; j++) {
                if(intArray[i] > intArray[j]) {
                    inversionCount += 1;
                }
            }
        }

        System.out.println("Inversion count: "+ inversionCount);

        br.close();
    }
}
