/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmierübung7;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Marc
 */
public class SolidFileIO {
    
    private static LinkedList<Cube> list;

    public static Cube[] readSolids(String fileName) throws IOException {
        list = new LinkedList<>();
        int number = 1;
        String line;
        
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split("[: ]");
//
            switch (tokens[0]) { // is it a Cube, a Sphere or a Cylinder?
                case "C":
                    int s1 = Integer.parseInt(tokens[2]);
                    int s2 = Integer.parseInt(tokens[3]);
                    int s3 = Integer.parseInt(tokens[4]);
                    list.add(new Cube(number, s1, s2, s3));
                    break;
                default:
                    break;
            }
            number++;
        }
        return list.toArray(new Cube[list.size()]
        );
    }
}
