package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class dayOne {

    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(
                new FileReader("./dayone.txt")
            )
        ) {
            String row;
            ArrayList<Integer> cols1 = new ArrayList<>();
            ArrayList<Integer> cols2 = new ArrayList<>();
            while ((row = br.readLine()) != null) {
                String[] cols = row.split("\\s+");
                cols1.add(Integer.parseInt(cols[0]));
                cols2.add(Integer.parseInt(cols[1])); // add the second column to the list
            }
            Collections.sort(cols1);
            Collections.sort(cols2);

            HashMap<Integer, Integer> freq = new HashMap<>();
            int sum = 0;
            int sumFrequency = 0;
            for (int i = 0; i < cols1.size(); i++) {
                int l = cols1.get(i);
                int r = cols2.get(i);
                int lFrequency = Collections.frequency(cols2, l);
                freq.put(l, lFrequency);
                sumFrequency += (lFrequency * l);
                sum += Math.abs(l - r);
            }
            System.out.println(sum);
            System.out.println(sumFrequency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
