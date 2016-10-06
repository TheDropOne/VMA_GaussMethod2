package by.thedrop.entity;

import by.thedrop.reader.Reader;

import java.io.File;
import java.util.List;

/**
 * Created by Kuryakov on 06-Oct-16.
 */
public class Matrix {

    private int matrixSize;
    private double[][] matrixArray;

    public Matrix(int matrixSize, double[][] matrixArray) {
        this.matrixSize = matrixSize;
        this.matrixArray = matrixArray;
    }

    public Matrix(File file) throws Exception {
        List<String> stringList = Reader.readListFromFile(file);
        this.matrixSize = Reader.matrixSize;
        this.matrixArray = Reader.readArrayFromList(stringList);
    }


    public  void print() {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrixArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return matrixSize;
    }

    public double[][] getArray() {
        return matrixArray;
    }

    public double getElement(int i, int j) {
        return matrixArray[i][j];
    }
}
