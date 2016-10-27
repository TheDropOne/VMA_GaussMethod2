package by.thedrop.entity;

import by.thedrop.reader.Reader;

import java.io.File;
import java.util.List;

/**
 * Created by Kuryakov on 06-Oct-16.
 */
public class Matrix {

    private int matrixWidth;
    private int matrixHeight;
    public double[][] matrixArray;

    public Matrix(int matrixWidth, int matrixHeight, double[][] matrixArray) {
        this.matrixWidth = matrixWidth;
        this.matrixHeight = matrixHeight;
        this.matrixArray = matrixArray;
    }
    public Matrix(Matrix matrix){
        this.matrixWidth = matrix.matrixWidth;
        this.matrixHeight = matrix.matrixHeight;
        this.matrixArray = matrix.matrixArray;
    }

    public Matrix(File file) throws Exception {
        List<String> stringList = Reader.readListFromFile(file);
        this.matrixWidth = Reader.matrixWidth;
        this.matrixHeight = Reader.matrixHeight;
        this.matrixArray = Reader.readArrayFromList(stringList);
    }


    public void print() {
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                System.out.print(String.format("%-7s" , matrixArray[i][j]));
            }
            System.out.println();
        }
    }


    public double[][] getArray() {
        return matrixArray;
    }

    public double[] getLine(int i){
        return matrixArray[i];
    }

    public double getElement(int i, int j) {
        return matrixArray[i][j];
    }

    public int getMatrixWidth() {
        return matrixWidth;
    }

    public int getMatrixHeight() {
        return matrixHeight;
    }
}
