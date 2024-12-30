package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.util.Scanner;

public class dayFour {

    public static void readMatrix() {
    {
        Files file = new Files();
        file.readAllLines('day4/input.txt');

         try{
             for(int val = 0; val < matrix.length; val++)
              {
                for(int val2 = 0; val2< matrix[val].length; val++)
                  {
                     matrix[val][val2] = scan.next();
                  }
              }
            }
    scan.close();
    }
    }

    public static void main(String[] args) {
        readMatrix();
    }
}
