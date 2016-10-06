package by.thedrop.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuryakov on 05-Oct-16.
 */
public class Reader {

    public static int matrixSize;

    public Reader(){
    }

    public static List<String> readListFromFile(File file) throws Exception {
        List<String> inputList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tempString;
        while ((tempString = br.readLine()) != null) {
            inputList.add(tempString);
        }
        if (inputList.size() != inputList.get(0).split(" ").length) {
            throw new Exception("Matrix not square!");
        } else {
            matrixSize = inputList.size();
        }
        return inputList;
    }

    public static double[][] readArrayFromList(List<String> list){
        String[][] arrayStr = new String[matrixSize][matrixSize];
        double[][] array = new double[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            arrayStr[i] = list.get(i).split(" ");
        }
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                array[i][j] = Double.parseDouble(arrayStr[i][j]);
            }
        }
        return array;
    }
}
