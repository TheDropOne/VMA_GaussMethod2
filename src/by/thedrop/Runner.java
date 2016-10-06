package by.thedrop;

import by.thedrop.entity.Matrix;

import java.io.File;

/**
 * Created by Kuryakov on 05-Oct-16.
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        Matrix matrix = new Matrix(new File("input.txt"));
        matrix.print();

    }
}
