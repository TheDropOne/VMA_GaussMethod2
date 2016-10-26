package by.thedrop.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuryakov on 05-Oct-16.
 */
public class Reader {

    public static int matrixWidth;
    public static int matrixHeight;

    public Reader() {

    }

    public static List<String> readListFromFile(File file) throws Exception {
        List<String> inputList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tempString;
        while ((tempString = br.readLine()) != null) {
            inputList.add(tempString);
        }
        matrixWidth = inputList.get(1).split(" ").length;
        matrixHeight = inputList.size();
        return inputList;
    }

    public static double[][] readArrayFromList(List<String> list) {
        String[][] arrayStr = new String[matrixHeight][matrixWidth];
        double[][] array = new double[matrixHeight][matrixWidth];
        for (int i = 0; i < matrixHeight; i++) {
            arrayStr[i] = list.get(i).split(" ");
        }
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                array[i][j] = Double.parseDouble(arrayStr[i][j]);
            }
        }
        return array;
    }
}
